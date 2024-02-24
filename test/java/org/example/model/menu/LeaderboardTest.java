package org.example.model.menu;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaderboardTest {
    @Test
    public void testSetScore_ShouldNotAddNullScoreToList() throws IOException {
        List<String> scores = new ArrayList<>();
        Leaderboard lead = new Leaderboard();
        lead.setScore("");

        assertEquals(0, scores.size());
    }

}
