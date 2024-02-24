package org.example.model.game.elements.enemys;

public class Golem extends Enemy {
    private static final double GOLEM_SPEED = 1;
    private static final int GOLEM_TOT_HP = 600;

    public Golem(int x, int y){
        super(GOLEM_SPEED,GOLEM_TOT_HP,x,y);
        this.enemySymbol = 'G';
    }

}
