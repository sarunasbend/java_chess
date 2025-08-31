package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.King;

public class KingUI extends PieceUI {
    private King king;

    public KingUI(King king){
        this.king = king;
        init();
    }

    public void init(){
        setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\white-king.png"));
    }
}
