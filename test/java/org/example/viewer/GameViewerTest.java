package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.*;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.CanonTower;
import org.example.model.game.elements.towers.MageTower;
import org.example.model.game.elements.towers.Projectile;
import org.example.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.times;

class GameViewerTest {

    @Mock
    private Window window;

    @Mock
    private Arena arena;

    private GameViewer gameViewer;

    @BeforeEach
    void setUp() {
        arena = new Arena(120,40);
        window = Mockito.mock(Window.class);
        gameViewer = new GameViewer(arena);
        arena.setEnemies(Arrays.asList(new Orc(12,34), new Skeleton(24,45), new Golem(12,37)));
        arena.setPixeis(Arrays.asList(new Pixel(0,0), new Pixel(0,1), new Pixel(0,2), new Pixel(0,3)));
        arena.setChest(new Chest(50,50));
        arena.setTowerPositions(Arrays.asList(new TowerPositions(23,42,'1'), new TowerPositions(1,3,'2'), new TowerPositions(35,21,'3')));
        arena.setTowers(Arrays.asList(new ArcherTower(0,40), new CanonTower(20,0), new MageTower(120,36)));
        arena.setWalls(Arrays.asList(new Wall(0,40), new Wall(20,0), new Wall(120,36)));
        arena.setPaths(Arrays.asList(new Path(0,0), new Path(0,1), new Path(0,2), new Path(0,3)));
        arena.setProjectiles(Arrays.asList(new Projectile(0,0,arena.getEnemies().get(0),1,20)));
    }
    @Test
    void testDrawPixeis() {
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawPixel(new Position(0,0));
        Mockito.verify(window, times(1)).drawPixel(new Position(0,1));
        Mockito.verify(window, times(1)).drawPixel(new Position(0,2));
        Mockito.verify(window, times(1)).drawPixel(new Position(0,3));
        Mockito.verify(window, times(4)).drawPixel(Mockito.any(Position.class));
    }

    @Test
    void testDrawEnemies() {
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawEnemy(new Position(12,34), arena.getEnemies().get(0));
        Mockito.verify(window, times(1)).drawEnemy(new Position(24,45),arena.getEnemies().get(1));
        Mockito.verify(window, times(1)).drawEnemy(new Position(12,37), arena.getEnemies().get(2));
        Mockito.verify(window, times(1)).drawEnemy(Mockito.any(Position.class), Mockito.any(Orc.class));
        Mockito.verify(window, times(1)).drawEnemy(Mockito.any(Position.class), Mockito.any(Golem.class));
        Mockito.verify(window, times(1)).drawEnemy(Mockito.any(Position.class), Mockito.any(Skeleton.class));
    }
    @Test
    void testDrawPaths() {
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawPath(new Position(0,0));
        Mockito.verify(window, times(1)).drawPath(new Position(0,1));
        Mockito.verify(window, times(1)).drawPath(new Position(0,2));
        Mockito.verify(window, times(1)).drawPath(new Position(0,3));
        Mockito.verify(window, times(4)).drawPath(Mockito.any(Position.class));
    }
    @Test
    void testDrawProjectile() {
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawProjectiles(arena.getProjectiles().get(0).getPosition(), window);
    }


    @Test
    void testDrawChest() {
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawChest(new Position(50,50), arena.getChest());
        Mockito.verify(window, times(1)).drawChest(Mockito.any(Position.class), Mockito.any(Chest.class));
    }
    @Test
    void testDrawTowerPositions() {
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawTowerPositions(new Position(23,42), arena.getTowerPositions().get(0));
        Mockito.verify(window, times(1)).drawTowerPositions(new Position(1,3), arena.getTowerPositions().get(1));
        Mockito.verify(window, times(1)).drawTowerPositions(new Position(35,21), arena.getTowerPositions().get(2));
    }
    @Test
    void testDrawTowers() {
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawTower(new Position(0,40), arena.getTowers().get(0));
        Mockito.verify(window, times(1)).drawTower(new Position(20,0), arena.getTowers().get(1));
        Mockito.verify(window, times(1)).drawTower(new Position(120,36), arena.getTowers().get(2));
        Mockito.verify(window, times(1)).drawTower(Mockito.any(Position.class), Mockito.any(ArcherTower.class));
        Mockito.verify(window, times(1)).drawTower(Mockito.any(Position.class), Mockito.any(CanonTower.class));
        Mockito.verify(window, times(1)).drawTower(Mockito.any(Position.class), Mockito.any(MageTower.class));
    }
    @Test
    void drawWalls(){
        gameViewer.drawElements(window);
        Mockito.verify(window, times(1)).drawWall(new Position(0,40));
        Mockito.verify(window, times(1)).drawWall(new Position(20,0));
        Mockito.verify(window, times(1)).drawWall(new Position(120,36));
        Mockito.verify(window, times(3)).drawWall(Mockito.any(Position.class));
    }
}