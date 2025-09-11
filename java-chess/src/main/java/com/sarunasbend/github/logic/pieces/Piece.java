package com.sarunasbend.github.logic.pieces;

import com.sarunasbend.github.logic.chessboard.Chessboard;

public abstract class Piece {
    private final int colour; //white = 0 and black = 1
    private int rank; //this is the row
    private int file; //this is the column
    
    public Piece(int colour, int rank, int file){
        this.colour = colour;
        this.rank = rank;
        this.file = file;
    }

    public abstract void onPieceSelected();
    public abstract void onPieceUnselected();

    public abstract void onMove(int rank, int file);

    public int getRank(){return this.rank;}
    public int getFile(){return this.file;}
    public int getColour(){return this.colour;}

    public void setRank(int rank){this.rank = rank;}
    public void setFile(int file){this.file = file;}

}
