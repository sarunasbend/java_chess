package com.sarunasbend.github;

import javax.swing.JFrame;

import com.sarunasbend.github.logic.Chessboard;
import com.sarunasbend.github.ui.ChessboardUI;
import com.sarunasbend.github.utility.Constants;

public class UIManager {
    private JFrame window;

    private ChessboardUI chessboardUI;

    public void init(){
        window = new JFrame();
        window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chessboardUI = new ChessboardUI(new Chessboard());
        chessboardUI.init();

        window.add(chessboardUI);
    }
}
