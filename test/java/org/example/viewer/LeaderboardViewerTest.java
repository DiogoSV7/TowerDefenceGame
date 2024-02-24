package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Leaderboard;
import org.example.viewer.menu.LeaderboardViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class LeaderboardViewerTest {

    @Test
    void drawElements() throws IOException {
        Leaderboard leaderboard = new Leaderboard();
        LeaderboardViewer leaderboardViewer = new LeaderboardViewer(leaderboard);
        Window window = Mockito.mock(Window.class);
        leaderboardViewer.drawElements(window);
        Mockito.verify(window, Mockito.atLeastOnce()).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
}

