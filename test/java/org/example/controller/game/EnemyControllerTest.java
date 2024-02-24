package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Orc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnemyControllerTest {

    private Arena mockArena;
    private Score mockScore;
    private Game mockGame;

    private EnemyController enemyController;

    @BeforeEach
    void setUp(){
        mockArena = new Arena(120, 40);
        mockScore = new Score();
        mockGame = mock(Game.class);
        mockArena.setScore(mockScore);
        enemyController = new EnemyController(mockArena);
    }

    @Test
    void testStepAndMoveEnemies() throws IOException {
        long initialScoreValue = mockScore.getScore();
        long initialCoinsValue = mockArena.getCoins();

        assertTrue(enemyController.enemies.isEmpty());
        enemyController.step(mockGame, WindowInterface.KEY.UP, 100L);

        assertEquals(0, enemyController.enemies.size());
        assertEquals(initialScoreValue, mockScore.getScore());
        assertEquals(initialCoinsValue, mockArena.getCoins());
    }
    @Test
    void testLevelUpdate() throws IOException {
        long initialScoreValue = mockScore.getScore();
        long initialCoinsValue = mockArena.getCoins();

        assertTrue(enemyController.enemies.isEmpty());
        enemyController.step(mockGame, WindowInterface.KEY.UP, 500);


        assertEquals(0, enemyController.enemies.size());
        assertEquals(initialScoreValue, mockScore.getScore());
        assertEquals(initialCoinsValue, mockArena.getCoins());
    }
    @Test
    void testStepAndMoveEnemiesWithEnemies() throws IOException {
        Orc orc = new Orc(1, 6);
        Enemy spyEnemy = spy(orc);
        enemyController.enemies.add(spyEnemy);

        WindowInterface.KEY action = WindowInterface.KEY.UP;
        long time = 501;
        enemyController.step(mockGame, action, time);

        verify(spyEnemy).moveEnemies(any());
    }
    @Test
    void testStepAndMoveEnemiesWithEnemiesAndDeath() throws IOException {
        Orc orc = new Orc(1, 6);
        Enemy spyEnemy = spy(orc);
        enemyController.enemies.add(spyEnemy);
        spyEnemy.die();

        WindowInterface.KEY action = WindowInterface.KEY.UP;
        long time = 501;
        enemyController.step(mockGame, action, time);

        verify(spyEnemy).moveEnemies(any());
    }
    @Test
    void testStepAndMoveEnemiesWithEnemiesAndDeathAndDeathPosition() throws IOException {
        Orc orc = new Orc(1, 6);
        Enemy spyEnemy = spy(orc);
        enemyController.enemies.add(spyEnemy);
        spyEnemy.die();

        WindowInterface.KEY action = WindowInterface.KEY.UP;
        long time = 501;
        enemyController.step(mockGame, action, time);
        verify(spyEnemy).moveEnemies(any());
        verify(spyEnemy).moveEnemies(any());
    }
    @Test
    void testStepAndMoveEnemiesWithNullAction() throws IOException {
        Orc orc = new Orc(1, 6);
        Enemy spyEnemy = spy(orc);
        enemyController.enemies.add(spyEnemy);

        enemyController.step(mockGame, null, 501);

        verify(spyEnemy).moveEnemies(any());
        // Add assertions for the expected behavior with a null action
    }

    @Test
    void testStepAndMoveEnemiesWithDifferentAction() throws IOException {
        Orc orc = new Orc(1, 6);
        Enemy spyEnemy = spy(orc);
        enemyController.enemies.add(spyEnemy);

        enemyController.step(mockGame, WindowInterface.KEY.A, 501);
        enemyController.step(mockGame, WindowInterface.KEY.C, 501);
        enemyController.step(mockGame, WindowInterface.KEY.M, 501);
        enemyController.step(mockGame, WindowInterface.KEY.U, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_1, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_2, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_3, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_4, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_5, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_6, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_7, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_8, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NUM_9, 501);
        enemyController.step(mockGame, WindowInterface.KEY.SELECT, 501);
        enemyController.step(mockGame, WindowInterface.KEY.NONE, 501);
        enemyController.step(mockGame, WindowInterface.KEY.QUIT, 501);
        enemyController.step(mockGame, WindowInterface.KEY.RIGHT, 501);
        enemyController.step(mockGame, WindowInterface.KEY.DOWN, 501);
        enemyController.step(mockGame, WindowInterface.KEY.LEFT, 501);


        verify(spyEnemy).moveEnemies(any());
    }

}
