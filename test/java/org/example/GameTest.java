package org.example;

import org.example.gui.Window;
import org.example.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    private Game game;
    private Window mockWindow;

    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        mockWindow = mock(Window.class);
    }

    @Test
    void testGameInitialization() throws Exception {
        assertNotNull(game);
    }

    @Test
    void testGameWindow() throws Exception {
        game.getWindow();
        verify(game, atLeastOnce()).getWindow();
    }
    @Test
    void testGameStart() throws Exception {
        game.start();
        game.setState(mock(State.class));
        verify(game, atLeastOnce()).start();
    }
    @Test
    void testGameClosing() throws Exception {
        Game spyGame = spy(game);
        doReturn(mockWindow).when(spyGame).getWindow();

        spyGame.getWindow().close();

        verify(mockWindow, times(1)).close();
    }
}
