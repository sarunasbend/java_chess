package com.sarunasbend.github.ui;

import javax.swing.JLayeredPane;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCUI;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.ui.chessboard.ChessboardUI;
import com.sarunasbend.github.utility.Constants;

public class ChessUIManager extends JLayeredPane {
    private ChessboardUI chessboardUI;

    public ChessUIManager(){

    }

    public void init(){
        configuration();
        addEventListeners();

        chessboardUI = new ChessboardUI(GameState.chessboard);
        chessboardUI.setBounds(0,0, Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT);
        chessboardUI.init();

        add(chessboardUI, JLayeredPane.DEFAULT_LAYER);

    }

    public void configuration(){
        setSize(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT);
    }

    public void addEventListeners(){
        IPCUI.handle(IPCEvents.UI.PIECE_MOVING, (args) -> {
            return null;
        });

        IPCUI.handle(IPCEvents.UI.UPDATE_UI, (args) ->{
            return null;
        });
    }
}
