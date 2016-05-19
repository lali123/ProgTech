package hu.unideb.inf.lali123.model;

/**
 * @author Lajos
 *
 */
public class Game {
    private Player player1, player2;
    private Board table;

    /**
     * @param player1
     * @param player2
     * @param table
     */
    public Game(Player player1, Player player2, Board table) {
        super();
        this.player1 = player1;
        this.player2 = player2;
        this.table = table;
    }

    /**
     * @return
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * @return
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * @return
     */
    public Board getTable() {
        return table;
    }

    /**
     * @param player1
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * @param player2
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * @param table
     */
    public void setTable(Board table) {
        this.table = table;
    }
    
    public int getPlayerScore(){
        int base = 10000;
        
        return base + getRowBonusScore() + getSpaceBonusScore();
    }
    
    public int getRowBonusScore(){
        return getEmptyRows()*1000;
    }
    
    private int getEmptyRows() {
        boolean isEmpty = true;
        int count =0;
        for (int i = 0; i < table.getROW(); i++) {
            for (int j = 0; j < table.getCOLUMN(); j++) {
                if (table.getTable()[j][i]!=0) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                count++;
            }else {
                isEmpty = true;
            }
        }
        return count;
    }

    public int getSpaceBonusScore(){
        return getEmptyPlaces()*100;
    }
    
    public int getEmptyPlaces(){
        int count =0;
        for (int i = 0; i < table.getROW(); i++) {
            for (int j = 0; j < table.getCOLUMN(); j++) {
                if (table.getTable()[j][i]==0) {
                    count++;
                }
            }
        }
        return count;
    }

}
