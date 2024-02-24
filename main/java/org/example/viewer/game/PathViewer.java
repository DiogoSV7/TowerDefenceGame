package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.Path;

public class PathViewer implements ElementViewer<Path> {
    @Override
    public void draw(Path path, Window window) {
        window.drawPath(path.getPosition());
    }
}