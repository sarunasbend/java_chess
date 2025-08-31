package com.sarunasbend.github.ui.pieces;

import javax.swing.ImageIcon;

import com.sarunasbend.github.logic.pieces.piece.Pawn;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class PawnUI extends PieceUI {
    public PawnUI(Pawn pawn){
        super(pawn);
        init();
    }
    
    public void init(){
        if (getPiece().getColour() == Constants.WHITE_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\pawn.png"));
        } else if (getPiece().getColour() == Constants.BLACK_PIECE){
            setIcon(new ImageIcon("java-chess\\src\\main\\java\\com\\sarunasbend\\github\\resources\\pieces\\pawn1.png"));
        }
    }
}
