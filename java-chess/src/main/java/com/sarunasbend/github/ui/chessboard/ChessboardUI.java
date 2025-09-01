package com.sarunasbend.github.ui.chessboard;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.utility.Constants;

public class ChessboardUI extends JPanel {
    private Chessboard chessboard;

    private boolean isMouseHeldDown;
    private int mouseMovedX = -1;
    private int mouseMovedY = -1;

    private int lastMouseX = -1;
    private int lastMouseY = -1;
    private double offsetX;
    private double offsetY;
    private double zoom = 1;
    private double baseZoomX = 1;
    private double baseZoomY = 1;

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
        g2d.translate(offsetX, offsetY);
        g2d.scale(zoom * baseZoomX, zoom * baseZoomY);
        g2d.drawImage(chessboardImage, 0, 0, Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT, this);
    }

    private void initListeners(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event){
                if (event.getButton() == MouseEvent.BUTTON2) {
                    lastMouseX = event.getX();
                    lastMouseY = event.getY();
                    
                    isMouseHeldDown = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent event){
                isMouseHeldDown = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event){
                if (isMouseHeldDown){
                    // Calculates the offset based the last pan input
                    int dx = event.getX() - lastMouseX;
                    int dy = event.getY() - lastMouseY;

                    // Updates the offset
                    offsetX += dx;
                    offsetY += dy;

                    // Make a note of this pan input
                    lastMouseX = event.getX();
                    lastMouseY = event.getY();

                    repaint();
                }
            }
        });

        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent event){
                double oldZoom = zoom;

                double mouseX = event.getX();
                double mouseY = event.getY();

                if (event.getWheelRotation() < 0){
                    zoomIn();
                } else {
                    zoomOut();
                }

                offsetX = mouseX - (mouseX - offsetX) * (zoom / oldZoom);
                offsetY = mouseY - (mouseY - offsetY) * (zoom / oldZoom);
                
                repaint();
            }
        });
    }

    private void zoomIn(){
        if (zoom <= 10){
            zoom *= 1.1;
        }
    }

    private void zoomOut(){
        if (zoom >= 0.5){
            zoom /= 1.1;
        }
    }
}
