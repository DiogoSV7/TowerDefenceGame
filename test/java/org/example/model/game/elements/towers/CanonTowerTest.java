package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class CanonTowerTest {

    @Test
    public void testAttack() {
        Enemy enemy = Mockito.mock(Enemy.class);
        Mockito.when(enemy.getPosition()).thenReturn(new Position(2, 3));
        CanonTower canonTower = new CanonTower(1,1);
        if(canonTower.isInRange(enemy)) {
            canonTower.shoot(enemy);
        }
        verify(enemy).reduceHiddenHealth(canonTower.getDamage());
    }
    @Test
    void testGetTowerSymbol() {
        CanonTower canonTower = new CanonTower(1,1);
        assertEquals('C', canonTower.getTowerSymbol());
    }
    @Test
    void testGetFiringSpeed() {
        CanonTower canonTower = new CanonTower(1,1);
        assertEquals(1500, canonTower.getFiringSpeed());
    }
    @Test
    public void testDealDamage() {
        CanonTower canonTower = new CanonTower(1,1);
        int damage = canonTower.getDamage();
        assertEquals(80, damage);
    }

    @Test
    public void testUpgrade() {
        CanonTower canonTower = new CanonTower(1,1);

        canonTower.upgrade();
        assertEquals(2, canonTower.getLevel());
        assertEquals(21, canonTower.getRange());
        assertEquals(400, canonTower.getLife());
    }

    @Test
    public void testTripleUpgrade() {
        CanonTower canonTower = new CanonTower(1,1);
        canonTower.upgrade();
        canonTower.upgrade();
        canonTower.upgrade();
        assertEquals(4, canonTower.getLevel());
        assertEquals(23, canonTower.getRange());
        assertEquals(600, canonTower.getLife());
    }
    @Test
    public void testGetX() {
        CanonTower canonTower = new CanonTower(1,1);
        assertEquals(1, canonTower.getX());
    }

    @Test
    public void testGetY() {
        CanonTower canonTower = new CanonTower(1,1);
        assertEquals(1, canonTower.getY());
    }

    @Test
    public void testSetX() {
        CanonTower canonTower = new CanonTower(1,1);
        canonTower.setPosition(new Position(30,1));
        assertEquals(30, canonTower.getX());
    }

    @Test
    public void testSetY() {
        CanonTower canonTower = new CanonTower(1,1);
        canonTower.setPosition(new Position(1,40));
        assertEquals(40, canonTower.getY());
    }
}
