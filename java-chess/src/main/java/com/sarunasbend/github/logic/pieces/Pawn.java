package com.sarunasbend.github.logic.pieces;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class Pawn extends Piece{
    public Pawn(int colour, int rank, int file){
        super(colour, rank, file);
    }
    
    @Override
    public void onPieceSelected(){
    }
    
    @Override
    public void onPieceUnselected(){
    }

    @Override
    public void onMove(){
    }
}
