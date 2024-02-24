package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Menu;
import org.example.viewer.menu.MenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MenuViewerTest {

    @Test
    void drawElements() {
        Menu menu = new Menu();
        MenuViewer menuViewer = new MenuViewer(menu);
        Window window = Mockito.mock(Window.class);
        menuViewer.drawElements(window);
        Mockito.verify(window, Mockito.times(menu.getTitleSize())).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
        Mockito.verify(window, Mockito.times(menu.getNumberEntries())).drawTextWithFontSize(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt());
    }
}
