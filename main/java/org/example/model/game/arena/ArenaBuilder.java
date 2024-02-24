package org.example.model.game.arena;

import org.example.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        List<Wall> walls = createWalls();
        arena.setWalls(walls);
        List<Pixel> pixeis = createPixeis();
        arena.setPixeis(pixeis);
        List<TowerPositions> towerPositions= createTowerPositions();
        arena.setTowerPositions(towerPositions);
        List<Path> paths = createPaths();
        arena.setPaths(paths);
        Chest chest = createChest();
        arena.setChest(chest);
        return arena;
    }

    protected abstract Chest createChest();
    protected abstract List<TowerPositions> createTowerPositions();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();
    protected abstract List<Pixel> createPixeis();

    protected abstract List<Path> createPaths();


}