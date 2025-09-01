package com.sarunasbend.github.ui.pieces.piece;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.sarunasbend.github.logic.pieces.piece.Piece;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// generic class for pieces
public class PieceUI<OnePiece extends Piece> extends JLabel {
    private final OnePiece onePiece;

    public PieceUI(OnePiece onePiece){
        this.onePiece = onePiece;
        
        addListeners();
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }
    
    public OnePiece getPiece(){return onePiece;}

    public void addListeners(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent event){
                setBorder(createBorder());
            }

            @Override
            public void mouseExited(MouseEvent event){
                setBorder(new EmptyBorder(1,0,0,0));
            }
        });
    }

    private Border createBorder(){
        return BorderFactory.createEtchedBorder(Color.WHITE, Color.BLACK);
    }
}
