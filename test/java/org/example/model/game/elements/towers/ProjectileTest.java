package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectileTest {
    @Test
    void testIs_active() {
        Projectile projectile = new Projectile(0, 0, null, 1.0f, 10);
        assertTrue(projectile.isActive());
    }
    @Test
    void testSetActive() {
        Projectile projectile = new Projectile(0, 0, null, 1.0f, 10);
        projectile.setActive(false);
        assertFalse(projectile.isActive());
    }
    @Test
    void testGetDamage() {
        Projectile projectile = new Projectile(0, 0, null, 1.0f, 10);
        assertEquals(10, projectile.getDmg());
    }
    @Test
    public void testCalculateDirection() {
        Enemy target = Mockito.mock(Enemy.class);
        when(target.getX()).thenReturn(5f);
        when(target.getY()).thenReturn(5f);
        Projectile projectile = new Projectile(0, 0, target, 1.0f, 10);
        projectile.calculateDirection();
        assertNotNull(projectile.getX());
        assertNotNull(projectile.getY());
    }

    @Test
    public void testProjectileNotCollided() {
        Enemy target = Mockito.mock(Enemy.class);
        when(target.getX()).thenReturn(10f);
        when(target.getY()).thenReturn(10f);

        Projectile projectile = new Projectile(0, 0, target, 1.0f, 10);
        projectile.update();
        assertTrue(projectile.isAlive());
        Mockito.verify(target, never()).damage(anyInt());
    }
}
