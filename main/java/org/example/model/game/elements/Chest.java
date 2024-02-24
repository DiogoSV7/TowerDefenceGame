package org.example.model.game.elements;

public class Chest extends Element {
    private int life;
    private final char chestSymbol;
    static public final int INITIAL_LIFE = 25;
    public Chest(int x, int y) {
        super(x, y);
        this.life = INITIAL_LIFE;
        this.chestSymbol = 'C';
    }
    public char getChestSymbol() {
        return chestSymbol;
    }
    public int getLife() {
        return life;
    }

    public void decreaseLife() {
        life-=1;

    }
}