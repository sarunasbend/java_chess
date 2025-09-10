package com.sarunasbend.github.logic.pieces;

import java.util.ArrayList;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.logic.movevalidator.MoveValidator;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class Pawn extends Piece{
    public Pawn(int colour, int rank, int file){
        super(colour, rank, file);
    }
    
    @Override
    public void onPieceSelected(){
        ArrayList<int[]> availableMoves = MoveValidator.getPawnMoves(getRank(), getFile());
        IPCLogic.send(IPCEvents.Chessboard.SHOW_AVAILABLE_MOVES, availableMoves);
    }
    
    @Override
    public void onPieceUnselected(){
        IPCLogic.send(IPCEvents.Chessboard.CLEAR_AVAILABLE_MOVES);
    }

    @Override
    public void onMove(){
    }
}
