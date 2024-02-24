package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.Chest;

public class ChestViewer implements ElementViewer<Chest> {

    @Override
    public void draw(Chest chest, Window window) {
        window.drawChest(chest.getPosition(), chest);
    }
}
