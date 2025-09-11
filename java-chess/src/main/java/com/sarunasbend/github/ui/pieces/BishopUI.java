package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.Bishop;
import com.sarunasbend.github.utility.Constants;

public class BishopUI extends PieceUI {
    public BishopUI(Bishop bishop){
        super(bishop);
        init();
    }

    public void init(){
        if (getPiece().getColour() == Constants.WHITE_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\bishop.png"));
        } else if (getPiece().getColour() == Constants.BLACK_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\bishop1.png"));
        }
    }
}

