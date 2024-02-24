package org.example.model.game;

import org.example.viewer.game.GameViewer;

public class Score{
    private int score;
    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScore(int points) {
        score += points;
    }


}
