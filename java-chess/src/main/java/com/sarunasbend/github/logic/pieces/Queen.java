package com.sarunasbend.github.logic.pieces;

import java.util.ArrayList;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.logic.movevalidator.MoveValidator;
import com.sarunasbend.github.utility.Constants;

public class Queen extends Piece {
    public Queen(int colour, int rank, int file){
        super(colour, rank, file);
    }

    @Override
    public void onPieceSelected(){
        ArrayList<int[]> availableMoves = MoveValidator.getQueenMoves(getRank(), getFile(), getColour());
        IPCLogic.send(IPCEvents.Chessboard.SHOW_AVAILABLE_MOVES, availableMoves);
    }
    
    @Override
    public void onPieceUnselected(){
        IPCLogic.send(IPCEvents.Chessboard.CLEAR_AVAILABLE_MOVES);
    }

    @Override
    public void onMove(int rank, int file){
        ArrayList<int[]> availableMoves = MoveValidator.getQueenMoves(getRank(), getFile(), getColour());

        int[] moveToMake = new int[]{rank, file};

        for (int[] move : availableMoves){
            if (move[0] == moveToMake[0] && move[1] == moveToMake[1]){
                IPCLogic.send(IPCEvents.Chessboard.PIECE_MOVED, getRank(), getFile(), moveToMake[0], moveToMake[1]);
                IPCLogic.send(IPCEvents.Chessboard.UPDATE_UI, getRank(), getFile(), moveToMake[0], moveToMake[1]);
                setRank(moveToMake[0]);
                setFile(moveToMake[1]);
                
                return;
            }
        }
    }
}
