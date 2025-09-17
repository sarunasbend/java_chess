package com.sarunasbend.github.logic.movevalidator;

import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.logic.pieces.Pawn;
import com.sarunasbend.github.utility.Constants;

import java.util.ArrayList;

/**
 * Class that checks for Valid Moves, Captures, Checks, Mates, Promotions, Pins, Castling, and en Passant
 * ITS COOKED RIGHT NOW!
 */
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

    public static boolean moveWithinBounds(int rank, int file){
        return rankWithinBounds(rank) && fileWithinBounds(file);
    }

    public static boolean differentTeam(int rank, int file, int colour){
        if (GameState.game[rank][file] != null){
            return GameState.game[rank][file].getColour() != colour;
        }

        return false;
    }
 
    // given a rank, file and the chessboard, finds all available pieces
    public static ArrayList<int[]> getPawnMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();

        // necessary as movement is different for each side of the board
        if (colour == GameState.playerColour){
            // forward 1
            if (moveWithinBounds(rank - 1, file) && GameState.game[rank - 1][file] == null){
                availableMoves.add(new int[]{rank - 1, file});
            }

            // forward 2 given that there its the first move for pawn and nothing blocking
            if (!((Pawn) GameState.game[rank][file]).hasMoved() && moveWithinBounds(rank - 2, file) 
            && GameState.game[rank - 2][file] == null && GameState.game[rank - 1][file] == null){
                availableMoves.add(new int[]{rank - 2, file});
            }

            // left capture
            if (moveWithinBounds(rank - 1, file - 1) && differentTeam(rank - 1, file - 1, colour)){
                availableMoves.add(new int[]{rank - 1, file - 1});
            }

            // right capture 
            if (moveWithinBounds(rank - 1, file + 1) && differentTeam(rank - 1, file + 1, colour)){
                availableMoves.add(new int[]{rank - 1, file + 1});
            }

        } else if (colour == GameState.oppositeColour){
            if (moveWithinBounds(rank + 1, file) && GameState.game[rank + 1][file] == null){
                availableMoves.add(new int[]{rank + 1, file});
            }

            if (!((Pawn) GameState.game[rank][file]).hasMoved() && moveWithinBounds(rank + 2, file) 
            && GameState.game[rank + 2][file] == null && GameState.game[rank + 1][file] == null){
                availableMoves.add(new int[]{rank + 2, file});
            }

            if (moveWithinBounds(rank + 1, file + 1) && differentTeam(rank + 1, file + 1, colour)){
                availableMoves.add(new int[]{rank + 1, file + 1});
            }

            if (moveWithinBounds(rank + 1, file - 1) && differentTeam(rank + 1, file - 1, colour)){
                availableMoves.add(new int[]{rank + 1, file - 1});
            }

        }

        return availableMoves;
    }

    public static ArrayList<int[]> getKnightMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        int [][] moveList = {{-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}};
        
        for (int[] move : moveList){
            int seeRank = rank + move[0];
            int seeFile = file + move[1];
            if (moveWithinBounds(seeRank, seeFile) && ((differentTeam(seeRank, seeFile, colour)) || GameState.game[seeRank][seeFile] == null)){
                availableMoves.add(new int[]{seeRank, seeFile});
            }
        }

        return availableMoves;
    }

    public static ArrayList<int[]> getBishopMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();

        for (int seeRank = rank - 1, seeFile = file - 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank--, seeFile--){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        for (int seeRank = rank - 1, seeFile = file + 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank--, seeFile++){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        for (int seeRank = rank + 1, seeFile = file + 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank++, seeFile++){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        for (int seeRank = rank + 1, seeFile = file - 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank++, seeFile--){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        return availableMoves;
    }

    public static ArrayList<int[]> getRookMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        
        for (int seeRank = rank + 1; rankWithinBounds(seeRank); seeRank++){
            if (GameState.game[seeRank][file] != null){
                if (GameState.game[seeRank][file].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, file});
                    break;
                }
            }
            
            availableMoves.add(new int[]{seeRank, file});
        }

        for (int seeRank = rank - 1; rankWithinBounds(seeRank); seeRank--){
            if (GameState.game[seeRank][file] != null){
                if (GameState.game[seeRank][file].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, file});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, file});
        }

        for (int seeFile = file + 1; fileWithinBounds(seeFile); seeFile++){
            if (GameState.game[rank][seeFile] != null){
                if (GameState.game[rank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{rank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{rank, seeFile});
        }

        for (int seeFile = file - 1; fileWithinBounds(seeFile); seeFile--){
            if (GameState.game[rank][seeFile] != null){
                if (GameState.game[rank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{rank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{rank, seeFile});
        }

        return availableMoves;
    }

    public static ArrayList<int[]> getQueenMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();

        for (int seeRank = rank + 1; rankWithinBounds(seeRank); seeRank++){
            if (GameState.game[seeRank][file] != null){
                if (GameState.game[seeRank][file].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, file});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, file});
        }

        for (int seeRank = rank - 1; rankWithinBounds(seeRank); seeRank--){
            if (GameState.game[seeRank][file] != null){
                if (GameState.game[seeRank][file].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, file});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, file});
        }

        for (int seeFile = file + 1; fileWithinBounds(seeFile); seeFile++){
            if (GameState.game[rank][seeFile] != null){
                if (GameState.game[rank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{rank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{rank, seeFile});
        }

        for (int seeFile = file - 1; fileWithinBounds(seeFile); seeFile--){
            if (GameState.game[rank][seeFile] != null){
                if (GameState.game[rank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{rank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{rank, seeFile});
        }

        for (int seeRank = rank - 1, seeFile = file - 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank--, seeFile--){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        for (int seeRank = rank - 1, seeFile = file + 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank--, seeFile++){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        for (int seeRank = rank + 1, seeFile = file + 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank++, seeFile++){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        for (int seeRank = rank + 1, seeFile = file - 1; rankWithinBounds(seeRank) && fileWithinBounds(seeFile); seeRank++, seeFile--){
            if (GameState.game[seeRank][seeFile] != null){
                if (GameState.game[seeRank][seeFile].getColour() == colour){
                    break;
                } else {
                    availableMoves.add(new int[]{seeRank, seeFile});
                    break;
                }
            }
            availableMoves.add(new int[]{seeRank, seeFile});
        }

        return availableMoves;
    }

   //  @TODO : extra conditions required to see if king is nearby
    public static ArrayList<int[]> getKingMoves(int rank, int file, int colour){
        ArrayList<int[]> availableMoves = new ArrayList<int[]>();
        int[][] moveList = {{-1,-1},{-1,0},{-1, 1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        
        for (int[] move : moveList){
            int seeRank = rank + move[0];
            int seeFile = file + move[1];
            if (moveWithinBounds(seeRank, seeFile) && ((differentTeam(seeRank, seeFile, colour)) || GameState.game[seeRank][seeFile] == null)){
                availableMoves.add(new int[]{seeRank, seeFile});
            }
        }

        return availableMoves;
    }
}
