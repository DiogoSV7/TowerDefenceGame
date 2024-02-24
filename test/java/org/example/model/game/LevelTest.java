package org.example.model.game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevelTest {
    @Test
    void setThreshold() {
        Level level = new Level();
        level.setScoreThreshold(1000);
        assertEquals(1000, level.getScoreThreshold());
    }
    @Test
    public void testUpdateLevelBelowScoreThreshold() {
        Level level = new Level();
        Score score = Mockito.mock(Score.class);
        Mockito.when(score.getScore()).thenReturn(500);
        level.updateLevel(score);
        assertEquals(1, level.getLevel());
        assertEquals(1000, level.getScoreThreshold());
    }

    @Test
    public void testUpdateLevelAboveScoreThreshold() {
        Level level = new Level();
        Score score = Mockito.mock(Score.class);
        Mockito.when(score.getScore()).thenReturn(1500);
        level.updateLevel(score);
        assertEquals(2, level.getLevel());
        assertEquals(2000, level.getScoreThreshold());
    }

    @Test
    public void testUpdateLevelMultipleTimes() {
        Level level = new Level();
        Score score = Mockito.mock(Score.class);
        Mockito.when(score.getScore()).thenReturn(3000);
        level.updateLevel(score);
        level.updateLevel(score);
        assertEquals(3, level.getLevel());
        assertEquals(3000, level.getScoreThreshold());
    }

    @Test
    void testGetLevel() {
        Level level = new Level();
        assertEquals(1, level.getLevel());
    }
}
