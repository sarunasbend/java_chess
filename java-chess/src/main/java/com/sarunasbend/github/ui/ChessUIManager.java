package com.sarunasbend.github.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import com.sarunasbend.github.bridge.IPCEvents;
import com.sarunasbend.github.bridge.IPCUI;
import com.sarunasbend.github.logic.gamestate.GameState;
import com.sarunasbend.github.logic.pieces.Bishop;
import com.sarunasbend.github.logic.pieces.King;
import com.sarunasbend.github.logic.pieces.Knight;
import com.sarunasbend.github.logic.pieces.Pawn;
import com.sarunasbend.github.logic.pieces.Piece;
import com.sarunasbend.github.logic.pieces.Queen;
import com.sarunasbend.github.logic.pieces.Rook;
import com.sarunasbend.github.ui.chessboard.ChessboardUI;
import com.sarunasbend.github.ui.pieces.BishopUI;
import com.sarunasbend.github.ui.pieces.KingUI;
import com.sarunasbend.github.ui.pieces.KnightUI;
import com.sarunasbend.github.ui.pieces.PawnUI;
import com.sarunasbend.github.ui.pieces.PieceUI;
import com.sarunasbend.github.ui.pieces.QueenUI;
import com.sarunasbend.github.ui.pieces.RookUI;
import com.sarunasbend.github.utility.Constants;
import com.sarunasbend.github.utility.debug.Debug;

public class ChessUIManager extends JLayeredPane {
    private ChessboardUI chessboardUI;

    private JLabel[] availableMovesLabels;

    private PieceUI game[][] = new PieceUI[Constants.CHESSBOARD_RANKS][Constants.CHESSBOARD_FILES];

    public ChessUIManager(){

    }

    public void init(){
        configuration();
        addEventListeners();

        chessboardUI = new ChessboardUI(GameState.chessboard);
        chessboardUI.setBounds(0,0, Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT);
        chessboardUI.init();

        add(chessboardUI, JLayeredPane.DEFAULT_LAYER);

        placeStartingPieces();
    }

    private void configuration(){
        setSize(Constants.CHESSBOARD_WIDTH, Constants.CHESSBOARD_HEIGHT);
    }

    private void addEventListeners(){
        IPCUI.handle(IPCEvents.Chessboard.UPDATE_UI, (args) -> {
            placeStartingPieces();
            return null;
        });

    }

    private void placeStartingPieces(){
        int blocksize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_RANKS;

        for (int file = 0; file < Constants.CHESSBOARD_RANKS; file++){
            for (int rank = 0; rank < Constants.CHESSBOARD_FILES; rank++){
                Piece piece = GameState.game[rank][file];
                
                if (piece != null){
                    if (piece instanceof Pawn){
                        game[rank][file] = new PawnUI((Pawn) piece);
                    } else if (piece instanceof Knight){
                        game[rank][file] = new KnightUI((Knight) piece);
                    } else if (piece instanceof Rook){
                        game[rank][file] = new RookUI((Rook) piece);
                    } else if (piece instanceof Bishop){
                        game[rank][file] = new BishopUI((Bishop) piece);
                    } else if (piece instanceof Queen){
                        game[rank][file] = new QueenUI((Queen) piece);
                    } else if (piece instanceof King){
                        game[rank][file] = new KingUI((King) piece);
                    } else {
                    }
                    game[rank][file].setBounds(file * blocksize, rank * blocksize, blocksize, blocksize);
                    add(game[rank][file], JLayeredPane.PALETTE_LAYER);
                } else {
                    game[rank][file] = null;
                }
            }
        }
    }
}
