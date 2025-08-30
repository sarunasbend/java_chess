package com.sarunasbend.github.logic.pieces;

public abstract class Piece {
    private final String id;
    private final String name;
    
    public Piece(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){return id;}
    public String getName(){return name;}
}
