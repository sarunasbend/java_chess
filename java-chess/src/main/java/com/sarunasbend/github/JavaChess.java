package com.sarunasbend.github;

import com.sarunasbend.github.utility.debug.Debug;

public class JavaChess {
    private static UIManager uiManager = new UIManager();
    private static ChessManager chessManager = new ChessManager();

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp(){
        Debug.info("Initialising Project");
        uiManager.init();
        Debug.info("Creating Chess Logic");
        chessManager.init();
    }
}