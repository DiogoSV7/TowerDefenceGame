package org.example.controller.menu;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.menu.Gameover;
import org.example.states.MenuState;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class GameoverControllerTest {

    @Test
    void step_WithSelectAction_ShouldSetMenuStateInGame() throws Exception {
        Game game = mock(Game.class);
        WindowInterface.KEY action = WindowInterface.KEY.SELECT;
        GameoverController gameoverController = new GameoverController(new Gameover());
        gameoverController.step(game, action, System.currentTimeMillis());
        verify(game).setState(any(MenuState.class));
    }

    @Test
    void step_WithNonSelectAction_ShouldNotSetMenuStateInGame() throws Exception {
        Game game = mock(Game.class);
        WindowInterface.KEY action = WindowInterface.KEY.UP;
        GameoverController gameoverController = new GameoverController(new Gameover());
        gameoverController.step(game, action, System.currentTimeMillis());
        verify(game, never()).setState(any(MenuState.class));
    }
}

