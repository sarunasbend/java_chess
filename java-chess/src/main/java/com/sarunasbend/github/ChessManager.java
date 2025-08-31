package com.sarunasbend.github;

import com.sarunasbend.github.logic.Chessboard;
import com.sarunasbend.github.logic.pieces.Pieces;
import com.sarunasbend.github.utility.Constants;

public class ChessManager {
    private static Chessboard chessboard = new Chessboard();
    private static Pieces whitePieces = new Pieces(Constants.WHITE_PIECE);
    private static Pieces blackPieces = new Pieces(Constants.BLACK_PIECE);
    
    public ChessManager(){
    }

    public void init(){
        chessboard.init();
        whitePieces.init();
        blackPieces.init();
    }

    public static Chessboard getChessboard(){return chessboard;}
    public static Pieces getWhitePieces(){return whitePieces;}
    public static Pieces getBlackPieces(){return blackPieces;}

}
