    package org.example.controller.game;

    import org.example.Game;
    import org.example.controller.Controller;
    import org.example.gui.WindowInterface;
    import org.example.model.game.Level;
    import org.example.model.game.Position;
    import org.example.model.game.Score;
    import org.example.model.game.Wave;
    import org.example.model.game.arena.Arena;
    import org.example.model.game.elements.enemys.Enemy;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    public class EnemyController extends GameController {
        public List<Enemy> enemies ;
        private final Level level;
        private long lastMovement;
        private final Arena arena;
        private final Wave wave;
        private final Score scoreModel;


        public EnemyController(Arena arena) {
            super(arena);
            this.arena= arena;
            this.enemies = new ArrayList<>();
            this.lastMovement = 0;
            this.level= arena.getLevel();
            this.scoreModel = arena.getScore();
            this.wave= new Wave();
            wave.spawn(level.getLevel());
        }
        @Override
        public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
            if (time - lastMovement > 500) {
                moveEnemies();
                level.updateLevel(scoreModel);
                if (enemies.isEmpty()) {

                    wave.spawn(level.getLevel());
                    List<Enemy> newEnemies=wave.getEnemyList();
                    arena.setEnemies(newEnemies);
                    enemies = newEnemies;
                }

                this.lastMovement = time;
            }
        }
        public void moveEnemies() {
            List<Enemy> deadEnemies = new ArrayList<>();
            for (Enemy enemy : enemies) {
                enemy.moveEnemies(enemy);

                if (enemy.isDead()) {
                    deadEnemies.add(enemy);
                }
            }
            enemies.removeAll(deadEnemies);
            for(Enemy enemy: deadEnemies){
                updateScore(enemy);
            }

        }
        public void updateScore(Enemy enemy) {
            Position deathPosition;
            switch (enemy.getEnemySymbol()) {
                case 'S':
                    deathPosition = enemy.getDeathPosition();
                    if (deathPosition.getX() == 93 && deathPosition.getY() == 5) {
                        getModel().getChest().decreaseLife();
                        break;
                    }
                    scoreModel.incrementScore(50 );
                    getModel().setScore(scoreModel);
                    getModel().setCoins(getModel().getCoins() + 10);
                    break;
                case 'O':
                    deathPosition = enemy.getDeathPosition();
                    if (deathPosition.getX() == 91 && deathPosition.getY() == 5) {
                        getModel().getChest().decreaseLife();
                        break;
                    }
                    scoreModel.incrementScore(75 );
                    getModel().setScore(scoreModel);
                    getModel().setCoins(getModel().getCoins() + 20);

                    break;
                case 'G':
                    deathPosition = enemy.getDeathPosition();
                    if (deathPosition.getX() == 92 && deathPosition.getY() == 5) {
                        getModel().getChest().decreaseLife();
                        break;
                    }
                    scoreModel.incrementScore(100 );
                    getModel().setScore(scoreModel);
                    getModel().setCoins(getModel().getCoins() + 35);

                    break;
            }
        }
    }