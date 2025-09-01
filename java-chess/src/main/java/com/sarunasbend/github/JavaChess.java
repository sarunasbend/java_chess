package com.sarunasbend.github;

import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.ui.ChessUIManager;
import com.sarunasbend.github.ui.UIManager;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class JavaChess {
    public static UIManager uiManager = new UIManager();
    public static ChessUIManager chessUiManager = new ChessUIManager();
    public static GameState gameState = new GameState(Constants.WHITE_PIECE);

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp(){
        Debug.info("Initialising Project...");
        uiManager.init();
        Debug.info("Creating Chess Logic...");
        gameState.init();
        Debug.info("Creating Chess UI...");
        chessUiManager.init();
    }
}