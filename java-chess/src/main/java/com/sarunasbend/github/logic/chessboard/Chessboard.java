package com.sarunasbend.github.logic.chessboard;

import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sarunasbend.github.utility.Constants;

public class Chessboard {
    private BufferedImage chessboardImage;

    private Font font;

    public void init(){
        drawWhiteChessboard();
    }

    private void drawWhiteChessboard(){
        this.chessboardImage = new BufferedImage(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = this.chessboardImage.createGraphics();
        Graphics2D g2d = (Graphics2D) g;

        boolean isWhite = true;
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_RANKS;

        for (int row = 0; row < Constants.CHESSBOARD_RANKS; row++){
            for (int column = 0; column < Constants.CHESSBOARD_FILES; column++){
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

        this.font = g2d.getFont();
        this.font = this.font.deriveFont(this.font.getSize() * 2.0f);
        g2d.setFont(this.font);

        FontMetrics fm = g2d.getFontMetrics(this.font);
        int padding = 5;
        
        for (int row = Constants.CHESSBOARD_RANKS; row > 0; row--){
            if (row % 2 != 0){
                g2d.setColor(Constants.BLACK_COLOR);
            } else {
                g2d.setColor(Constants.WHITE_COLOUR);
            }
            g2d.drawString(Integer.toString(Constants.CHESSBOARD_RANKS - row + 1), 0, (row * blockSize) - 1);
        }

        for (int column = 0; column < Constants.CHESSBOARD_FILES; column++) {
            if (column % 2 != 0) {
                g2d.setColor(Constants.BLACK_COLOR);
            } else {
                g2d.setColor(Constants.WHITE_COLOUR);
            }

            String text = Character.toString((char) (column + 65));
            
            int x = (column * blockSize) + blockSize - fm.stringWidth(text) - 1;
            int y = Constants.CHESSBOARD_HEIGHT - fm.getDescent() + padding;

            g2d.drawString(text, x, y);
        }
        g2d.dispose();
    }

    private void drawBlackChessboard(){
        this.chessboardImage = new BufferedImage(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = this.chessboardImage.createGraphics();
        Graphics2D g2d = (Graphics2D) g;

        boolean isBlack = true;
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_RANKS;

        for (int row = Constants.CHESSBOARD_RANKS; row >= 0; row--){
            for (int column = Constants.CHESSBOARD_FILES; column >= 0; column--){
                if (!isBlack){
                    g2d.setColor(Constants.BLACK_COLOR);
                    g2d.fillRect(column * blockSize, row * blockSize, blockSize, blockSize);
                } else {
                    g2d.setColor(Constants.WHITE_COLOUR);
                    g2d.fillRect(column * blockSize, row * blockSize, blockSize, blockSize);
                }
                isBlack = !isBlack;
            }
        }

        this.font = g2d.getFont();
        this.font = this.font.deriveFont(this.font.getSize() * 2.0f);
        g2d.setFont(this.font);

        FontMetrics fm = g2d.getFontMetrics(this.font);
        int padding = 5;

        for (int row = 1;  row <= Constants.CHESSBOARD_RANKS; row++) {
            if (row % 2 == 0) {
                g2d.setColor(Constants.WHITE_COLOUR);
            } else {
                g2d.setColor(Constants.BLACK_COLOR);
            }
            g2d.drawString(Integer.toString(row), 0, (row * blockSize) - 1);
        }

        for (int column = 0; column < Constants.CHESSBOARD_FILES; column++) {
            if (column % 2 == 0) {
                g2d.setColor(Constants.WHITE_COLOUR);
            } else {
                g2d.setColor(Constants.BLACK_COLOR);
            }

            String text = Character.toString((char) ('H' - column));

            int x = (column * blockSize) + blockSize - fm.stringWidth(text) - 1;
            int y = Constants.CHESSBOARD_HEIGHT - fm.getDescent() + padding;

            g2d.drawString(text, x, y);
        }
        g2d.dispose();
    }

    public BufferedImage getChessboardImage(){return this.chessboardImage;}
}
