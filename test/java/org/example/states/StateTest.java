package org.example.states;
import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StateTest {

    private State<TestModel> testState;
    private TestModel testModel;
    private Viewer<TestModel> mockViewer;
    private Controller<TestModel> mockController;
    private Window mockWindow;
    private State<TestModel> state;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        mockGame = Mockito.mock(Game.class);
        mockWindow = Mockito.mock(Window.class);
        mockViewer = Mockito.mock(Viewer.class);
        mockController = Mockito.mock(Controller.class);

        state = new State<TestModel>(new TestModel(), mockWindow) {
            @Override
            protected Viewer<TestModel> getViewer() {
                return mockViewer;
            }

            @Override
            protected Controller<TestModel> getController() {
                return mockController;
            }
        };
    }
    @Test
    void step_ShouldInvokeControllerStep() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.UP;
        long time = System.currentTimeMillis();

        when(mockWindow.processKey()).thenReturn(action);

        state.step(mockGame, mockWindow, time);
        verify(mockController).step(mockGame, action, time);
    }

    @Test
    void step_ShouldInvokeViewerDrawAfterControllerStep() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.DOWN;
        long time = System.currentTimeMillis();

        when(mockWindow.processKey()).thenReturn(action);
        state.step(mockGame, mockWindow, time);
        inOrder(mockController, mockViewer).verify(mockController).step(mockGame, action, time);
        inOrder(mockController, mockViewer).verify(mockViewer).draw(mockWindow);
    }
    @Test
    void draw_ShouldInvokeViewerDraw() throws IOException, URISyntaxException {
        state.draw(mockWindow);
        verify(mockViewer).draw(mockWindow);
    }

    private static class TestModel {
    }
}
