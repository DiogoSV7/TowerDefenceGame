package org.example.model.game.elements.enemys;

public class Skeleton extends Enemy {
    private static final double SKE_SPEED = 3;
    private static final int SKE_TOT_HP = 100;

    public Skeleton(int x, int y){
        super(SKE_SPEED,SKE_TOT_HP,x,y);
        this.enemySymbol = 'S';
    }
}
