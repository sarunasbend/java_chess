package com.sarunasbend.github.bridge;

public class IPCEvents {
    // user zooms in/out or moves it around on chessboard
    public static class Chessboard {
        private static final String PREFIX = "chessboard.";

        public static final String CHESSBOARD_MOVED = PREFIX + "chessboardMoved";
        public static final String SHOW_AVAILABLE_MOVES = PREFIX + "showAvailableMoves";
        public static final String CLEAR_AVAILABLE_MOVES = PREFIX + "clearAvailableMoves";
    }
}
