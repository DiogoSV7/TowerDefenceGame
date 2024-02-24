package org.example.controller.game;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.CanonTower;
import org.example.model.game.elements.towers.MageTower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TowerControllerTest {

    private Arena arena;
    private TowerController towerController;
    private TextGraphics tg;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        mockGame = mock(Game.class);
        towerController = new TowerController(arena);
    }

    @Test
    void testTowerInitialization() {
        assertNotNull(towerController.getTowerList());
        assertTrue(towerController.getTowerList().isEmpty());
    }

    @Test
    void testTowerCreationArcher() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.NUM_1;
        long time = System.currentTimeMillis();

        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.A;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new ArcherTower(21, 2));
        assertEquals(1, towerController.getTowerList().size());
        assertTrue(towerController.getTowerList().get(0) instanceof ArcherTower);
        assertEquals(new Position(21, 2), towerController.getTowerList().get(0).getPosition());
    }
    @Test
    void testTowerCreationCanon() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.NUM_2;
        long time = System.currentTimeMillis();

        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.C;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new CanonTower(34, 11));
        assertEquals(1, towerController.getTowerList().size());
        assertTrue(towerController.getTowerList().get(0) instanceof CanonTower);
        assertEquals(new Position(34, 11), towerController.getTowerList().get(0).getPosition());
    }
    @Test
    void testTowerCreationMage() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.NUM_3;
        long time = System.currentTimeMillis();

        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.M;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new MageTower(34, 25));
        assertEquals(1, towerController.getTowerList().size());
        assertTrue(towerController.getTowerList().get(0) instanceof MageTower);
        assertEquals(new Position(34, 25), towerController.getTowerList().get(0).getPosition());
    }
    @Test
    void testTowerCreationPositions() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.NUM_4;
        long time = System.currentTimeMillis();

        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.A;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new ArcherTower(21, 2));
        assertEquals(1, towerController.getTowerList().size());

        action = WindowInterface.KEY.NUM_5;
        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.C;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new CanonTower(34, 11));
        assertEquals(2, towerController.getTowerList().size());

        action = WindowInterface.KEY.NUM_6;
        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.M;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new MageTower(34, 25));
        assertEquals(3, towerController.getTowerList().size());

        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.A;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new ArcherTower(21, 2));
        assertEquals(4, towerController.getTowerList().size());

        action = WindowInterface.KEY.NUM_7;
        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.C;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new CanonTower(34, 11));
        assertEquals(5, towerController.getTowerList().size());

        action = WindowInterface.KEY.NUM_8;
        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.M;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new MageTower(34, 25));
        assertEquals(6, towerController.getTowerList().size());

        action = WindowInterface.KEY.NUM_9;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new MageTower(34, 25));
        assertEquals(7, towerController.getTowerList().size());
    }
    @Test
    void testTowerUpgrade() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.NUM_3;
        long time = System.currentTimeMillis();
        towerController.getTowerList().add(new MageTower(34, 25));
        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.U;
        towerController.step(mockGame, action, time);

        assertEquals(1, towerController.getTowerList().size());

        action = WindowInterface.KEY.U;
        towerController.step(mockGame, action, time);

        assertEquals(1, towerController.getTowerList().size());
        assertEquals(1, towerController.getTowerList().get(0).getLevel());
    }
}

