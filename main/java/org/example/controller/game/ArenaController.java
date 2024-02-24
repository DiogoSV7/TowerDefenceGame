package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;

public class ArenaController extends GameController {
    private final TowerController towerController;

    public ArenaController(Arena arena) {
        super(arena);
        this.towerController = new TowerController(arena);

    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws Exception {
        if (getModel() != null) {
            towerController.step(game, action, time);
        }
    }
}