package org.example.states;
import org.example.controller.Controller;
import org.example.controller.menu.ControlsController;
import org.example.gui.Window;
import org.example.model.menu.Controls;
import org.example.viewer.menu.ControlsViewer;
import org.example.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ControlsStateTest {
    private ControlsState controlsState;
    private Controls mockControls;
    private Window mockWindow;
    private ControlsController mockControlsController;
    private ControlsViewer mockControlsViewer;

    @BeforeEach
    void setUp() {
        mockControls = Mockito.mock(Controls.class);
        mockWindow = Mockito.mock(Window.class);
        mockControlsController = Mockito.mock(ControlsController.class);
        mockControlsViewer = Mockito.mock(ControlsViewer.class);

        controlsState = new ControlsState(mockControls, mockWindow);
    }

    @Test
    void getViewer_ShouldReturnControlsViewer() {
        Viewer<Controls> viewer = controlsState.getViewer();
        assert viewer instanceof ControlsViewer;
    }

    @Test
    void getController_ShouldReturnControlsController() {
        Controller<Controls> controller = controlsState.getController();
        assert controller instanceof ControlsController;
    }

}
