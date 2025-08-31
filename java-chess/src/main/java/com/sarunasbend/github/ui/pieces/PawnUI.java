package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.Pawn;
import com.sarunasbend.github.utility.debug.Debug;

public class PawnUI extends PieceUI {
    private Pawn pawn;

    public PawnUI(Pawn pawn){
        this.pawn = pawn;
        init();
    }
    
    public void init(){
        setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\white-pawn.png"));
    }
}
