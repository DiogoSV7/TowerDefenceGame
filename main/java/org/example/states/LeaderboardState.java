package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.LeaderboardController;
import org.example.gui.Window;
import org.example.model.menu.Leaderboard;
import org.example.viewer.Viewer;
import org.example.viewer.menu.LeaderboardViewer;

public class LeaderboardState extends State<Leaderboard> {
    public LeaderboardState(Leaderboard model, Window window) {
        super(model, window);
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}

