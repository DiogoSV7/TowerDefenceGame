package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.towers.Tower;

public class TowerViewer implements ElementViewer<Tower> {

    @Override
    public void draw(Tower tower, Window window) {
        window.drawTower(tower.getPosition(), tower);
    }
}
