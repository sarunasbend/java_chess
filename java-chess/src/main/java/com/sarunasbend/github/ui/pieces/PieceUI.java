package com.sarunasbend.github.ui.pieces;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.sarunasbend.github.logic.pieces.piece.Piece;

import javax.swing.ImageIcon;

// generic class for pieces
public class PieceUI<OnePiece extends Piece> extends JButton {
    private final OnePiece onePiece;

    public PieceUI(OnePiece onePiece){
        this.onePiece = onePiece;
        
        // temporary, testing
        setBorderPainted(false);
        setContentAreaFilled(false);
    }
    
    public OnePiece getPiece(){return onePiece;}
}
