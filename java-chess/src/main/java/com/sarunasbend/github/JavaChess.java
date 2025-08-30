package com.sarunasbend.github;

import com.sarunasbend.github.logic.Chessboard;
import com.sarunasbend.github.utility.debug.Debug;

public class JavaChess {
    private static UIManager uiManager = new UIManager();
    private static Chessboard chessboard = new Chessboard();

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp(){
        Debug.info("Initialising Project");
        Debug.info("Initialising UI");
        uiManager.init();
        chessboard.init();
    }

    public static Chessboard getChessboard(){return chessboard;}
}