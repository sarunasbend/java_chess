package com.sarunasbend.github.logic.gamestate;

import com.sarunasbend.github.logic.movevalidator.*;
import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.bridge.IPCUI;
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

    public static int playerColour;
    public static int oppositeColour;

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
        IPCUI.handle(IPCEvents.Chessboard.PIECE_MOVED, (args) -> {
            pieceMoved((int) args[0], (int) args[1], (int) args[2], (int) args[3]);
            return null;
        });
    }

    // adds the pieces to the chessboard
    private void setUpChessBoard(){
        for (int file = 0; file < Constants.CHESSBOARD_FILES; file++){
            game[6][file] = new Pawn(playerColour, 6, file);
            game[1][file] = new Pawn(oppositeColour, 1, file);
        }

        // manually adding the pieces for the time being 
        game[7][0] = new Rook(playerColour, 7, 0);
        game[7][7] = new Rook(playerColour, 7, 7);
        game[7][1] = new Knight(playerColour, 7, 1);
        game[7][6] = new Knight(playerColour, 7, 6);
        game[7][2] = new Bishop(playerColour, 7, 2);
        game[7][5] = new Bishop(playerColour, 7, 5);
        game[7][3] = new Queen(playerColour, 7, 3);
        game[7][4] = new King(playerColour, 7, 4);

        // opponents pieces
        game[0][0] = new Rook(oppositeColour, 0, 0);
        game[0][7] = new Rook(oppositeColour, 0, 7);
        game[0][1] = new Knight(oppositeColour, 0, 1);
        game[0][6] = new Knight(oppositeColour, 0, 6);
        game[0][2] = new Bishop(oppositeColour, 0, 2);
        game[0][5] = new Bishop(oppositeColour, 0, 5);
        game[0][3] = new Queen(oppositeColour, 0, 3);
        game[0][4] = new King(oppositeColour, 0, 4);

    }

    private void pieceMoved(int prevRank, int prevFile, int newRank, int newFile){
        game[newRank][newFile] = game[prevRank][prevFile];
        game[prevRank][prevFile] = null;
        IPCLogic.send(IPCEvents.Chessboard.UPDATE_UI);
    }
}
