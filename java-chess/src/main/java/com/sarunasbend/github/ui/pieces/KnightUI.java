package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.Knight;
import com.sarunasbend.github.utility.Constants;

public class KnightUI extends PieceUI{
    public KnightUI(Knight knight){
        super(knight);
        init();
    }

    public void init(){
        if (getPiece().getColour() == Constants.WHITE_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\knight.png"));
        } else if (getPiece().getColour() == Constants.BLACK_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\knight1.png"));
        }
    }
}
