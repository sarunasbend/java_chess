package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.Queen;

public class QueenUI extends PieceUI {
    private Queen queen;

    public QueenUI(Queen queen){
        this.queen = queen;
        init();
    }

    public void init(){
        setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\white-queen.png"));
    }
}
