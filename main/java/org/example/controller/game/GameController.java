package org.example.controller.game;

import org.example.controller.Controller;
import org.example.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }


}