package hu.unideb.inf.lali123.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 * @author Lajos
 *
 */
public class Options {
    private static Options instance = null;
    private Color player1Color = Color.RED, player2Color = Color.YELLOW;
    private boolean isComputerOpponent, isEasyGame;
    private String player1Name = "Player1", player2Name = "Player2";

    /**
     * @return
     */
    public static Options getInstance() {
        if (instance == null) {
            instance = new Options();
        }
        return instance;
    }

    /**
     * 
     */
    protected Options() {
        // Exists only to defeat instantiation.
    }

    /**
     * @return
     */
    public Color getPlayer1Color() {
        return player1Color;
    }

    /**
     * @return
     */
    public String getPlayer1Name() {
        return player1Name;
    }

    /**
     * @return
     */
    public Color getPlayer2Color() {
        return player2Color;
    }

    /**
     * @return
     */
    public String getPlayer2Name() {
        return player2Name;
    }

    /**
     * @return
     */
    public boolean isComputerOpponent() {
        return isComputerOpponent;
    }

    /**
     * @return
     */
    public StringProperty Player1Name() {
        return new SimpleStringProperty(player1Name);
    }

    /**
     * @return
     */
    public StringProperty Player2Name() {
        return new SimpleStringProperty(player2Name);
    }

    /**
     * @param isComputerOpponent
     */
    public void setComputerOpponent(boolean isComputerOpponent) {
        this.isComputerOpponent = isComputerOpponent;
    }

    /**
     * @param player1Color
     */
    public void setPlayer1Color(Color player1Color) {
        this.player1Color = player1Color;
    }

    /**
     * @param player1Name
     */
    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    /**
     * @param player2Color
     */
    public void setPlayer2Color(Color player2Color) {
        this.player2Color = player2Color;
    }

    /**
     * @param player2Name
     */
    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public boolean isEasyGame() {
        return isEasyGame;
    }

    public void setEasyGame(boolean isEasyGame) {
        this.isEasyGame = isEasyGame;
    }

}
