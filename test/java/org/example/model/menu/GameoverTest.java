package org.example.model.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameoverTest {

    @Test
    void testGetTitle() {
        Gameover gameover = new Gameover();
        String expectedTitle = " #####     ##     ##   ##  #######            #####   ##   ##  #######  ######";
        assertEquals(expectedTitle, gameover.getTitle(0));
    }

    @Test
    void testGetTitleSize() {
        Gameover gameover = new Gameover();
        int expectedSize = 7;
        assertEquals(expectedSize, gameover.getTitleSize());
    }

    @Test
    void testGetEntry() {
        Gameover gameover = new Gameover();
        String expectedEntry = "Press Enter to return to Menu";
        assertEquals(expectedEntry, gameover.getEntry());
    }
}
