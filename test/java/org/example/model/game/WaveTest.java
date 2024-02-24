package org.example.model.game;

import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class WaveTest {

    @Test
    public void testSpawn() {
        Wave wave = new Wave();
        int level = 1;
        Orc orc = Mockito.mock(Orc.class);
        Golem golem = Mockito.mock(Golem.class);
        Skeleton skeleton = Mockito.mock(Skeleton.class);
        when(orc.getX()).thenReturn(0f);
        when(golem.getX()).thenReturn(0f);
        when(skeleton.getX()).thenReturn(0f);
        List<Enemy> enemyList = wave.spawn(level);
        assertNotNull(enemyList);
        assertFalse(enemyList.isEmpty());
        assertEquals(5 * level, enemyList.size());
        for (Enemy enemy : enemyList) {
            assertTrue(enemy.getX() <= 0);
        }
    }

    @Test
    public void testIsCompleted() {
        Wave wave = new Wave();
        assertFalse(wave.isCompleted());
    }

    @Test
    public void testGetEnemyList() {
        Wave wave = new Wave();
        List<Enemy> enemyList = wave.getEnemyList();
        assertNotNull(enemyList);
        assertTrue(enemyList.isEmpty());
    }
}
