package hu.unideb.inf.lali123.model;

public interface HighScoreDAO {
    public void addHighScore(HighScore highScore);

    public HighScores getAllHighScores();
}
