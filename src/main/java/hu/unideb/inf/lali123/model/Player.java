package hu.unideb.inf.lali123.model;

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
    }

    /**
     * 
     */
    public void addScore(){
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
