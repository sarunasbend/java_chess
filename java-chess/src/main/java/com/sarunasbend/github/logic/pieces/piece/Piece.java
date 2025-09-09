package com.sarunasbend.github.logic.pieces.piece;

import com.sarunasbend.github.logic.chessboard.Chessboard;

public abstract class Piece {
    private final String id; //starting position on board "A1" would be Rook
    private final int colour; //white = 0 and black = 1
    private String position;
    
    public Piece(String id, int colour){
        this.id = id;
        this.colour = colour;
        this.position = id;
    }

    public String getId(){return id;}
    public int getColour(){return colour;}
    public String getPos(){return position;}

    public void setPos(String newPos){this.position = newPos;}

    public abstract void onPieceSelected();
    public abstract void onPieceUnselected();

    public abstract void onMove(String[][] chessboard, String posToMove);

}
