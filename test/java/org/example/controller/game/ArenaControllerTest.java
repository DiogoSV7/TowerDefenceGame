package org.example.controller.game;

import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;

import org.example.model.game.arena.Arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ArenaControllerTest {

    @Mock
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);

    }

    @Test
    void testConstructor() {
        ArenaController arenaController = new ArenaController(arena);

        assertNotNull(arenaController);
    }




    @Test
    void testStepWithNullModel() throws Exception {
        ArenaController arenaController = new ArenaController(arena);
        Game game = mock(Game.class);
        WindowInterface.KEY action = WindowInterface.KEY.UP;
        long time = System.currentTimeMillis();


        when(arena.getLevel()).thenReturn(null);

        arenaController.step(game, action, time);


        verifyNoInteractions(mock(TowerController.class));
    }

}