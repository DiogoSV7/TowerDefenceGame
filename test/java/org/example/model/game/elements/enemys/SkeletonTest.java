package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Skeleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkeletonTest {
    @Test
    public void testSkeletonPlacement() {
        Skeleton skel = new Skeleton(1,1);
        skel.setPosition(new Position(30,1));
        assertEquals(30, skel.getX());
        assertEquals(1, skel.getY());
    }
    @Test
    public void testSkeletonSpeed() {
        Skeleton skel = new Skeleton(1,1);
        assertEquals(3, skel.getSpeed());
    }
    @Test
    public void testSkeletonActHP() {
        Skeleton skel = new Skeleton(1,1);
        assertEquals(100, skel.getActHP());
    }
    @Test
    public void testSkeletonDamageNeg() {
        Skeleton skel = new Skeleton(1,1);
        skel.damage(-30);
        assertEquals(130, skel.getActHP());
    }
    @Test
    void testSkeletonDamageZero() {
        Skeleton skel = new Skeleton(1,1);
        skel.damage(0);
        assertEquals(100, skel.getActHP());
    }
    @Test
    void testDamageWithExcessAmount() {
        Enemy enemy = new Skeleton(2,2);
        assertEquals(100, enemy.getActHP());
        enemy.damage(60);
        assertEquals(40, enemy.getActHP());
    }
    @Test
    public void testHiddenHealth() {
        Skeleton skel = new Skeleton(1,1);
        assertEquals(100, skel.getHiddenHealth());
    }
    @Test
    public void testHurt() {
        Skeleton skel = new Skeleton(1,1);
        skel.damage(50);
        assertEquals(50, skel.getActHP());
    }
    @Test
    public void testGetX() {
        Skeleton skel = new Skeleton(1,1);
        assertEquals(1, skel.getX());
    }

    @Test
    public void testGetY() {
        Skeleton skel = new Skeleton(1,1);
        assertEquals(1, skel.getY());
    }

    @Test
    public void testSetX() {
        Skeleton skel = new Skeleton(1,1);
        skel.setPosition(new Position(30,1));
        assertEquals(30, skel.getX());
    }

    @Test
    public void testSetY() {
        Skeleton skel = new Skeleton(1,1);
        skel.setPosition(new Position(1,40));
        assertEquals(40, skel.getY());
    }
}
