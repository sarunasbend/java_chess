package com.sarunasbend.github.bridge;

public class IPCEvents {
    // just an example of possible events
    public static class UI {
        private static final String PREFIX = "chessboard.";
        
        public static final String UPDATE_UI = PREFIX + "updateUI";
        public static final String PIECE_MOVING = PREFIX + "pieceMoving";
    }

    public static class Validator {
        private static final String PREFIX = "moveValidator.";

        public static final String CHECK_VALID = PREFIX + "checkValid";
    }

    public static class State {
        private static final String PREFIX = "gameState.";

        public static final String PIECE_SELECTED = PREFIX + "pieceSelected";
        public static final String PIECE_DESELECTED = PREFIX + "pieceDeselected";
    }
}
