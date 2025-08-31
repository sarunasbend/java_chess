package com.sarunasbend.github.logic.pieces.piece;

import com.sarunasbend.github.logic.Chessboard;

public class Bishop extends Piece {
    public Bishop(String id, int colour){
        super(id, colour);
    }
    
    @Override
    public void onPieceSelected(){}
    
    @Override
    public void onPieceUnselected(){}

    @Override
    public void onMove(Chessboard chessboard){}
}
