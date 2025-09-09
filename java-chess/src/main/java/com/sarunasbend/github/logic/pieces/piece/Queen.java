package com.sarunasbend.github.logic.pieces.piece;

import com.sarunasbend.github.logic.chessboard.Chessboard;

public class Queen extends Piece {
    public Queen(String id, int colour){
        super(id, colour);
    }
    @Override
    public void onPieceSelected(){}
    
    @Override
    public void onPieceUnselected(){}

    @Override
    public void onMove(String[][] chessboard, String posToMove){}
}
