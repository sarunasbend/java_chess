package com.sarunasbend.github.ui.pieces;

import java.util.ArrayList;

import com.sarunasbend.github.logic.pieces.Pieces;
import com.sarunasbend.github.logic.pieces.piece.Bishop;
import com.sarunasbend.github.logic.pieces.piece.King;
import com.sarunasbend.github.logic.pieces.piece.Knight;
import com.sarunasbend.github.logic.pieces.piece.Pawn;
import com.sarunasbend.github.logic.pieces.piece.Piece;
import com.sarunasbend.github.logic.pieces.piece.Queen;
import com.sarunasbend.github.logic.pieces.piece.Rook;
import com.sarunasbend.github.ui.pieces.piece.BishopUI;
import com.sarunasbend.github.ui.pieces.piece.KingUI;
import com.sarunasbend.github.ui.pieces.piece.KnightUI;
import com.sarunasbend.github.ui.pieces.piece.PawnUI;
import com.sarunasbend.github.ui.pieces.piece.PieceUI;
import com.sarunasbend.github.ui.pieces.piece.QueenUI;
import com.sarunasbend.github.ui.pieces.piece.RookUI;

public class PiecesUI {
    private Pieces whitePieces;
    private Pieces blackPieces;

    private ArrayList<PieceUI> piecesUI = new ArrayList<>();

    public PiecesUI(Pieces whitePieces, Pieces blackPieces){
        this.whitePieces = whitePieces;
        this.blackPieces = blackPieces;
    }

    public void init(){
        for (Piece piece : whitePieces.getPices()){
            if (piece instanceof Pawn){
                piecesUI.add(new PawnUI((Pawn) piece));
            } else if (piece instanceof Knight){
                piecesUI.add(new KnightUI((Knight) piece));
            } else if (piece instanceof Rook){
                piecesUI.add(new RookUI((Rook) piece));
            } else if (piece instanceof Bishop){
                piecesUI.add(new BishopUI((Bishop) piece));
            } else if (piece instanceof Queen){
                piecesUI.add(new QueenUI((Queen) piece));
            } else if (piece instanceof King){
                piecesUI.add(new KingUI((King) piece));
            }
        }

        for (Piece piece : blackPieces.getPices()){
            if (piece instanceof Pawn){
                piecesUI.add(new PawnUI((Pawn) piece));
            } else if (piece instanceof Knight){
                piecesUI.add(new KnightUI((Knight) piece));
            } else if (piece instanceof Rook){
                piecesUI.add(new RookUI((Rook) piece));
            } else if (piece instanceof Bishop){
                piecesUI.add(new BishopUI((Bishop) piece));
            } else if (piece instanceof Queen){
                piecesUI.add(new QueenUI((Queen) piece));
            } else if (piece instanceof King){
                piecesUI.add(new KingUI((King) piece));
            }
        }
    }

    public ArrayList<PieceUI> getPiecesUIs(){return this.piecesUI;}
}
