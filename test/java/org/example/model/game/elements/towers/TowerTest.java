package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TowerTest {

    private Tower tower;

    @Mock
    private Enemy mockEnemy;

    @BeforeEach
    void setUp() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mock(Enemy.class));
        enemies.add(mock(Enemy.class));
        tower = new ArcherTower(10, 1);
        tower.setEnemies(enemies);
        mockEnemy = mock(Enemy.class);
        tower.setProjectiles(Arrays.asList(new Projectile(0, 0, mockEnemy, 1, 20)));
    }

    @Test
    void testIsInRange_WhenInRange() {
        when(mockEnemy.getPosition()).thenReturn(new Position(5, 5));
        when(mockEnemy.isDead()).thenReturn(false);
        boolean result = tower.isInRange(mockEnemy);
        assertTrue(result);
    }

    @Test
    void testIsInRange_WhenOutOfRange() {
        when(mockEnemy.getPosition()).thenReturn(new Position(40, 15));
        when(mockEnemy.isDead()).thenReturn(false);
        boolean result = tower.isInRange(mockEnemy);
        assertFalse(result);
    }

    @Test
    void testIsInRange_WhenEnemyIsDead() {
        when(mockEnemy.getPosition()).thenReturn(new Position(5, 5));
        when(mockEnemy.isDead()).thenReturn(true);
        boolean result = tower.isInRange(mockEnemy);
        assertTrue(result);
    }

    @Test
    void testCost() {
        assertEquals(250, tower.getCost());
    }

    @Test
    void testUpgrade() {
        tower.upgrade();
        assertEquals(2, tower.getLevel());
    }


    @Test
    void testGetDamage() {
        assertEquals(20, tower.getDamage());
    }

    @Test
    void testTowerSymbol() {
        assertEquals('A', tower.getTowerSymbol());
    }

    @Test
    void testFindDistance() {
        when(mockEnemy.getPosition()).thenReturn(new Position(5, 5));
        when(mockEnemy.isDead()).thenReturn(false);
        float result = tower.findDistance(mockEnemy);
        assertEquals(11, result);
    }

    @Test
    void testGetFiringSpeed() {
        assertEquals(350, tower.getFiringSpeed());
    }
    @Test
    void testShoot() throws Exception {
        tower.shoot(mockEnemy);
        verify(mockEnemy).reduceHiddenHealth(20);
    }
}
