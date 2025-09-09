package com.sarunasbend.github.logic.pieces.piece;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.logic.chessboard.Chessboard;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.utility.Constants;

public class King extends Piece {
   public King(String id, int colour){
        super(id, colour);
   }

   @Override
   public void onPieceSelected(){}
    
   @Override
   public void onPieceUnselected(){}

   @Override
   public void onMove(String [][] chessboard, String posToMove){
      int row = GameState.getRowFromPos(posToMove);
      int column = GameState.getColumnFromPos(posToMove);

      int currentRow = GameState.getRowFromPos(getPos());
      int currentColumn = GameState.getColumnFromPos(getPos());

      if (chessboard[column][row] == null){
         chessboard[currentColumn][currentRow] = null;
         if (getColour() == Constants.WHITE_PIECE){
               chessboard[column][row] = Constants.WHITE_PAWN; 
         } else if (getColour() == Constants.BLACK_PIECE){
               chessboard[column][row] = Constants.BLACK_PAWN; 
         }
         setPos(posToMove);
      }

      IPCLogic.send(IPCEvents.UI.UPDATE_UI);
   }
}
