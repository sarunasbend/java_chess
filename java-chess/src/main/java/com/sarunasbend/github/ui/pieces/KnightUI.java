package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.Knight;

public class KnightUI extends PieceUI{
    private Knight knight;

    public KnightUI(Knight knight){
        this.knight = knight;
        init();
    }

    public void init(){
        setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\white-knight.png"));
    }
}
