package com.sarunasbend.github;

import javax.swing.JFrame;

import com.sarunasbend.github.logic.Chessboard;
import com.sarunasbend.github.logic.pieces.Pieces;
import com.sarunasbend.github.ui.ChessboardUI;
import com.sarunasbend.github.ui.PiecesUI;
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

        Chessboard chessboard = ChessManager.getChessboard();
        chessboardUI = new ChessboardUI(chessboard);
        chessboardUI.init();
        window.add(chessboardUI);

        Pieces whitePieces = ChessManager.getWhitePieces();
        Pieces blackPieces = ChessManager.getBlackPieces();
        piecesUI = new PiecesUI(whitePieces, blackPieces);
        piecesUI.init();
    }
}
