package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Controls;
import org.example.viewer.menu.ControlsViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ControlsViewerTest {

    @Test
    void drawElements() {
        Controls controls = new Controls();
        ControlsViewer controlsViewer = new ControlsViewer(controls);

        Window window = Mockito.mock(Window.class);
        controlsViewer.drawElements(window);
        Mockito.verify(window, Mockito.atLeastOnce()).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
}
