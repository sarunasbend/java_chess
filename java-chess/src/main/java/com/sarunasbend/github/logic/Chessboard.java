package com.sarunasbend.github.logic;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sarunasbend.github.utility.Constants;

public class Chessboard {
    private BufferedImage chessboardImage;

    public void init(){
        drawChessboard();
    }

    private void drawChessboard(){
        this.chessboardImage = new BufferedImage(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = this.chessboardImage.createGraphics();
        Graphics2D g2d = (Graphics2D) g;

        boolean isWhite = true;
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_ROWS;

        for (int row = 0; row < Constants.CHESSBOARD_HEIGHT; row++){
            for (int column = 0; column < Constants.CHESSBOARD_WIDTH; column++){
                if (isWhite){
                    g2d.setColor(Constants.WHITE_COLOUR);
                    g2d.fillRect(column * blockSize, row * blockSize, blockSize, blockSize);
                } else {
                    g2d.setColor(Constants.BLACK_COLOR);
                    g2d.fillRect(column * blockSize, row * blockSize, blockSize, blockSize);
                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }

        g2d.dispose();
    }

    public BufferedImage getChessboardImage(){return this.chessboardImage;}
}
