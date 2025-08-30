package com.sarunasbend.github.logic.pieces.piece;

public abstract class Piece {
    private final String id; //starting position on board "A1" would be Rook
    private final String name; //e.g "White Rook"
    
    public Piece(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){return id;}
    public String getName(){return name;}
}
