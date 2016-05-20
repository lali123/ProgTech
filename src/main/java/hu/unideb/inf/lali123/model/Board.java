package hu.unideb.inf.lali123.model;

import hu.unideb.inf.lali123.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class for game board.
 * 
 * @author Lajos
 *
 */
public class Board{
    private int ROW, COLUMN;
    private int[][] table = new int[ROW][COLUMN];
    private int supportedPlayer;

    /**
     * Logger for logging.
     */
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Constructor of Board class.
     * 
     * @param rOW
     * @param cOLUMN
     */
    public Board(int rOW, int cOLUMN) {
        super();
        ROW = rOW;
        COLUMN = cOLUMN;
        this.table = new int[COLUMN][ROW];
        supportedPlayer = 1;
        logger.info("Board created.");
    }
    
    /**
     * Check a disk can fit in the given column.
     * 
     * @param column
     * @return boolean.
     */
    public boolean applicable(int column) {
        return table[column][0] == 0;
    }

    /**
     * Check is there a winner
     * 
     * @return 0 - no winner, 1 - 1.player, 2 - 2.player, 3 - draw game.
     */
    public int checkWinner() {

        // horizontal
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < 4; col++) {
                if (table[col][row] != 0
                        && table[col][row] == table[col + 1][row]
                        && table[col][row] == table[col + 2][row]
                        && table[col][row] == table[col + 3][row]) {
                    return table[col][row];
                }
            }
        }

        // vertical
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < COLUMN; col++) {
                if (table[col][row] != 0
                        && table[col][row] == table[col][row + 1]
                        && table[col][row] == table[col][row + 2]
                        && table[col][row] == table[col][row + 3]) {
                    return table[col][row];
                }
            }
        }

        // diagonal up
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (table[col][row] != 0
                        && table[col][row] == table[col + 1][row + 1]
                        && table[col][row] == table[col + 2][row + 2]
                        && table[col][row] == table[col + 3][row + 3]) {
                    return table[col][row];
                }
            }
        }

        // diagonal down
        for (int row = 3; row < ROW; row++) {
            for (int col = 0; col < 4; col++) {
                if (table[col][row] != 0
                        && table[col][row] == table[col + 1][row - 1]
                        && table[col][row] == table[col + 2][row - 2]
                        && table[col][row] == table[col + 3][row - 3]) {
                    return table[col][row];
                }
            }
        }

        // check draw game
        if (isColumnFull(0) && isColumnFull(1) && isColumnFull(2)
                && isColumnFull(3) && isColumnFull(4) && isColumnFull(5)
                && isColumnFull(6)) {
            return 3;
        }

        return 0;
    }
    
    /**
     * Make empty the game table.
     */
    public void emptyTable() {
        logger.info("Initialize board.");
        table = new int[COLUMN][ROW];
    }

    /**
     * Get table number of columns.
     * 
     * @return
     */
    public int getCOLUMN() {
        return COLUMN;
    }

    /**
     * Get table number of rows.
     * 
     * @return
     */
    public int getROW() {
        return ROW;
    }

    /**
     * Get which player turn.
     * 
     * @return
     */
    public int getSupportedPlayer() {
        return supportedPlayer;
    }

    /**
     * Get the whole table with the current state.
     * 
     * @return
     */
    public int[][] getTable() {
        return table;
    }

    /**
     * @param column
     * @return
     */
    public int getThrownRow(int column) {
        int rows = ROW;
        for (int i = rows - 1; i >= 0; i--) {
            if (table[column][i] != 1 && table[column][i] != 2) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Check is the column full.
     * 
     * @param column
     * @return boolean.
     */
    public boolean isColumnFull(int column) {
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            if (table[column][i] == 1 || table[column][i] == 2) {
                count++;
            }
        }
        if (count == 6) {
            return true;
        }
        return false;
    }

    /**
     * Check has the game  ended.
     * 
     * @return
     */
    public boolean isEndGame() {
        if (checkWinner() == 0) {
            return false;
        } else {
            if (!Options.getInstance().isComputerOpponent()) {
                logger.info("Game ended.");
            }
            return true;
        }
    }

    /**
     * Print out the game table.
     */
    public void printTable() {

        System.out.println("XXXXXXXXXXXXX");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (table[j][i] == 1 || table[j][i] == 2) {
                    System.out.print(table[j][i] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("XXXXXXXXXXXXX");
        System.out.println();
    }

    /**
     * Set the number of columns.
     * 
     * @param cOLUMN
     */
    public void setCOLUMN(int cOLUMN) {
        COLUMN = cOLUMN;
    }

    /**
     * Set the number of rows.
     * 
     * @param rOW
     */
    public void setROW(int rOW) {
        ROW = rOW;
    }

    /**
     * Set the table.
     * 
     * @param table
     */
    public void setTable(int[][] table) {
        this.table = table;
    }

    /**
     * Take a disk to a specified column.
     * 
     * @param column specified column.
     * @param player supported player.
     */
    public void takeDisk(int column, int player) {
        if (!Options.getInstance().isComputerOpponent()) {
            logger.info("Take disk to " + column);            
        }
        int rows = ROW;
        for (int i = rows - 1; i >= 0; i--) {
            if (table[column][i] != 1 && table[column][i] != 2) {
                table[column][i] = player;
                break;
            }
        }
        supportedPlayer = (supportedPlayer == 1) ? 2 : 1;
    }

    /**
     * Undo last in a given column.
     * 
     * @param column
     */
    public void undoMove(int column) {
        for (int i = 0; i < ROW; ++i) {
            if (table[column][i] != 0) {
                table[column][i] = 0;
                break;
            }
        }
    }
}
