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
        ArrayList<int[]> availableMoves = MoveValidator.getPawnMoves(getRank(), getFile(), getColour());
        IPCLogic.send(IPCEvents.Chessboard.SHOW_AVAILABLE_MOVES, availableMoves);
    }
    
    @Override
    public void onPieceUnselected(){
        IPCLogic.send(IPCEvents.Chessboard.CLEAR_AVAILABLE_MOVES);
    }

    @Override
    public void onMove(int rank, int file){
        ArrayList<int[]> availableMoves = MoveValidator.getPawnMoves(getRank(), getFile(), getColour());

        int[] moveToMake = new int[]{rank, file};

        for (int[] move : availableMoves){
            if (move == moveToMake){
                IPCLogic.send(IPCEvents.Chessboard.PIECE_MOVED, moveToMake[0], moveToMake[1], getRank(), getFile());
                setRank(moveToMake[0]);
                setFile(moveToMake[1]);
                return;
            }
        }
    }
}
