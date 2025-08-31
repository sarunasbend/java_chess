package com.sarunasbend.github.logic.pieces;

import java.util.ArrayList;

import com.sarunasbend.github.logic.pieces.piece.Bishop;
import com.sarunasbend.github.logic.pieces.piece.King;
import com.sarunasbend.github.logic.pieces.piece.Knight;
import com.sarunasbend.github.logic.pieces.piece.Pawn;
import com.sarunasbend.github.logic.pieces.piece.Piece;
import com.sarunasbend.github.logic.pieces.piece.Queen;
import com.sarunasbend.github.logic.pieces.piece.Rook;
import com.sarunasbend.github.utility.Constants;

public class Pieces {
    private ArrayList<Piece> pieces = new ArrayList<>();
    private int colour;

    public Pieces(int colour){
        this.colour = colour;
    }

    public void init(){
        switch (colour){
            case Constants.WHITE_PIECE:
                createWhitePieces();
                break;
            case Constants.BLACK_PIECE:
                createBlackPieces();
                break;
            default:
                break;
        }
    }

    private void createWhitePieces(){
        for (int i = 0; i < 8; i++){
            String pos = Character.toString((char) (i + 65)) + "2";
            this.pieces.add(new Pawn(pos, Constants.WHITE_PIECE));
        }

        this.pieces.add(new Rook("A1", Constants.WHITE_PIECE));
        this.pieces.add(new Rook("H1", Constants.WHITE_PIECE));
        this.pieces.add(new Bishop("C1", Constants.WHITE_PIECE));
        this.pieces.add(new Bishop("F1", Constants.WHITE_PIECE));
        this.pieces.add(new Knight("B1", Constants.WHITE_PIECE));
        this.pieces.add(new Knight("G1", Constants.WHITE_PIECE));
        this.pieces.add(new Queen("D1", Constants.WHITE_PIECE));
        this.pieces.add(new King("B1", Constants.WHITE_PIECE));
        
    }

    private void createBlackPieces(){
        for (int i = 0; i < 8; i++){
            String pos = Character.toString((char) (i + 65)) + "7";
            this.pieces.add(new Pawn(pos, Constants.BLACK_PIECE));
        }

        this.pieces.add(new Rook("A1", Constants.BLACK_PIECE));
        this.pieces.add(new Rook("H1", Constants.BLACK_PIECE));
        this.pieces.add(new Bishop("C1", Constants.BLACK_PIECE));
        this.pieces.add(new Bishop("F1", Constants.BLACK_PIECE));
        this.pieces.add(new Knight("B1", Constants.BLACK_PIECE));
        this.pieces.add(new Knight("G1", Constants.BLACK_PIECE));
        this.pieces.add(new Queen("D1", Constants.BLACK_PIECE));
        this.pieces.add(new King("B1", Constants.BLACK_PIECE));
    }
    
    public ArrayList<Piece> getPices(){return this.pieces;}
}
