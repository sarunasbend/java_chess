package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.Bishop;

public class BishopUI extends PieceUI {
    private Bishop bishop;
    private ImageIcon imageIcon;

    public BishopUI(Bishop bishop){
        this.bishop = bishop;
        init();
    }

    public void init(){
        setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\white-bishop.png"));
    }
}

