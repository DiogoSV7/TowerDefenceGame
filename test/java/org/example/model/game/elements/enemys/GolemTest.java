package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Golem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GolemTest {
    @Test
    public void testGolemPlacement() {
        Golem golem = new Golem(1,1);
        golem.setPosition(new Position(30,1));
        assertEquals(30, golem.getX());
        assertEquals(1, golem.getY());
    }
    @Test
    public void testGolemSpeed() {
        Golem golem = new Golem(1,1);
        assertEquals(1, golem.getSpeed());
    }
    @Test
    public void testGolemActHP() {
        Golem golem = new Golem(1,1);
        assertEquals(600, golem.getActHP());
    }
    @Test
    public void testGolemDamageNeg() {
        Golem golem = new Golem(1,1);
        golem.damage(-30);
        assertEquals(630, golem.getActHP());
    }
    @Test void testGolemDamageZero() {
        Golem golem = new Golem(1,1);
        golem.damage(0);
        assertEquals(600, golem.getActHP());
    }
    @Test
    void testDamageWithExcessAmount() {
        Enemy enemy = new Golem(2,2);
        assertEquals(600, enemy.getActHP());
        enemy.damage(60);
        assertFalse(enemy.isDead());
        assertEquals(540, enemy.getActHP());
    }
    @Test
    public void testHiddenHealth() {
        Golem golem = new Golem(1,1);
        assertEquals(600, golem.getHiddenHealth());
    }
    @Test
    public void testHurt() {
        Golem golem = new Golem(1,1);
        golem.damage(30);
        assertEquals(570, golem.getActHP());
    }
    @Test
    public void testGetX() {
        Golem golem = new Golem(1,1);
        assertEquals(1, golem.getX());
    }

    @Test
    public void testGetY() {
        Golem golem = new Golem(1,1);
        assertEquals(1, golem.getY());
    }

    @Test
    public void testSetX() {
        Golem golem = new Golem(1,1);
        golem.setPosition(new Position(30,1));
        assertEquals(30, golem.getX());
    }

    @Test
    public void testSetY() {
        Golem golem = new Golem(1,1);
        golem.setPosition(new Position(1,40));
        assertEquals(40, golem.getY());
    }
}
