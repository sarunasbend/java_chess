package com.sarunasbend.github.logic.gamestate;

import com.sarunasbend.github.logic.movevalidator.*;
import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.logic.pieces.Pieces;
import com.sarunasbend.github.logic.pieces.piece.Bishop;
import com.sarunasbend.github.logic.pieces.piece.King;
import com.sarunasbend.github.logic.pieces.piece.Knight;
import com.sarunasbend.github.logic.pieces.piece.Pawn;
import com.sarunasbend.github.logic.pieces.piece.Piece;
import com.sarunasbend.github.logic.pieces.piece.Queen;
import com.sarunasbend.github.logic.pieces.piece.Rook;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class GameState {
    public static Pieces whitePieces;
    public static Pieces blackPieces;
    public static String[][] chessboard_grid;
    public static Chessboard chessboard;

    public static MoveValidator moveValidator;

    // the piece that is currently selected
    // and the desired position for the piece to move
    public static Piece currentlySelectedPiece;
    public static String positionToMove;
    
    private int playerColour;

    public GameState(int playerColour){
        this.playerColour = playerColour;
        chessboard_grid = new String[Constants.CHESSBOARD_ROWS][Constants.CHESSBOARD_COLUMNS];
        whitePieces = new Pieces(Constants.WHITE_PIECE);
        whitePieces.init();
        blackPieces = new Pieces(Constants.BLACK_PIECE);
        blackPieces.init();
        chessboard = new Chessboard();
        chessboard.init();
        moveValidator = new MoveValidator();
        moveValidator.init();
    }

    public void init(){
        setupChessboard();
        addListeners();
        printChessboard();
    }

    private void addListeners(){
        // to track the currently selected piece
        IPCLogic.handle(IPCEvents.State.PIECE_SELECTED, (args) ->{
            currentlySelectedPiece = (Piece) args[0];
            positionToMove = (String) args[1];
            currentlySelectedPiece.onMove(chessboard_grid, positionToMove);

            return null;
        });

        IPCLogic.handle(IPCEvents.State.PIECE_DESELECTED, (args) -> {
            currentlySelectedPiece = null;
            positionToMove = null;
            
            return null;
        });
    }

    private void setupChessboard(){
        for (Piece piece : whitePieces.getPices()){
            // idk why i decided to do it like this, kinda annoying
            String startPos = piece.getId();
            int row = getRowFromPos(startPos);
            int column = getColumnFromPos(startPos);
            
            if (piece instanceof Pawn){
                chessboard_grid[column][row] = Constants.WHITE_PAWN;
            } else if (piece instanceof Bishop){
                chessboard_grid[column][row] = Constants.WHITE_BISHOP;
            } else if (piece instanceof Knight){
                chessboard_grid[column][row] = Constants.WHITE_KNIGHT;
            } else if (piece instanceof Rook){
                chessboard_grid[column][row] = Constants.WHITE_ROOK;
            } else if (piece instanceof Queen){
                chessboard_grid[column][row] = Constants.WHITE_QUEEN;
            } else if (piece instanceof King){
                chessboard_grid[column][row] = Constants.WHITE_KING;
            }
        }

        // defo could be a seperate function
        for (Piece piece : blackPieces.getPices()){
            String startPos = piece.getId();
            int row = getRowFromPos(startPos);
            int column = getColumnFromPos(startPos);

            if (piece instanceof Pawn){
                chessboard_grid[column][row] = Constants.BLACK_PAWN;
            } else if (piece instanceof Bishop){
                chessboard_grid[column][row] = Constants.BLACK_BISHOP;
            } else if (piece instanceof Knight){
                chessboard_grid[column][row] = Constants.BLACK_KNIGHT;
            } else if (piece instanceof Rook){
                chessboard_grid[column][row] = Constants.BLACK_ROOK;
            } else if (piece instanceof Queen){
                chessboard_grid[column][row] = Constants.BLACK_QUEEN;
            } else if (piece instanceof King){
                chessboard_grid[column][row] = Constants.BLACK_KING;
            }
        }
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

    public void addToChessboard(){
    
    }

    public void removeFromWhitePieces(String currentPos){
        GameState.whitePieces.removePiece(currentPos);        
    }

    public void removeFromBlackPieces(String currentPos){
        GameState.blackPieces.removePiece(currentPos);        
    }

    public static int getRowFromPos(String id){
        return id.charAt(0) - 'A';
    }

    public static int getColumnFromPos(String id){
        return 8 - Character.getNumericValue(id.charAt(1));
    }

    public static String getPosition(int row, int column){
        String pos = Character.toString((char) (row + 65));
        return pos + (Integer.toString(8 - (column + 1) + 1));
    }
}
