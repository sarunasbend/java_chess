package com.sarunasbend.github.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import com.sarunasbend.github.utility.debug.Debug;

public class IPCLogic {
    private static final Map<String, List<Function<Object[], Object>>> channelHandlers = new ConcurrentHashMap<>();
    private static final Map<String, List<CompletableFuture<Object>>> pendingRequests = new ConcurrentHashMap<>();

    /** 
     * Sends a message to the UI
     * @param channel The channel to send the message to
     * @param args The arguments to send
     */
    public static void send(String channel, Object... args) {
        IPCUI.receive(channel, args);
    }

    /** 
     * Sends a message to Logic (self)
     * @param channel The channel to send the message to
     * @param args The arguments to send
     */
    public static void sendSelf(String channel, Object... args) {
        IPCLogic.receive(channel, args);
    }

    /** 
     * Handles a message from the UI
     * You should return null if no response is needed
     * Note: if a handler is already registered for the channel, it will be overwritten
     * @param channel The channel to handle the message from
     * @param handler The handler to handle the message
     */
    public static void handle(String channel, Function<Object[], Object> handler) {
        List<Function<Object[], Object>> callbacks = channelHandlers.get(channel);

        if (callbacks != null) {
            callbacks.add(handler);
            channelHandlers.put(channel, callbacks);
        } else {
            channelHandlers.put(channel, new ArrayList<>(Arrays.asList(handler)));
        }

        Debug.log("Regsitered IPCLogic handler for " + channel);
    }

    /** 
     * Invokes a message to the UI - this provides a response, unlike send
     * @param channel The channel to invoke the message to
     * @param args The arguments to send
     * @return A CompletableFuture that will be completed when the UI responds
     */
    public static CompletableFuture<Object> invoke(String channel, Object... args) {
        String requestId = UUID.randomUUID().toString();
        CompletableFuture<Object> future = new CompletableFuture<>();

        List<CompletableFuture<Object>> futures = pendingRequests.get(channel);

        if (futures != null) {
            futures.add(future);
            pendingRequests.put(requestId, futures);
        } else {
            pendingRequests.put(requestId, new ArrayList<>(Arrays.asList(future)));
        }

        IPCUI.receiveInvoke(channel, args, requestId);
        
        return future;
    }

    // Handles receiving messages from the UI
    static void receive(String channel, Object[] args) {
        List<Function<Object[], Object>> handlers = channelHandlers.get(channel);
        if (handlers == null) return;

        for (Function<Object[], Object> handler : handlers) {
            handler.apply(args);
        }
    }

    // Handles receiving invoke messages from the UI and resolves them through IPCUI
    static void receiveInvoke(String channel, Object args[], String requestId) {
        List<Function<Object[], Object>> handlers = channelHandlers.get(channel);

        if (handlers != null) {
            Function<Object[], Object> handler = handlers.get(0);
            Object response = handler.apply(args);
            IPCLogic.resolveInvoke(requestId, response);
        } else {
            Debug.error("No handler found for channel: " + channel);
        }
    }

    // Resolves invoke messages from the UI
    static void resolveInvoke(String requestId, Object response) {
        List<CompletableFuture<Object>> futures = pendingRequests.remove(requestId);
        if (futures == null) return;

        for (CompletableFuture<Object> future : futures) {
            future.complete(response);
        }
    }
}
