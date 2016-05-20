package hu.unideb.inf.lali123.model;

/**
 * Interface for DAO implementation.
 * 
 * @author Lajos
 *
 */
public interface HighScoreDAO {
    /**
     * Write a new HighScore to HighScore.xml.
     * 
     * @param highScore
     */
    public void addHighScore(HighScore highScore);

    /**
     * Read HighScores from HighScore.xml.
     * 
     * @return
     */
    public HighScores getAllHighScores();
}
