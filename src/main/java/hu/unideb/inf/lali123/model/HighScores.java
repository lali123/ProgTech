package hu.unideb.inf.lali123.model;

import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is the root element of the HighScore.xml file.
 * 
 * @author Lajos
 *
 */
@XmlRootElement(name = "highScores")
public class HighScores {
    private ArrayList<HighScore> highScores;

    public HighScores(ArrayList<HighScore> highScores) {
        super();
        this.highScores = highScores;
    }

    public HighScores() {
        this.highScores = new ArrayList<HighScore>();
    }

    @XmlElement
    public void setHighScore(ArrayList<HighScore> highScore) {
        this.highScores = highScore;
    }

    /**
     * Get sorted highScores by score.
     * 
     * @return
     */
    public ArrayList<HighScore> getHighScore() {
        Collections.sort(highScores, (hs1, hs2) -> {
            return Integer.parseInt(hs2.getScore()) - Integer.parseInt(hs1.getScore());
        });
        return highScores;
    }

    
    /**
     * Add new highScore to highScoreList.
     * 
     * @param hs
     */
    public void addHighScore(HighScore hs) {
        highScores.add(hs);
    }

    /**
     * Remove highScore from highScoreList.
     * 
     * @param hs
     */
    public void removeHighScore(HighScore hs) {
        highScores.remove(hs);
    }
}
