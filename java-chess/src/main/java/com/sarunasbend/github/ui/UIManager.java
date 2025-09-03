package com.sarunasbend.github.ui;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.sarunasbend.github.JavaChess;
import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.logic.pieces.Pieces;
import com.sarunasbend.github.ui.chessboard.ChessboardUI;
import com.sarunasbend.github.ui.pieces.PiecesUI;
import com.sarunasbend.github.ui.pieces.piece.PieceUI;
import com.sarunasbend.github.utility.Constants;

public class UIManager {
    private JFrame window;

    public void init(){
        window = new JFrame();        
        window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(JavaChess.chessUiManager);

    }
}
