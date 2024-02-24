package org.example;

import org.example.gui.Window;
import org.example.model.menu.Menu;
import org.example.states.MenuState;
import org.example.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final Window window;

    private State state;
    public void setState(State state) {
        this.state = state;
    }


    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.window = new Window();
        this.state = new MenuState(new Menu(), window);
    }
    public Window getWindow() {
        return window;
    }

    public static void main(String[] args) throws Exception {
        new Game().start();
    }

    public void start() throws Exception {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, window, startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }
            catch (InterruptedException ignored) {
            }
        }
        window.close();
    }

}