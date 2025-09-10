package com.sarunasbend.github.logic.movevalidator;

import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.utility.Constants;

import java.util.ArrayList;


public class MoveValidator {
    public MoveValidator(){

    }

    public void init(){
    }


    // given a rank, file and the chessboard, finds all available pieces
    public static ArrayList<int[]> getPawnMoves(int rank, int file){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        int[] move = new int[2];
        
        if ((rank + 1 < Constants.CHESSBOARD_RANKS) && GameState.game[file][rank + 1] == null){
            move[0] = rank + 1;
            move[1] = file;
            availableMoves.add(move);
        }

        if ((rank + 2 < Constants.CHESSBOARD_RANKS) && GameState.game[file][rank + 2] == null){
            move[0] = rank + 2;
            move[1] = file;
            availableMoves.add(move);
        }

        if ((rank + 1 < Constants.CHESSBOARD_RANKS) && (file - 1 > 0) && GameState.game[file - 1][rank + 1] != null){
            move[0] = rank + 1;
            move[1] = file - 1;
            availableMoves.add(move);
        }

        if ((file + 1 < Constants.CHESSBOARD_FILES) && (rank + 1 < Constants.CHESSBOARD_RANKS) && GameState.game[file  + 1][rank + 1] != null){
            move[0] = rank + 1;
            move[1] = file - 1;
            availableMoves.add(move);
        }

        return availableMoves;
    }
}
