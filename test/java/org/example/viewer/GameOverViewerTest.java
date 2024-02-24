package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Gameover;
import org.example.viewer.menu.GameoverViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameOverViewerTest {

    @Test
    void testDrawElements() {
        Gameover gameover = new Gameover();
        GameoverViewer gameoverViewer = new GameoverViewer(gameover);
        Window window = Mockito.mock(Window.class);

        gameoverViewer.drawElements(window);
        verify(window, times(gameover.getTitleSize())).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.eq("RED"));
        verify(window, times(1)).drawText(Mockito.any(Position.class), Mockito.eq(gameover.getEntry()), Mockito.eq("#FFFFFF"));
    }
}