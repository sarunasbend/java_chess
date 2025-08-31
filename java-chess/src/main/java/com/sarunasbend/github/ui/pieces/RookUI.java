package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.Rook;

public class RookUI extends PieceUI {
    private Rook rook;

    public RookUI(Rook rook){
        this.rook = rook;
        init();
    }

    public void init(){
        setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\white-rook.png"));
    }
}
