package org.example.controller.menu;
import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.menu.Leaderboard;
import org.example.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.mockito.Mockito.*;

class LeaderboardControllerTest {

    private LeaderboardController leaderboardController;
    private Game mockGame;

    @BeforeEach
    void setUp() throws IOException {
        Leaderboard leaderboard = new Leaderboard();
        leaderboardController = new LeaderboardController(leaderboard);
        mockGame = mock(Game.class);
        WindowInterface mockWindow = mock(Window.class);
        when(mockGame.getWindow()).thenReturn((Window) mockWindow);
    }

    @Test
    void testQuitAction() throws Exception {
        WindowInterface.KEY quitKey = WindowInterface.KEY.QUIT;
        leaderboardController.step(mockGame, quitKey, System.currentTimeMillis());
        verify(mockGame).setState(any(MenuState.class));
    }
    @ParameterizedTest
    @ValueSource(strings = {"UP", "DOWN", "LEFT", "RIGHT","NUM_1", "A", "C", "M","U", "NUM_2", "NUM_3", "NUM_4", "NUM_5", "NUM_6", "NUM_7", "NUM_8", "NUM_9"})
    void testNonQuitAction(String key) throws Exception {
        WindowInterface.KEY nonQuitKey = WindowInterface.KEY.valueOf(key);
        leaderboardController.step(mockGame, nonQuitKey, System.currentTimeMillis());
        verify(mockGame, never()).setState(any(MenuState.class));
    }
}