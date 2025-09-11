package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.Rook;
import com.sarunasbend.github.utility.Constants;

public class RookUI extends PieceUI {
    public RookUI(Rook rook){
        super(rook);
        init();
    }

    public void init(){
        if (getPiece().getColour() == Constants.WHITE_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\rook.png"));
        } else if (getPiece().getColour() == Constants.BLACK_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\rook1.png"));

        }
    }
}
