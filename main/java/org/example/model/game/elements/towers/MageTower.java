package org.example.model.game.elements.towers;


import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;

public class MageTower extends Tower {
    private static final int MT_LIFE = 100;
    private static final int LEVEL = 1;
    private static final int RANGE= 10;
    private static final int COST = 400;
    private final int firingSpeed,damage;

    public MageTower(float x, float y){
        super(MT_LIFE, LEVEL, RANGE, COST,x,y,new ArrayList<>(),'M');
        this.damage=50;
        this.firingSpeed = 750;
        setCost(COST);
    }

    @Override
    public void shoot(Enemy target) throws Exception {
        target.reduceHiddenHealth(damage);
    }

    @Override
    public int getFiringSpeed() {
        return firingSpeed;
    }



    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel()+1);
        setRange(getRange()+4);
        setLife(getLife() + 25);
    }
}