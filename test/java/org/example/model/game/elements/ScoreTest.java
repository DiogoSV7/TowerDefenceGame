package org.example.model.game.elements;

import org.example.model.game.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    @Test
    public void testInitialScoreIsZero() {
        Score score = new Score();
        assertEquals(0, score.getScore());
    }

    @Test
    public void testIncrementScore() {
        Score score = new Score();
        score.incrementScore(10);
        assertEquals(10, score.getScore());
    }

    @Test
    public void testMultipleIncrementScore() {
        Score score = new Score();
        score.incrementScore(5);
        score.incrementScore(8);
        score.incrementScore(3);
        assertEquals(16, score.getScore());
    }

}
