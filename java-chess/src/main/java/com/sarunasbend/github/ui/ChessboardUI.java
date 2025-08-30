package com.sarunasbend.github.ui;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

import com.sarunasbend.github.logic.Chessboard;
import com.sarunasbend.github.utility.Constants;

public class ChessboardUI extends JPanel {
    private Chessboard chessboard;

    public ChessboardUI(Chessboard chessboard){
        this.chessboard = chessboard;
    }

    public void init(){
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g){
        boolean isWhite = true;
        int blockSize = Constants.WINDOW_HEIGHT / Constants.CHESSBOARD_WIDTH;

        for (int row = 0; row < Constants.CHESSBOARD_HEIGHT; row++){
            for (int column = 0; column < Constants.CHESSBOARD_WIDTH; column++){
                if (isWhite){
                    g.setColor(Color.PINK);
                    g.drawRect(row * blockSize, column * blockSize, blockSize, blockSize);
                    g.fillRect(row * blockSize, column * blockSize, blockSize, blockSize);
                } else {
                    g.setColor(Color.BLACK);
                    g.drawRect(row * blockSize, column * blockSize, blockSize, blockSize);
                    g.fillRect(row * blockSize, column * blockSize, blockSize, blockSize);
                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
    }
}
