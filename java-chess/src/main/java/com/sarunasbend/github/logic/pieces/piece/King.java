package com.sarunasbend.github.logic.pieces.piece;

import com.sarunasbend.github.logic.chessboard.Chessboard;

public class King extends Piece {
   public King(String id, int colour){
        super(id, colour);
   }

   @Override
   public void onPieceSelected(){}
    
   @Override
   public void onPieceUnselected(){}

   @Override
   public void onMove(Chessboard chessboard){}
}
