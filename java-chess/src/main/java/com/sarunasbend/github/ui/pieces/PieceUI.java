package com.sarunasbend.github.ui.pieces;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.bridge.IPCUI;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.logic.pieces.Piece;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// generic class for pieces
public class PieceUI<OnePiece extends Piece> extends JLabel {
    private final OnePiece onePiece;
    private int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_RANKS;

    private int prevX = -1;
    private int prevY = - 1;

    private Boolean isMouseHeldDown = false;

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
                onePiece.onPieceSelected();
            }

            @Override
            public void mouseExited(MouseEvent event){
                setBorder(new EmptyBorder(1,0,0,0));
                onePiece.onPieceUnselected();
            }

            @Override
            public void mousePressed(MouseEvent event){
                if (event.getButton() == MouseEvent.BUTTON1){
                    isMouseHeldDown = true;
                    prevX = getX();
                    prevY = getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent event){
                isMouseHeldDown = false;

                int x = getX() + event.getX();
                int y = getY() + event.getY();

                x = (x / blockSize);
                y = (y / blockSize);

            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent event){
                if (isMouseHeldDown){
                    int x = getX() + event.getX();
                    int y = getY() + event.getY();

                    x = (x / blockSize) * blockSize;
                    y = (y / blockSize) * blockSize;
                    
                    setBounds(x, y, blockSize, blockSize);
                }
            }
        });
    }

    private Border createBorder(){
        return BorderFactory.createEtchedBorder(Color.WHITE, Color.BLACK);
    }
}
