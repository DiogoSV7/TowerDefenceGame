package org.example.gui;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.io.IOException;

public interface WindowInterface {
    KEY processKey() throws IOException;


    void drawText(Position position, String text, String color);


    void drawIntoGameText(Position position, String text, String color);

    void drawPath(Position position);
    void drawPixel(Position position);

    enum KEY {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT,A,C,M,U,
        NUM_1, NUM_2, NUM_3, NUM_4, NUM_5, NUM_6, NUM_7, NUM_8, NUM_9;
        public static KEY fromNumericValue(int numericValue) {
        switch (numericValue) {
            case 1:
                return NUM_1;
            case 2:
                return NUM_2;
            case 3:
                return NUM_3;
            case 4:
                return NUM_4;
            case 5:
                return NUM_5;
            case 6:
                return NUM_6;
            case 7:
                return NUM_7;
            case 8:
                return NUM_8;
            case 9:
                return NUM_9;
            default:
                return NONE;
        }
    }}


    void drawTower(Position position, Tower tower);

    void drawEnemy(Position position, Enemy enemy);


    void drawWall(Position position);
    void drawProjectiles(Position position, Window window);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}
