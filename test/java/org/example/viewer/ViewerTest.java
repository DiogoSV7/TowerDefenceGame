package org.example.viewer;
import org.example.gui.Window;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class ViewerTest {

    @Test
    void testDraw() throws IOException {
        Object mockModel = Mockito.mock(Object.class);
        Viewer<Object> viewer = new Viewer<Object>(mockModel) {
            @Override
            public void drawElements(Window window) {
            }
        };
        Window window = Mockito.mock(Window.class);
        viewer.draw(window);
        Mockito.verify(window, Mockito.times(1)).clear();
        Mockito.verify(window, Mockito.times(1)).refresh();
    }
}