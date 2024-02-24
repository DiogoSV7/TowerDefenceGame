package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.WindowInterface;
import org.example.model.menu.Controls;
import org.example.model.menu.Leaderboard;
import org.example.model.menu.Menu;
import org.example.states.MenuState;

import java.io.IOException;

import static org.example.gui.WindowInterface.KEY.QUIT;

public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard leaderboard) {
        super(leaderboard);
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws Exception {
        if (action== QUIT){
            game.setState(new MenuState(new Menu(),game.getWindow()));
        }
    }
}