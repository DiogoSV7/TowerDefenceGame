package org.example.controller;

import org.example.Game;

import org.example.gui.WindowInterface;


public abstract class Controller<T> {
    private final T model;

    public Controller(T newModel) {
        model = newModel;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, WindowInterface.KEY action, long time) throws Exception;
}
