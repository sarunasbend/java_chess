package com.sarunasbend.github.ui.components;

import java.awt.Color;

import javax.swing.JPanel;

import com.sarunasbend.github.utility.Constants;

public class SidebarUI extends JPanel {
    public SidebarUI(){
    }
    
    public void init(){
        configurations();
    }

    private void configurations(){
        setBounds(Constants.CHESSBOARD_WIDTH, 0, (Constants.WINDOW_WIDTH / 3) - Constants.WIDTH_PADDING, Constants.WINDOW_HEIGHT -  Constants.HEIGHT_PADDING);

        setBackground(Color.BLUE);
    }
}
