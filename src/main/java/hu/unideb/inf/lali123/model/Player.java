package hu.unideb.inf.lali123.model;

import hu.unideb.inf.lali123.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.paint.Color;

/**
 * @author Lajos
 *
 */
public class Player {
    private String name;
    private Color color;
    private boolean isCurrent;
    private int score;
    /**
     * Logger for logging.
     */
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * @param name
     * @param color
     * @param isCurrent
     * @param score
     */
    public Player(String name, Color color, boolean isCurrent, int score) {
        super();
        this.name = name;
        this.color = color;
        this.isCurrent = isCurrent;
        this.score = score;
        logger.info(name + " Player created");
    }

    /**
     * 
     */
    public void addScore(){
        logger.info("Add score to " + name);
        score++;
    }
    
    /**
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * @return
     */
    public boolean isCurrent() {
        return isCurrent;
    }

    /**
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param isCurrent
     */
    public void setCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

}
