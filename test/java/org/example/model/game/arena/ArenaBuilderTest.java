package org.example.model.game.arena;

import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.Pixel;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.Wall;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ArenaBuilderTest {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    @Test
    void testCreateArena() {
        ArenaBuilderStub arenaBuilder = new ArenaBuilderStub();
        Arena arena = arenaBuilder.createArena();

        assertEquals(WIDTH, arena.getWidth());
        assertEquals(HEIGHT, arena.getHeight());
    }

    private static class ArenaBuilderStub extends ArenaBuilder {

        @Override
        protected Chest createChest() {
            return mock(Chest.class);
        }

        @Override
        protected List<TowerPositions> createTowerPositions() {
            return Collections.singletonList(mock(TowerPositions.class));
        }

        @Override
        protected int getWidth() {
            return WIDTH;
        }

        @Override
        protected int getHeight() {
            return HEIGHT;
        }

        @Override
        protected List<Wall> createWalls() {
            return Collections.singletonList(mock(Wall.class));
        }

        @Override
        protected List<Pixel> createPixeis() {
            return Collections.singletonList(mock(Pixel.class));
        }

        @Override
        protected List<Path> createPaths() {
            return Collections.singletonList(mock(Path.class));
        }
    }
}
