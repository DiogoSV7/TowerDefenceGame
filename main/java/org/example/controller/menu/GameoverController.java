package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.WindowInterface;
import org.example.model.menu.Gameover;
import org.example.model.menu.Menu;
import org.example.states.MenuState;


public class GameoverController extends Controller<Gameover> {
    public GameoverController(Gameover gameover) {
        super(gameover);
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws Exception {
        if (action== WindowInterface.KEY.SELECT)
            game.setState(new MenuState(new Menu(),game.getWindow()));
    }
}
