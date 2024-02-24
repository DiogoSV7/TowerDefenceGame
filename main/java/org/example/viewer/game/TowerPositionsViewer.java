package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.TowerPositions;

public class TowerPositionsViewer implements ElementViewer<TowerPositions> {
    @Override
    public void draw(TowerPositions towerPositions, Window window) {
        window.drawTowerPositions(towerPositions.getPosition(), towerPositions);
    }
}
