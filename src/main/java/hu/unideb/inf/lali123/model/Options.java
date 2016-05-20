package hu.unideb.inf.lali123.model;

import hu.unideb.inf.lali123.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 * This class contains main options for the application.
 * 
 * @author Lajos
 *
 */
public class Options {
    private static Options instance = null;
    private Color player1Color = Color.RED, player2Color = Color.YELLOW;
    private boolean isComputerOpponent, isEasyGame;
    private String player1Name = "Player1", player2Name = "Player2";
    /**
     * Logger for logging.
     */
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Return the instance of the Options.
     * 
     * @return Options instance.
     */
    public static Options getInstance() {
        if (instance == null) {
            instance = new Options();
        }
        return instance;
    }

    /**
     * Constructor of Options.
     */
    protected Options() {
        // Exists only to defeat instantiation.
    }

    /**
     * Get player1 color.
     * 
     * @return Player1 cololr.
     */
    public Color getPlayer1Color() {
        return player1Color;
    }

    /**
     * Get player1 name.
     * 
     * @return Player1 name.
     */
    public String getPlayer1Name() {
        return player1Name;
    }

    /**
     * Get Player2 color.
     * 
     * @return Player2 color.
     */
    public Color getPlayer2Color() {
        return player2Color;
    }

    /**
     * Get Player2 name.
     * 
     * @return Player2 name.
     */
    public String getPlayer2Name() {
        return player2Name;
    }

    /**
     * Program use AI.
     * 
     * @return boolean.
     */
    public boolean isComputerOpponent() {
        return isComputerOpponent;
    }

    /**
     * Get player1 name.
     * 
     * @return New string property.
     */
    public StringProperty Player1Name() {
        return new SimpleStringProperty(player1Name);
    }

    /**
     * Get player2 name.
     * 
     * @return New string property.
     */
    public StringProperty Player2Name() {
        return new SimpleStringProperty(player2Name);
    }

    /**
     * Set computer opponent.
     * 
     * @param isComputerOpponent
     */
    public void setComputerOpponent(boolean isComputerOpponent) {
        logger.info("Set computer opponent.");
        this.isComputerOpponent = isComputerOpponent;
    }

    /**
     * Set player1 color.
     * 
     * @param player1Color
     */
    public void setPlayer1Color(Color player1Color) {
        logger.info("Set " + getPlayer1Name() + " color to "
                + player1Color.toString());
        this.player1Color = player1Color;
    }

    /**
     * Set player1 name.
     * 
     * @param player1Name
     */
    public void setPlayer1Name(String player1Name) {
        logger.info("Set player1 name to " + player1Name);
        this.player1Name = player1Name;
    }

    /**
     * Set player2 color.
     * 
     * @param player2Color
     */
    public void setPlayer2Color(Color player2Color) {
        logger.info("Set " + getPlayer2Name() + " color to "
                + player2Color.toString());
        this.player2Color = player2Color;
    }

    /**
     * Set player2 name.
     * 
     * @param player2Name
     */
    public void setPlayer2Name(String player2Name) {
        logger.info("Set player2 name to " + player2Name);
        this.player2Name = player2Name;
    }

    /**
     * Get that the game is easy.
     * 
     * @return boolean.
     */
    public boolean isEasyGame() {
        return isEasyGame;
    }

    /**
     * Get is easy the game.
     * 
     * @param isEasyGame
     */
    public void setEasyGame(boolean isEasyGame) {
        if (isEasyGame) {
            logger.info("Set game level to easy.");
        } else {
            logger.info("Set game level to hard.");
        }
        this.isEasyGame = isEasyGame;
    }

}
