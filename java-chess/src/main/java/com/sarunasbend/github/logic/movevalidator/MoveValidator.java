package com.sarunasbend.github.logic.movevalidator;

import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

import java.util.ArrayList;


public class MoveValidator {
    public MoveValidator(){

    }

    public void init(){
    }


    // given a rank, file and the chessboard, finds all available pieces
    public static ArrayList<int[]> getPawnMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();

        if (colour == GameState.playerColour){
            if ((rank - 1 >= 0) && GameState.game[rank - 1][file] == null){
                availableMoves.add(new int[]{rank - 1, file});
            }

            if ((rank - 2 >= 0) && GameState.game[rank - 2][file] == null){
                availableMoves.add(new int[]{rank - 2, file});
            }

            if ((rank - 1 >= 0) && (file - 1 >= 0) && GameState.game[rank - 1][file - 1] != null){
                availableMoves.add(new int[]{rank - 1, file - 1});
            }

            if ((rank - 1 >= 0) && (file + 1 < Constants.CHESSBOARD_RANKS) && GameState.game[rank - 1][file + 1] != null){
                availableMoves.add(new int[]{rank - 1, file + 1});
            }
        } else if (colour == GameState.oppositeColour){
            if ((rank + 1 < Constants.CHESSBOARD_RANKS) && GameState.game[rank + 1][file] == null){
                availableMoves.add(new int[]{rank + 1, file});
            }

            if ((rank + 2 < Constants.CHESSBOARD_RANKS) && GameState.game[rank + 2][file] == null){
                availableMoves.add(new int[]{rank + 2, file});
            }

            if ((rank + 1 < Constants.CHESSBOARD_RANKS) && (file - 1 > 0) && GameState.game[rank + 1][file - 1] != null){
                availableMoves.add(new int[]{rank + 1, file - 1});
            }

            if ((file + 1 < Constants.CHESSBOARD_FILES) && (rank + 1 < Constants.CHESSBOARD_RANKS) && GameState.game[rank + 1][file + 1] != null){
                availableMoves.add(new int[]{rank + 1, file + 1});
            }
        }
        
        return availableMoves;
    }

    public static ArrayList<int[]> getKnightMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        return availableMoves;
    }

    public static ArrayList<int[]> getBishopMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        return availableMoves;
    }

    public static ArrayList<int[]> getRookMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        return availableMoves;
    }

    public static ArrayList<int[]> getQueenMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        return availableMoves;
    }

    public static ArrayList<int[]> getKingMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        return availableMoves;
    }
}
