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

    public static boolean rankWithinBounds(int rank){
        return (rank >= 0) && (rank < Constants.CHESSBOARD_RANKS);
    }

    public static boolean fileWithinBounds(int file){
        return (file >= 0) && (file < Constants.CHESSBOARD_FILES);
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
        
        if (colour == GameState.playerColour){
            // 1.
            if (rankWithinBounds(rank - 2) && fileWithinBounds(file - 1)){
                availableMoves.add(new int[]{rank - 2, file - 1});
            }
            // 2.
            if (rankWithinBounds(rank - 2) && fileWithinBounds(file + 1)){
                availableMoves.add(new int[]{rank - 2, file + 1});
            }
            // 3.
            if (rankWithinBounds(rank - 1) && fileWithinBounds(file + 2)){
                availableMoves.add(new int[]{rank - 1, file + 2});
            }
            // 4.
            if (rankWithinBounds(rank + 1) && fileWithinBounds(file + 2)){
                availableMoves.add(new int[]{rank + 1, file + 2});
            }
            // 5.
            if (rankWithinBounds(rank + 2) && fileWithinBounds(file + 1)){
                availableMoves.add(new int[]{rank + 2, file + 1});
            }
            // 6.
            if (rankWithinBounds(rank + 2) && fileWithinBounds(file - 1)){
                availableMoves.add(new int[]{rank + 2, file - 1});
            }
            // 7.
            if (rankWithinBounds(rank + 1) && fileWithinBounds(file - 2)){
                availableMoves.add(new int[]{rank + 1, file - 2});
            }
            // 8.
            if (rankWithinBounds(rank - 1) && fileWithinBounds(file -2)){
                availableMoves.add(new int[]{rank - 1, file - 2});
            }

        } else if (colour == GameState.oppositeColour){

        }
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
