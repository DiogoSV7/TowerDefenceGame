package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.example.model.game.elements.Element;

public abstract class Enemy extends Element {
    boolean isDead = false;
    Position position;
    char enemySymbol;
    double speed;
    int totHP;
    int actHP;
    int hiddenHP;
    private Position deathPosition;

    public Enemy(double speed, int totHP, int x, int y){
        super(x,y);
        this.speed = speed;
        this.totHP = totHP;
        actHP = totHP;
        this.hiddenHP=actHP;
        this.deathPosition = new Position(0,0);
        this.position = new Position(x,y);
    }
    public char getEnemySymbol() {
        return enemySymbol;
    }
    public int getActHP() {
        return this.actHP;
    }
    public double getSpeed() {
        return speed;
    }

    public Position getDeathPosition(){
        return deathPosition;
    }

    public void die() {
        setDead(true);
        hiddenHP = 0;
        actHP = 0;
        deathPosition = getPosition();
    }
    public int getHiddenHealth(){

        return hiddenHP;
    }
    public void reduceHiddenHealth(int damage){
        hiddenHP-=damage;
    }
    public void damage(int amount) {
        actHP-=amount;
        if (actHP<0){
            die();
        }
    }
    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean target) {
        isDead = target;
    }

    public void moveEnemies(Enemy enemy) {
        switch (enemy.getEnemySymbol()) {
            case 'S':
                for(int i=0;i<enemy.getSpeed();i++){
                    moveSkeleton(enemy);
                }
                break;
            case 'G':
                for(int i=0;i<enemy.getSpeed();i++){
                    moveGolem(enemy);
                }
                break;
            case 'O':
                for(int i=0;i<enemy.getSpeed();i++){
                    moveOrc(enemy);
                }
                break;

        }
    }

    public void moveGolem(Enemy enemy) {
        Position position = enemy.getPosition();
        Position targetPosition = new Position(92, 5);

        if (!enemy.isDead() && !position.equals(targetPosition)) {
            if (position.getX() == 41 && position.getY()<21){
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 21 && position.getX()>22 && position.getX()!=92){
                position = new Position(position.getX() - 1, position.getY());
            } else if (position.getX() == 22 && position.getY()<32 && position.getY()!=6 ) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 32 && position.getX()<92) {
                position = new Position(position.getX() + 1, position.getY());
            } else if (position.getX() == 92) {
                position = new Position(position.getX(), position.getY() - 1);
            } else if (position.getY() == 6 && position.getX()<41) {
                position = new Position(position.getX() + 1, position.getY());
            }

            enemy.setPosition(position);
        }
        if (position.equals(targetPosition)) {
            enemy.die();
            enemy.setDeathPosition(position);
        }
    }

    public void setDeathPosition(Position position) {
        this.deathPosition = position;
    }

    public void moveSkeleton(Enemy enemy) {
        Position position = enemy.getPosition();
        Position targetPosition = new Position(93, 5);

        if (!enemy.isDead() && !position.equals(targetPosition)) {
            if (position.getX() == 40 && position.getY()<20){
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 20 && position.getX()>21 && position.getX()!=93){
                position = new Position(position.getX() - 1, position.getY());
            } else if (position.getX() == 21 && position.getY()<33 && position.getY()!=7 ) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 33 && position.getX()<93) {
                position = new Position(position.getX() + 1, position.getY());
            } else if (position.getX() == 93) {
                position = new Position(position.getX(), position.getY() - 1);
            } else if (position.getY() == 7 && position.getX()<40) {
                position = new Position(position.getX() + 1, position.getY());
            }

            enemy.setPosition(position);
        }
        if (position.equals(targetPosition)) {
            enemy.die();
            enemy.setDeathPosition(position);

        }
    }

    public void moveOrc(Enemy enemy) {
        Position position = enemy.getPosition();
        Position targetPosition = new Position(91, 5);

        if (!enemy.isDead() && !position.equals(targetPosition)) {
            if (position.getX() == 42 && position.getY() < 22) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 22 && position.getX()> 23 && position.getX() != 91) {
                position = new Position(position.getX() - 1, position.getY());
            } else if (position.getX() == 23 && position.getY() < 31 && position.getY() != 5) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 31 && position.getX() < 91) {
                position = new Position(position.getX() + 1, position.getY());
            } else if (position.getX() == 91) {
                position = new Position(position.getX(), position.getY() - 1);
            } else if (position.getY() == 5 && position.getX() < 42) {
                position = new Position(position.getX() + 1, position.getY());
            }

            enemy.setPosition(position);
        }
        if (position.equals(targetPosition)) {
            enemy.die();
            enemy.setDeathPosition(position);
        }
    }
}