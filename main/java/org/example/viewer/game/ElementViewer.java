package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, Window window);
}