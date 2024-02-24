package org.example.model.game.arena;

import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.Pixel;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.Wall;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoaderArenaBuilderTest {

    @Test
    void testCreateArena() throws IOException {
        LoaderArenaBuilder arenaBuilder = new LoaderArenaBuilder();
        Arena arena = arenaBuilder.createArena();
        assertEquals(199, arena.getWidth());
        assertEquals(40, arena.getHeight());
    }

    @Test
    void testCreateWalls() throws IOException {
        LoaderArenaBuilder arenaBuilder = new LoaderArenaBuilder();
        List<Wall> walls = arenaBuilder.createWalls();
        assertNotNull(walls);
    }

    @Test
    void testCreatePixeis() throws IOException {
        LoaderArenaBuilder arenaBuilder = new LoaderArenaBuilder();
        List<Pixel> pixeis = arenaBuilder.createPixeis();
        assertNotNull(pixeis);
    }

    @Test
    void testCreatePaths() throws IOException {
        LoaderArenaBuilder arenaBuilder = new LoaderArenaBuilder();
        List<Path> paths = arenaBuilder.createPaths();
        assertNotNull(paths);
    }

    @Test
    void testCreateChest() throws IOException {
        LoaderArenaBuilder arenaBuilder = new LoaderArenaBuilder();
        Chest chest = arenaBuilder.createChest();
        assertNotNull(chest);
    }

    @Test
    void testCreateTowerPositions() throws IOException {
        LoaderArenaBuilder arenaBuilder = new LoaderArenaBuilder();
        List<TowerPositions> towerPositions = arenaBuilder.createTowerPositions();
        assertNotNull(towerPositions);
    }
}
