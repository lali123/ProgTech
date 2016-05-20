package hu.unideb.inf.lali123.model;

import hu.unideb.inf.lali123.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents a current state of the game.
 * 
 * @author Lajos
 *
 */
public class Game {
    private Player player1, player2;
    private Board table;

    /**
     * Logger for logging.
     */
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Construct game.
     * 
     * @param player1
     * @param player2
     * @param table
     */
    public Game(Player player1, Player player2, Board table) {
        super();
        this.player1 = player1;
        this.player2 = player2;
        this.table = table;
        logger.info("Game created.");
    }

    /**
     * Get player1.
     * 
     * @return
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Get player2.
     * 
     * @return
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Get the game table.
     * 
     * @return
     */
    public Board getTable() {
        return table;
    }

    /**
     * Set player1.
     * 
     * @param player1
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Set player2.
     *  
     * @param player2
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Set the game table.
     * 
     * @param table
     */
    public void setTable(Board table) {
        this.table = table;
    }

    
    /**
     * Return the winner player score.
     * 
     * @return
     */
    public int getPlayerScore() {
        int base = 10000;
        int playerScore = base + getRowBonusScore() + getSpaceBonusScore();
        logger.info("Get player score: " + playerScore);
        return playerScore;
    }

    /**
     * Bonus for free rows.
     * 
     * @return
     */
    public int getRowBonusScore() {
        return getEmptyRows() * 1000;
    }

    /**
     * Return number of empty rows.
     * 
     * @return
     */
    private int getEmptyRows() {
        boolean isEmpty = true;
        int count = 0;
        for (int i = 0; i < table.getROW(); i++) {
            for (int j = 0; j < table.getCOLUMN(); j++) {
                if (table.getTable()[j][i] != 0) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                count++;
            } else {
                isEmpty = true;
            }
        }
        return count;
    }

    
    /**
     * Return bonus for free spaces.
     * 
     * @return
     */
    public int getSpaceBonusScore() {
        return getEmptyPlaces() * 100;
    }

    /**
     * Return number of empty spaces.
     * 
     * @return
     */
    public int getEmptyPlaces() {
        int count = 0;
        for (int i = 0; i < table.getROW(); i++) {
            for (int j = 0; j < table.getCOLUMN(); j++) {
                if (table.getTable()[j][i] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
