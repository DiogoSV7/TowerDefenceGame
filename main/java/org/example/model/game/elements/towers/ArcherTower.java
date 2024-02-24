package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;

public class ArcherTower extends Tower {
    private static final int AT_LIFE = 250;
    private static final int LEVEL = 1;
    private static final int RANGE= 15;
    private static final int COST = 250;
    private final int firingSpeed,damage;

    public ArcherTower(float x, float y) {
        super(AT_LIFE, LEVEL, RANGE, COST, x, y,new ArrayList<>(),'A');
        this.firingSpeed=350;
        this.damage=20;

        setCost(COST);


    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void shoot(Enemy target) {
        target.reduceHiddenHealth(damage);
    }


    @Override
    protected int getFiringSpeed() {
        return firingSpeed;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel() + 1);
        setRange(getRange() + 2);
        setLife(getLife() + 50);
    }

}