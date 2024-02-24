package org.example.states;


import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.viewer.Viewer;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {

    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model,Window window) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }
    public void draw(Window window) throws IOException, URISyntaxException {
        viewer.draw(window);
    }
    public void step(Game game, Window window, long time) throws Exception {
        WindowInterface.KEY action = window.processKey();
        controller.step(game, action, time);
        viewer.draw(window);
    }
}