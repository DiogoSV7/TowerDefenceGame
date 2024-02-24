package org.example.states;

import org.example.controller.Controller;

import org.example.controller.menu.ControlsController;
import org.example.gui.Window;
import org.example.model.menu.Controls;
import org.example.viewer.menu.ControlsViewer;
import org.example.viewer.Viewer;

public class ControlsState extends State<Controls> {
    public ControlsState(Controls model, Window window) {
        super(model, window);
    }

    @Override
    protected Viewer<Controls> getViewer() {
        return new ControlsViewer(getModel());
    }

    @Override
    protected Controller<Controls> getController() {
        return new ControlsController(getModel());
    }


}
