package com.sarunasbend.github.logic;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

import com.sarunasbend.github.utility.Constants;

public class Chessboard {
    private BufferedImage chessboardImage;

    public void init(){
        drawChessboard();
    }

    private void drawChessboard(){
        this.chessboardImage = new BufferedImage(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = this.chessboardImage.createGraphics();

        boolean isWhite = true;
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_ROWS;

        for (int row = 0; row < Constants.CHESSBOARD_HEIGHT; row++){
            for (int column = 0; column < Constants.CHESSBOARD_WIDTH; column++){
                if (isWhite){
                    g.setColor(Constants.WHITE_COLOUR);
                    g.fillRect(column * blockSize, row * blockSize, blockSize, blockSize);
                } else {
                    g.setColor(Constants.BLACK_COLOR);
                    g.fillRect(column * blockSize, row * blockSize, blockSize, blockSize);
                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }

        g.dispose();

    }

    public BufferedImage getChessboardImage(){return this.chessboardImage;}
}
