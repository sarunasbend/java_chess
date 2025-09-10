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
    // creation of bufferedimage
    public static Chessboard chessboard;
    
    // tracks the game 
    public static Piece[][] game = new Piece[Constants.CHESSBOARD_RANKS][Constants.CHESSBOARD_FILES];
    
    public static MoveValidator moveValidator;

    private int playerColour;
    private int oppositeColour;

    public GameState(int playerColour){
        this.playerColour = playerColour;

        if (playerColour == Constants.WHITE_PIECE){
            this.oppositeColour = Constants.BLACK_PIECE;
        } else if (playerColour == Constants.BLACK_PIECE) {
            this.oppositeColour = Constants.WHITE_PIECE;
        }

        chessboard = new Chessboard();
        chessboard.init(playerColour);

        moveValidator = new MoveValidator();
        moveValidator.init();
    }

    public void init(){
        addListeners();
        setUpChessBoard();
    }

    private void addListeners(){

    }

    // adds the pieces to the chessboard
    private void setUpChessBoard(){
        for (int file = 0; file < Constants.CHESSBOARD_FILES; file++){
            game[file][6] = new Pawn(playerColour, 6, file);
            game[file][1] = new Pawn(oppositeColour, 1, file);
        }

        // manually adding the pieces for the time being 
        game[0][7] = new Rook(playerColour, 0, 7);
        game[7][7] = new Rook(playerColour, 7, 7);
        game[1][7] = new Knight(playerColour, 1, 7);
        game[6][7] = new Knight(playerColour, 6, 7);
        game[2][7] = new Bishop(playerColour, 2, 7);
        game[5][7] = new Bishop(playerColour, 5, 7);
        game[3][7] = new Queen(playerColour, 3, 7);
        game[4][7] = new King(playerColour, 4, 7);

        // opponents pieces'
        game[0][0] = new Rook(oppositeColour, 0, 0);
        game[7][0] = new Rook(oppositeColour, 7, 0);
        game[1][0] = new Knight(oppositeColour, 1, 0);
        game[6][0] = new Knight(oppositeColour, 6, 0);
        game[2][0] = new Bishop(oppositeColour, 2, 0);
        game[5][0] = new Bishop(oppositeColour, 5, 0);
        game[3][0] = new Queen(oppositeColour, 3, 0);
        game[4][0] = new King(oppositeColour, 4, 0);

    }
}
