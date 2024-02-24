package org.example.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void testGetTitleSize() {
        Menu menu = new Menu();
        assertEquals(8, menu.getTitleSize());
    }

    @Test
    public void testNextEntry() {
        Menu menu = new Menu();
        menu.nextEntry();
        assertEquals(1, menu.currentEntry);
        menu.nextEntry();
        assertEquals(2, menu.currentEntry);
    }

    @Test
    public void testPreviousEntry() {
        Menu menu = new Menu();
        menu.previousEntry();
        assertEquals(3, menu.currentEntry);
        menu.previousEntry();
        assertEquals(2, menu.currentEntry);
    }

    @Test
    public void testGetEntry() {
        Menu menu = new Menu();
        assertEquals("Start", menu.getEntry(0));
        assertEquals("HighScore", menu.getEntry(1));
    }

    @Test
    public void testIsSelected() {
        Menu menu = new Menu();
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
    }

    @Test
    public void testIsSelectedExit() {
        Menu menu = new Menu();
        assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedExit());
    }

    @Test
    public void testIsSelectedStart() {
        Menu menu = new Menu();
        assertTrue(menu.isSelectedStart());
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
    }

    @Test
    public void testIsSelectedLeaderboard() {
        Menu menu = new Menu();
        assertFalse(menu.isSelectedLeaderboard());
        menu.nextEntry();
        assertTrue(menu.isSelectedLeaderboard());
    }

    @Test
    public void testIsSelectedControls() {
        Menu menu = new Menu();
        assertFalse(menu.isSelectedControls());
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedControls());
    }

    @Test
    public void testGetNumberEntries() {
        Menu menu = new Menu();
        assertEquals(4, menu.getNumberEntries());
    }
}
