package com.sarunasbend.github;

import java.awt.GridLayout;

import javax.swing.JFrame;

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
        window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout());

        // Chessboard chessboard = ChessManager.getChessboard();
        // chessboardUI = new ChessboardUI(chessboard);
        // chessboardUI.init();
        // window.add(chessboardUI);

        Pieces whitePieces = ChessManager.getWhitePieces();
        whitePieces.init();
        Pieces blackPieces = ChessManager.getBlackPieces();
        blackPieces.init();
        piecesUI = new PiecesUI(whitePieces, blackPieces);
        piecesUI.init();
        
        for (PieceUI piece : piecesUI.getPiecesUIs()){
            window.add(piece);
        }
    }
}
