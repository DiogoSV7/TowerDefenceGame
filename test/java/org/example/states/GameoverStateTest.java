package org.example.states;
import org.example.controller.Controller;
import org.example.controller.menu.GameoverController;
import org.example.gui.Window;
import org.example.model.menu.Gameover;
import org.example.viewer.Viewer;
import org.example.viewer.menu.GameoverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameoverStateTest {
    private Window window;
    private GameoverState gameState;
    private Gameover gameover;

    @BeforeEach
    void setUp() {
        gameState = new GameoverState(gameover, window);
    }
    @Test
    void testGetViewer() {
        Viewer<Gameover> viewer = gameState.getViewer();
        assert viewer instanceof GameoverViewer;
    }
    @Test
    void testGetController() {
        Controller<Gameover> controller = gameState.getController();
        assert controller instanceof GameoverController;
    }
}
