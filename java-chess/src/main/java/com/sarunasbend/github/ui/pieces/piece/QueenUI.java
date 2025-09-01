package com.sarunasbend.github.ui.pieces.piece;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.Queen;
import com.sarunasbend.github.utility.Constants;

public class QueenUI extends PieceUI {
    public QueenUI(Queen queen){
        super(queen);
        init();
    }

    public void init(){
        if (getPiece().getColour() == Constants.WHITE_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\queen.png"));
        } else if (getPiece().getColour() == Constants.BLACK_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\queen1.png"));
        }
    }
}
