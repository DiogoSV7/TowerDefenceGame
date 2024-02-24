package org.example.model.game.elements;

import org.junit.jupiter.api.Test;

public class TowerPositionsTest {
    @Test
    void testGetSymbol() {
        TowerPositions towerPositions = new TowerPositions(1, 1, 'a');
        towerPositions.getSymbol();
    }
}
