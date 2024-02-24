package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.GameoverController;
import org.example.gui.Window;
import org.example.model.menu.Gameover;
import org.example.viewer.Viewer;
import org.example.viewer.menu.GameoverViewer;

public class GameoverState extends State<Gameover> {
    public GameoverState(Gameover model, Window window) {
        super(model, window);
    }

    @Override
    protected Viewer<Gameover> getViewer() {
        return new GameoverViewer(getModel());
    }

    @Override
    protected Controller<Gameover> getController() {
        return new GameoverController(getModel());
    }


}