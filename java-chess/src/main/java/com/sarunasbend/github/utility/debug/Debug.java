package com.sarunasbend.github.utility.debug;

public class Debug {
        private static LogLevel LOG_LEVEL = LogLevel.INFO;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREY = "\u001B[90m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void setLogLevel(LogLevel logLevel) {
        System.out.println("[LOGGING] Using log level: " + logLevel.getId());
        Debug.LOG_LEVEL = logLevel;
    }

    public static LogLevel getLogLevel() {
        return Debug.LOG_LEVEL;
    }

    public static void log(String msg) {
        if (Debug.LOG_LEVEL.getLevel() <= LogLevel.DEBUG.getLevel()) {
            System.out.println(Debug.ANSI_GREY + "[DEBUG] " + msg + Debug.ANSI_RESET);
        }
    }

    public static void info(String msg) {
        if (Debug.LOG_LEVEL.getLevel() <= LogLevel.INFO.getLevel()) {
            System.out.println(Debug.ANSI_WHITE + "[INFO] " + msg + Debug.ANSI_RESET);
        }
    }

    public static void warning(String msg) {
        if (Debug.LOG_LEVEL.getLevel() <= LogLevel.WARNING.getLevel()) {
            System.out.println(Debug.ANSI_YELLOW + "[WARNING] " + msg + Debug.ANSI_RESET);
        }
    }

    public static void error(String msg) {
        if (Debug.LOG_LEVEL.getLevel() <= LogLevel.ERROR.getLevel()) {
            System.out.println(Debug.ANSI_RED + "[ERRROR] " + msg + Debug.ANSI_RESET);
        }
    }
}
