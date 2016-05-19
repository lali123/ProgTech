package hu.unideb.inf.lali123.model;

import static org.junit.Assert.*;
import javafx.scene.paint.Color;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {
    static Game game;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Board board = new Board(6, 7);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        
        game = new Game( 
                new Player("Test1", Color.BLACK, true, 0),
                new Player("Test1", Color.WHITE, false, 0), 
                board);
    }

    @Test
    public void testGame() {
        assertNotNull(game);
    }

    @Test
    public void testGetPlayerScore() {
        assertEquals(15800, game.getPlayerScore());
    }

    @Test
    public void testGetRowBonusScore() {
        assertEquals(2000, game.getRowBonusScore());
    }

    @Test
    public void testGetSpaceBonusScore() {
        assertEquals(3800, game.getSpaceBonusScore());
    }

    @Test
    public void testGetEmptyPlaces() {
        assertEquals(38, game.getEmptyPlaces());
    }

}
