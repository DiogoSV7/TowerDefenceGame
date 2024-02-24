package org.example.model.game.elements;


public class TowerPositions extends Element {
    private final char symbol;
    public TowerPositions(int x, int y,char symbol) {
        super(x, y);
        this.symbol=symbol;
    }
    public char getSymbol(){
        return this.symbol;
    }
}

