package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.King;
import com.sarunasbend.github.utility.Constants;

public class KingUI extends PieceUI {
    public KingUI(King king){
        super(king);
        init();
    }

    public void init(){
        if (getPiece().getColour() == Constants.WHITE_PIECE){
            setIcon(new ImageIcon("java-chess/src/main/java/com/sarunasbend/github/resources/pieces/king.png"));
        } else if (getPiece().getColour() == Constants.BLACK_PIECE){
            setIcon(new ImageIcon("java-chess/src/main/java/com/sarunasbend/github/resources/pieces/king1.png"));
        }
    }
}
