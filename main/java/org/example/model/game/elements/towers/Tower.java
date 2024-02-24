package org.example.model.game.elements.towers;

import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;
import java.util.List;


public abstract class Tower extends Element {

    private char towerSymbol;
    private int life;
    private int level;
    private int range;
    private int cost;
    private List<Enemy> enemies;
    private Enemy target;
    private boolean targeted;

    //private long totalTime;
    private long pastTime;
    private List<Projectile> projectiles;
    private long lastFiredTime;
    public Tower(int life, int level, int range, int cost, float x, float y, List<Enemy> enemies,char sim ){
        super(x,y);
        this.towerSymbol=sim;
        this.life = life;
        this.level = level;
        this.range = range;
        this.cost = cost;
        this.targeted=false;
        this.projectiles=new ArrayList<>();
        this.enemies= enemies;
        this.lastFiredTime = System.currentTimeMillis();
        //initialize();

    }

    public char getTowerSymbol() {
        return towerSymbol;
    }
    protected abstract void shoot(Enemy target) throws Exception;

    protected abstract int getFiringSpeed();

    public boolean isInRange(Enemy enemy) {
        float xDistance = Math.abs(enemy.getPosition().getX() - getX());
        float yDistance = Math.abs(enemy.getPosition().getY() - getY());

        if (xDistance < range && yDistance < range) {
            return true;
        }
        return false;
    }
    public void initialize(){
        //totalTime = 0;
        pastTime = System.currentTimeMillis();
    }
    public float findDistance(Enemy enemy) {
        float xDistance= Math.abs(enemy.getX()-getX());
        float yDistance= Math.abs(enemy.getY()-getY());
        return xDistance+yDistance;
    }
    public int getLife() {
        return life;
    }



    public Enemy acquireTarget() {
        Enemy closest = null;
        float closestDistance = 100000;

        for (Enemy e : enemies) {

            if (isInRange(e) && findDistance(e) < closestDistance && e.getHiddenHealth() > 0) {
                closestDistance = findDistance(e);
                closest = e;
            }
        }

        if (closest != null) {
            targeted = true;
        }

        return closest;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }


    public abstract void upgrade();
    abstract int getDamage();
    public int getLevel(){
        return level;
    }
    public int getRange(){
        return range;
    }
    void setLevel(int level){
        this.level = level;
    }
    void setRange(int range){
        this.range = range;
    }
    void setLife(int life){
        this.life = life;
    }
    void setCost(int cost){
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public void update() throws Exception {
        if (target == null || target.isDead() || !isInRange(target)) {
            targeted = false;
            target = acquireTarget();
        }

        long currentTime = System.currentTimeMillis();
        //pastTime = currentTime;


        long timeSinceLastFired = currentTime - lastFiredTime;
        if (targeted && findDistance(target) < range && timeSinceLastFired >= getFiringSpeed()) {
            shoot(target);
            Projectile novo = new Projectile(getX() + 1, getY() + 1, target, getFiringSpeed(), getDamage());
            projectiles.add(novo);

            lastFiredTime = currentTime;
        }
    }


    public List<Projectile> getProjectiles() {
        return projectiles;
    }
    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }
}
