package org.example.states;

import org.example.Game;
import org.example.controller.Controller;
import org.example.controller.game.ArenaController;
import org.example.controller.game.EnemyController;
import org.example.controller.game.TowerController;
import org.example.gui.Window;
import org.example.gui.WindowInterface;

import org.example.model.game.arena.Arena;
import org.example.model.game.elements.towers.Projectile;
import org.example.model.game.elements.towers.Tower;
import org.example.model.menu.Gameover;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GameState extends State<Arena> {
    public EnemyController enemyController;
    public TowerController towerController;

    private final long TIME_FIXED = 100;

    private final Arena arena;
    public long totalTime;
    private long pastTime;
    Window window;


    public GameState(Arena arena, Window window) throws Exception {
        super(arena, window);
        this.arena=arena;
        this.window = window;
        enemyController = new EnemyController(arena);
        towerController = new TowerController(arena);
        initialize();
    }

    public void initialize() throws Exception {
        totalTime = 0;
        pastTime = System.currentTimeMillis();
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
    public void update(Game game,WindowInterface.KEY action, Window window) throws Exception {
        enemyController.step(game, null, System.currentTimeMillis());
        towerController.step(game, action, System.currentTimeMillis());
        updateProjectiles();

    }

    @Override
    public void step(Game game, Window window, long time) throws Exception {

        WindowInterface.KEY key = window.processKey();
        if (key==WindowInterface.KEY.QUIT) {
            game.setState(new MenuState(new Menu(),window));
            return;
        }
        if(getModel().getChest().getLife()<=0){
            String FILE_PATH = "src/main/scores/scores.txt";
            List<Integer> highScores = new ArrayList<>();
            int novoScore = getModel().getScore().getScore();

            try {
                List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
                for (String line : lines) {
                    highScores.add(Integer.parseInt(line.trim()));
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }

            highScores.add(novoScore);
            Collections.sort(highScores, Collections.reverseOrder());

            if (highScores.size() > 6) {
                highScores = highScores.subList(0, 6);
            }

            try {
                Files.write(Paths.get(FILE_PATH), highScores.stream().map(Object::toString).toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.setState(new GameoverState(new Gameover(),window));
        }

        totalTime += getTimePassed();
        while(totalTime >=TIME_FIXED){
            update(game,key,window);
            totalTime -= TIME_FIXED;
        }
        getViewer().draw(window);
    }
    public void updateProjectiles() throws Exception {
        List<Projectile> allProjectiles = new ArrayList<>();
        for (Tower tower : arena.getTowers()) {
            tower.setEnemies(arena.getEnemies());
            allProjectiles.addAll(tower.getProjectiles());
        }
        arena.setProjectiles(allProjectiles);

        for (Projectile projectile : allProjectiles) {
            projectile.update();
        }
        Iterator<Projectile> projectileIterator = allProjectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            if (!projectile.isAlive()) {
                projectileIterator.remove();
            }
        }

    }
    public long getTimePassed() {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - pastTime;
        pastTime = currentTime;
        return timePassed;
    }
}