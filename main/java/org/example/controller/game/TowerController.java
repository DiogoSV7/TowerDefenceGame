package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.towers.*;

import java.util.ArrayList;
import java.util.List;

public class TowerController extends GameController {
    int coins;
    private final List<Tower> towerList;
    private final Arena arena;
    private boolean selected;
    private Position position;
    public TowerController(Arena arena) {
        super(arena);
        this.arena=arena;
        this.towerList =new ArrayList<>();
        this.selected=false;

    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws Exception {
        for(Tower tower: arena.getTowers()){
            tower.update();
        }
        ArcherTower archerTower;
        CanonTower canonTower;
        MageTower mageTower;
        coins = getModel().getCoins();
        switch (action) {
            case NUM_1:
                position=new Position(21, 2);
                selected=true;
                break;
            case NUM_2:
                position=new Position(34,11);
                selected=true;
                break;
            case NUM_3:
                position=new Position(34,25);
                selected=true;
                break;
            case NUM_4:
                position=new Position(14,32);
                selected=true;
                break;
            case NUM_5:
                position=new Position(61,36);
                selected=true;
                break;
            case NUM_6:
                position=new Position(83,28);
                selected=true;
                break;
            case NUM_7:
                position=new Position(101,18);
                selected=true;
                break;
            case NUM_8:
                position=new Position(84,6);
                selected=true;
                break;
            case NUM_9:
                position=new Position(100,6);
                selected=true;
                break;
            case C:
                if (selected) {
                    if (arena.getCoins() >= 100) {
                        int newCoins = arena.getCoins() - 100;
                        arena.setCoins(newCoins);
                        canonTower = new CanonTower(position.getX(), position.getY());
                        arena.addTowers(canonTower);
                    }
                }
                break;
            case A:
                if (selected) {
                    if (arena.getCoins() >= 250) {
                        int newCoins = arena.getCoins() - 250;
                        arena.setCoins(newCoins);
                        archerTower = new ArcherTower(position.getX(), position.getY());
                        arena.addTowers(archerTower);
                    }
                }
                break;
            case M:
                if (selected) {
                    if (arena.getCoins() >= 500) {
                        int newCoins = arena.getCoins() - 500;
                        arena.setCoins(newCoins);
                        mageTower = new MageTower(position.getX(), position.getY());
                        arena.addTowers(mageTower);
                    }
                }
                break;
            case U:
                if(selected){
                    if(arena.getCoins() >=300){
                        int newCoins = arena.getCoins() -300;
                        arena.setCoins(newCoins);
                        for(Tower tower: arena.getTowers()){
                            if(tower.getPosition().equals(position)){
                                tower.upgrade();
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    public List<Tower> getTowerList() {
        return towerList;
    }
}
