package com.sarunasbend.github.logic.pieces;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.utility.Constants;

public class Queen extends Piece {
    public Queen(int colour, int rank, int file){
        super(colour, rank, file);
    }

    @Override
    public void onPieceSelected(){}
    
    @Override
    public void onPieceUnselected(){}

    @Override
    public void onMove(int rank, int field){
    }
}
