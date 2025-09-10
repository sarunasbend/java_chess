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
        IPCUI.handle(IPCEvents.Chessboard.SHOW_AVAILABLE_MOVES, (args) -> {
            showAvailableMoves((ArrayList<int[]>) args[0]);
            return null;
        });

        IPCUI.handle(IPCEvents.Chessboard.CLEAR_AVAILABLE_MOVES, (args) -> {
            clearAvailableMoves();
            return null;
        });

    }

    private void placeStartingPieces(){
        int blocksize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_RANKS;

        for (int row = 0; row < Constants.CHESSBOARD_RANKS; row++){
            for (int column = 0; column < Constants.CHESSBOARD_FILES; column++){
                Piece piece = GameState.game[row][column];
                
                if (piece != null){
                    if (piece instanceof Pawn){
                        game[row][column] = new PawnUI((Pawn) piece);
                    } else if (piece instanceof Knight){
                        game[row][column] = new KnightUI((Knight) piece);
                    } else if (piece instanceof Rook){
                        game[row][column] = new RookUI((Rook) piece);
                    } else if (piece instanceof Bishop){
                        game[row][column] = new BishopUI((Bishop) piece);
                    } else if (piece instanceof Queen){
                        game[row][column] = new QueenUI((Queen) piece);
                    } else if (piece instanceof King){
                        game[row][column] = new KingUI((King) piece);
                    } else {
                    }
                    game[row][column].setBounds(row * blocksize, column * blocksize, blocksize, blocksize);
                    add(game[row][column], JLayeredPane.PALETTE_LAYER);
                } else {
                    game[row][column] = null;
                }
            }
        }
    }

    private void showAvailableMoves(ArrayList<int[]> availableMoves){
        availableMovesLabels = new JLabel[availableMoves.size()];
        
        int blocksize = Constants.CHESSBOARD_HEIGHT / Constants.CHESSBOARD_RANKS;

        for (int index = 0; index < availableMoves.size(); index++){
            int rank = availableMoves.get(index)[0];
            int file = availableMoves.get(index)[1];
            
            availableMovesLabels[index] = new JLabel("X");
            availableMovesLabels[index].setBounds(file * blocksize, rank * blocksize, blocksize, blocksize);
            add(availableMovesLabels[index], JLayeredPane.PALETTE_LAYER);
        }
    }

    private void clearAvailableMoves(){
        for (int index = 0; index <  availableMovesLabels.length; index++){
            remove(availableMovesLabels[index]);
            availableMovesLabels[index] = null;
        }
    }
}
