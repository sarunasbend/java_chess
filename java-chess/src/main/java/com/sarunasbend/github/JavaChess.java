package com.sarunasbend.github;

import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.ui.ChessUIManager;
import com.sarunasbend.github.ui.UIManager;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class JavaChess {
    private static UIManager uiManager = new UIManager();
    private static ChessUIManager chessManager = new ChessUIManager();
    private static GameState gameState = new GameState(Constants.WHITE_PIECE);
    public static void main(String[] args) {
        startUp();
    }

    public static void startUp(){
        Debug.info("Initialising Project");
        uiManager.init();
        Debug.info("Creating Chess Logic");
        gameState.init();
        gameState.printChessboard();
    }
}