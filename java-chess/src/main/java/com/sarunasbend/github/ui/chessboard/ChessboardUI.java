package com.sarunasbend.github.ui.chessboard;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.bridge.IPCUI;
import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.ui.ChessUIManager;
import com.sarunasbend.github.utility.Constants;

public class ChessboardUI extends JPanel {
    private Chessboard chessboard;

    // shapes that will be draw to the bufferedimage to show available moves of piece
    private ArrayList<Shape> availableMovesPointers = new ArrayList<>();

    // flip depending on whether or not the user is seeing available moves of piece
    private boolean isShowingAvailableMoves = false;

    public ChessboardUI(Chessboard chessboard){
        this.chessboard = chessboard;
    }

    public void init(){
        setSize(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT);
        setBounds(0,0,Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_WIDTH);
        setBackground(Constants.PRIMARY_COLOR);
        initListeners();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage chessboardImage = chessboard.getChessboardImage();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(chessboardImage, 0, 0, Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT, this);

        if (isShowingAvailableMoves){
            g2d.setColor(Color.RED);
            for (Shape move : availableMovesPointers){
                g2d.fill(move);
            }
        }
    }

    private void initListeners(){
        IPCUI.handle(IPCEvents.Chessboard.SHOW_AVAILABLE_MOVES, (args) -> {
            ArrayList<int[]> availableMoves = (ArrayList<int[]>) args[0];
            createAvailableMovesPointers(availableMoves);
            isShowingAvailableMoves = true;
            repaint();
            return null;
        });

        IPCUI.handle(IPCEvents.Chessboard.CLEAR_AVAILABLE_MOVES, (args) -> {
            isShowingAvailableMoves = false;
            availableMovesPointers.clear();
            repaint();
            return null;
        });
    }

    private void createAvailableMovesPointers(ArrayList<int[]> availableMoves){
        int blockSize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_RANKS;
        
        for (int[] move : availableMoves){
            availableMovesPointers.add(new Ellipse2D.Double(move[1] * blockSize, move[0] * blockSize, 20, 20));
        }        
    }
}
