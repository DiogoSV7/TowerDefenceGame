package org.example.model.game.elements.towers;

import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;


public class Projectile extends Element {
    private final int damage;
    private final float speed;
    private float xVelocity;
    private float yVelocity;
    private boolean ativo = true;
    private final Enemy target;
    private boolean alive;
    private long pastTime;
    private final long MAX_LIFETIME = 500;

    public Projectile(float x, float y , Enemy target, float speed, int damage) {
        super(x,y);
        this.speed = speed;
        this.damage = damage;
        this.target= target;
        this.alive=true;
        this.xVelocity=1;
        this.yVelocity=1;
        initialize();
    }

    public void calculateDirection() {
        float totalAllowedMovement = 1.0f;
        float xDistanceFromTarget = target.getX() - getX();
        float yDistanceFromTarget = target.getY() - getY();
        double angle = Math.atan2(yDistanceFromTarget, xDistanceFromTarget);
        xVelocity = (float) (totalAllowedMovement * Math.cos(angle));
        yVelocity = (float) (totalAllowedMovement * Math.sin(angle));
        setX(getX()+xVelocity);
        setY(getY()+yVelocity);
    }
    public void update() {
        if (alive) {
            calculateDirection();
            if (checkCollision(getX() ,getY(), target.getX(), target.getY())) {
                target.damage(damage);
                alive = false;

            }else if(getTimePassed() > MAX_LIFETIME*10){
                alive = false;
            }
        }
    }

    public boolean isAlive() {
        return alive;
    }
    private boolean checkCollision(float x, float y, float x2, float y2) {
        float tolerance = 0.5f;

        return Math.abs(x - x2) < tolerance && Math.abs(y - y2) < tolerance;
    }


    public long getTimePassed(){
        return System.currentTimeMillis() - pastTime;
    }
    public void initialize(){
        pastTime = System.currentTimeMillis();
    }
    public boolean isActive() {
        return ativo;
    }

    public void setActive(boolean ativo) {
        this.ativo = ativo;
    }

    public int getDmg() {
        return damage;
    }


}
