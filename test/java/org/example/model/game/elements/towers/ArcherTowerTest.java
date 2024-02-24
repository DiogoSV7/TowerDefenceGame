package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTowerTest {
    @Test
    void testAttack() {
        Enemy enemy = Mockito.mock(Enemy.class);
        Mockito.when(enemy.getPosition()).thenReturn(new Position(2, 3));
        ArcherTower archerTower = new ArcherTower(1, 1);
        if (archerTower.isInRange(enemy)) {
            archerTower.shoot(enemy);
        }
        Mockito.verify(enemy).reduceHiddenHealth(archerTower.getDamage());
    }


    @Test
    public void testDealDamage() {
        ArcherTower archerTower = new ArcherTower(1,1);
        int damage = archerTower.getDamage();
        assertEquals(20, damage);
    }

    @Test
    public void testUpgrade() {
        ArcherTower archerTower = new ArcherTower(1,1);
        archerTower.upgrade();
        assertEquals(2, archerTower.getLevel());
        assertEquals(17, archerTower.getRange());
        assertEquals(300, archerTower.getLife());
    }

    @Test
    public void testTripleUpgrade() {
        ArcherTower archerTower = new ArcherTower(1,1);
        archerTower.upgrade();
        archerTower.upgrade();
        archerTower.upgrade();
        assertEquals(4, archerTower.getLevel());
        assertEquals(21, archerTower.getRange());
        assertEquals(400, archerTower.getLife());
    }
    @Test
    public void testGetX() {
        ArcherTower archerTower = new ArcherTower(1,1);
        assertEquals(1, archerTower.getX());
    }

    @Test
    public void testGetY() {
        ArcherTower archerTower = new ArcherTower(1,1);
        assertEquals(1, archerTower.getY());
    }

    @Test
    public void testSetX() {
        ArcherTower archerTower = new ArcherTower(1,1);
        archerTower.setPosition(new Position(30 , 1));
        assertEquals(30, archerTower.getX());
    }

    @Test
    public void testSetY() {
        ArcherTower archerTower = new ArcherTower(1,1);
        archerTower.setPosition(new Position(1,40));
        assertEquals(40, archerTower.getY());
    }
}
