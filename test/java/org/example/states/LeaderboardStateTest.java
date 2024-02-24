package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.LeaderboardController;
import org.example.gui.Window;
import org.example.model.menu.Leaderboard;
import org.example.viewer.Viewer;
import org.example.viewer.menu.LeaderboardViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class LeaderboardStateTest {

    private LeaderboardState leaderboardState;
    private Leaderboard mockLeaderboard;
    private Window mockWindow;
    private LeaderboardController mockLeaderboardController;
    private LeaderboardViewer mockLeaderboardViewer;

    @BeforeEach
    void setUp() {
        mockLeaderboard = Mockito.mock(Leaderboard.class);
        mockWindow = Mockito.mock(Window.class);
        mockLeaderboardController = Mockito.mock(LeaderboardController.class);
        mockLeaderboardViewer = Mockito.mock(LeaderboardViewer.class);

        leaderboardState = new LeaderboardState(mockLeaderboard, mockWindow);
    }

    @Test
    void getViewer_ShouldReturnLeaderboardViewer() {
        Viewer<Leaderboard> viewer = leaderboardState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof LeaderboardViewer);
    }

    @Test
    void getController_ShouldReturnLeaderboardController() {
        Controller<Leaderboard> controller = leaderboardState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof LeaderboardController);
    }

}
