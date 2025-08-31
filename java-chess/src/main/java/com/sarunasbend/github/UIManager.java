package com.sarunasbend.github;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.sarunasbend.github.logic.Chessboard;
import com.sarunasbend.github.logic.pieces.Pieces;
import com.sarunasbend.github.ui.ChessboardUI;
import com.sarunasbend.github.ui.PiecesUI;
import com.sarunasbend.github.ui.pieces.PieceUI;
import com.sarunasbend.github.utility.Constants;

public class UIManager {
    private JFrame window;

    private ChessboardUI chessboardUI;
    private PiecesUI piecesUI;

    public void init(){
        window = new JFrame();

        Chessboard chessboard = ChessManager.getChessboard();
        chessboardUI = new ChessboardUI(chessboard);
        chessboardUI.init();

        Pieces whitePieces = ChessManager.getWhitePieces();
        whitePieces.init();
        Pieces blackPieces = ChessManager.getBlackPieces();
        blackPieces.init();
        piecesUI = new PiecesUI(whitePieces, blackPieces);
        piecesUI.init();
        
        JLayeredPane pane = new JLayeredPane();
        pane.add(chessboardUI, JLayeredPane.DEFAULT_LAYER);
        
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_ROWS;

        for (PieceUI chesspiece : piecesUI.getPiecesUIs()) {
            String startPos = chesspiece.getPiece().getId();

            int column = startPos.charAt(0) - 'A';
            int row = Character.getNumericValue(startPos.charAt(1)) - 1; 

            int flippedRow = (Constants.CHESSBOARD_ROWS - 1) - row;

            int x = column * blockSize;
            int y = flippedRow * blockSize;

            chesspiece.setBounds(x, y, blockSize, blockSize);
            pane.add(chesspiece, JLayeredPane.PALETTE_LAYER);
        }

        window.add(pane);
        window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
    }
}
