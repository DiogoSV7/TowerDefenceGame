package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Element;
import org.example.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {


    public GameViewer(Arena arena) {
        super(arena);

    }

    @Override
    public void drawElements(Window window) {
        drawElements(window, getModel().getWalls(), new WallViewer());
        drawElements(window, getModel().getPixeis(), new PixelViewer());
        drawElements(window, getModel().getTowerPositions(), new TowerPositionsViewer());
        drawElements(window, getModel().getPaths(), new PathViewer());
        drawElements(window, getModel().getProjectiles(), new ProjectileViewer());
        Chest chest = getModel().getChest();
        drawElements(window, getModel().getEnemies(), new EnemyViewer());
        drawElements(window, getModel().getTowers(), new TowerViewer());
        drawElement(window, chest, new ChestViewer());

        window.drawText(new Position(0, 41), "SCORE :" + getModel().getScore().getScore(), "WHITE");
        window.drawText(new Position(0, 42), "LEVEL :" + getModel().getLevel().getLevel(), "WHITE");
        window.drawText(new Position(0, 43), "COINS :" + getModel().getCoins(), "WHITE");
        window.drawText(new Position(0, 44), "CHEST LIFE :" + getModel().getChest().getLife(), "WHITE");
        window.drawText(new Position(0, 45), "CanonTower - 150 $, ArcherTower - 250 $, MageTower - 400 $", "WHITE");
    }


    private <T extends Element> void drawElements(Window window, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(window, element, viewer);
    }

    private <T extends Element> void drawElement(Window window, T element, ElementViewer<T> viewer) {
        viewer.draw(element, window);
    }
}