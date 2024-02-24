package org.example.model.game.elements;

import org.junit.jupiter.api.Test;

public class ChestTest {
    @Test
    void testGetSymbol() {
        Chest chest = new Chest(1, 1);
        chest.getChestSymbol();
    }
    @Test
    void testdecreaseHealth() {
        Chest chest = new Chest(1, 1);
        chest.decreaseLife();
    }
}
