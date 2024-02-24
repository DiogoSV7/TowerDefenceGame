package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.menu.Controls;
import org.example.model.menu.Leaderboard;
import org.example.model.menu.Menu;
import org.example.states.ControlsState;
import org.example.states.GameState;
import org.example.states.LeaderboardState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws Exception {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedLeaderboard()) game.setState(new LeaderboardState(new Leaderboard(),game.getWindow()));
                if (getModel().isSelectedControls()) game.setState(new ControlsState(new Controls(),game.getWindow()));
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder().createArena(), game.getWindow()));
                break;
            default:
                break;
        }
    }
}

