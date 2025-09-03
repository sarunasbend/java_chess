package com.sarunasbend.github.ui;

import javax.swing.JLayeredPane;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCUI;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.ui.chessboard.ChessboardUI;
import com.sarunasbend.github.ui.pieces.PiecesUI;
import com.sarunasbend.github.ui.pieces.piece.PieceUI;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class ChessUIManager extends JLayeredPane {
    private ChessboardUI chessboardUI;
    private PiecesUI piecesUI;

    public ChessUIManager(){

    }

    public void init(){
        configuration();
        addEventListeners();

        chessboardUI = new ChessboardUI(GameState.chessboard);
        chessboardUI.setBounds(0,0, Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT);
        chessboardUI.init();

        add(chessboardUI, JLayeredPane.DEFAULT_LAYER);

        piecesUI = new PiecesUI(GameState.whitePieces, GameState.blackPieces);
        piecesUI.init();

        placeStartingChessPieces();
    }

    public void configuration(){
        setSize(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT);
    }

    public void addEventListeners(){
        IPCUI.handle(IPCEvents.UI.PIECE_MOVING, (args) -> {
            return null;
        });
    }

    public void placeStartingChessPieces(){
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_ROWS;
        int count = 0;
        for (PieceUI piece : piecesUI.getPiecesUIs()){
            count++;
            String curPos = piece.getPiece().getPos();

            int column = curPos.charAt(0) - 'A';
            int row = Character.getNumericValue(curPos.charAt(1)) - 1; 

            int flippedRow = (Constants.CHESSBOARD_ROWS - 1) - row;

            int x = column * blockSize;
            int y = flippedRow * blockSize;

            piece.setBounds(x, y, blockSize, blockSize);
            add(piece, JLayeredPane.PALETTE_LAYER);
        } 
        Debug.info(Integer.toString(count));
    }

    public void updateChessPieces(){
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_ROWS;

        for (PieceUI piece : piecesUI.getPiecesUIs()){
            String curPos = piece.getPiece().getPos();

            int column = curPos.charAt(0) - 'A';
            int row = Character.getNumericValue(curPos.charAt(1)) - 1; 

            int flippedRow = (Constants.CHESSBOARD_ROWS - 1) - row;

            int x = column * blockSize;
            int y = flippedRow * blockSize;

            piece.setBounds(x, y, blockSize, blockSize);
        }

        revalidate();
    }
}
