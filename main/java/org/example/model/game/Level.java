package org.example.model.game;

public class Level {
    private int level;
    private int scoreThreshold;

    public Level() {
        this.level = 1;
        this.scoreThreshold = 1000;
    }

    public int getLevel() {
        return level;
    }

    public int getScoreThreshold() {
        return scoreThreshold;
    }

    public void setScoreThreshold(int scoreThreshold) {
        this.scoreThreshold = scoreThreshold;
    }

    public void updateLevel(Score newScore) {
        if (newScore.getScore() >= scoreThreshold) {
            level++;
            scoreThreshold += 1000;
        }
    }


}
