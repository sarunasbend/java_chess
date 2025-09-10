package com.sarunasbend.github.logic.gamestate;

import com.sarunasbend.github.logic.movevalidator.*;
import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.logic.pieces.Bishop;
import com.sarunasbend.github.logic.pieces.King;
import com.sarunasbend.github.logic.pieces.Knight;
import com.sarunasbend.github.logic.pieces.Pawn;
import com.sarunasbend.github.logic.pieces.Piece;
import com.sarunasbend.github.logic.pieces.Queen;
import com.sarunasbend.github.logic.pieces.Rook;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class GameState {
    public static String[][] chessboard_grid;
    public static Chessboard chessboard;

    public static MoveValidator moveValidator;

    private int playerColour;

    public GameState(int playerColour){
        this.playerColour = playerColour;
        chessboard_grid = new String[Constants.CHESSBOARD_RANKS][Constants.CHESSBOARD_FILES];
        chessboard = new Chessboard();
        chessboard.init();
        moveValidator = new MoveValidator();
        moveValidator.init();
    }

    public void init(){
        addListeners();
        printChessboard();
    }

    private void addListeners(){
    }

    public void printChessboard(){
        for (int i = 0; i < chessboard_grid.length; i++) {
            System.out.print((8 - i) + " ");
            
            for (int j = 0; j < chessboard_grid[i].length; j++) {
                System.out.print(chessboard_grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("  ");
        for (char c = 'A'; c <= 'H'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
