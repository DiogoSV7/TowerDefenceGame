package org.example.states;

import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.*;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.CanonTower;
import org.example.model.game.elements.towers.MageTower;
import org.example.model.game.elements.towers.Projectile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GameStateTest {
    private Window mockWindow;
    private GameState gameState;
    private Arena mockArena;
    private Game mockGame;

    @BeforeEach
    void setUp() throws Exception {
        mockGame = mock(Game.class);
        mockArena = new Arena(120,40);
        mockArena.setEnemies(Arrays.asList(new Orc(12,34), new Skeleton(24,45), new Golem(12,37)));
        mockArena.setPixeis(Arrays.asList(new Pixel(0,0), new Pixel(0,1), new Pixel(0,2), new Pixel(0,3)));
        mockArena.setChest(new Chest(50,50));
        mockArena.setTowerPositions(Arrays.asList(new TowerPositions(23,42,'1'), new TowerPositions(1,3,'2'), new TowerPositions(35,21,'3')));
        mockArena.setTowers(Arrays.asList(new ArcherTower(0,40), new CanonTower(20,0), new MageTower(120,36)));
        mockArena.setWalls(Arrays.asList(new Wall(0,40), new Wall(20,0), new Wall(120,36)));
        mockArena.setPaths(Arrays.asList(new Path(0,0), new Path(0,1), new Path(0,2), new Path(0,3)));
        mockArena.setProjectiles(Arrays.asList(new Projectile(0,0,mockArena.getEnemies().get(0),1,20)));
        mockWindow = mock(Window.class);
        gameState = new GameState(mockArena, mockWindow);
    }

    @Test
    public void testInitialize_ShouldInitializeGameState() {
        Arena arena = new Arena(120,40);
        Window window = mock(Window.class);

        try {
            GameState gameState = new GameState(arena, window);
            assertNotNull(gameState);
            assertEquals(arena, gameState.getModel());
        } catch (Exception e) {
        }
    }
    @Test
    public void testUpdateProjectiles_ShouldHandleProjectileUpdates() {
        Arena arena = new Arena(120,40);
        Window window = mock(Window.class);

        try {
            GameState gameState = new GameState(arena, window);
            gameState.updateProjectiles();
            for (Projectile projectile : arena.getProjectiles()) {
                assertTrue(projectile.getTimePassed() >= 0);
            }
        } catch (Exception e) {
        }
    }
    @Test
    void testStep() throws Exception {
        gameState.step(mockGame, mockWindow, 100L);
    }
    @Test
    void testControllersSteps() throws Exception {
        gameState.enemyController.step(mockGame, null, 1000);
        WindowInterface.KEY action = WindowInterface.KEY.NUM_1;
        gameState.towerController.step(mockGame, action, 100L);

    }
    @Test
    void testMoveEnemiesWithDeadEnemy() throws IOException {

        Enemy deadEnemy = new Orc(91,5);
        Enemy deadEnemy2 = new Skeleton(93,5);
        Enemy deadEnemy3 = new Golem(92,5);
        deadEnemy.setDead(true);
        deadEnemy2.setDead(true);
        deadEnemy3.setDead(true);
        gameState.enemyController.enemies.add(deadEnemy2);
        gameState.enemyController.enemies.add(deadEnemy3);
        gameState.enemyController.enemies.add(deadEnemy);

        gameState.enemyController.moveEnemies();
        assertEquals(0, gameState.enemyController.enemies.size());

    }
}
