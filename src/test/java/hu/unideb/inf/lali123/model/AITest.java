package hu.unideb.inf.lali123.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class AITest {
    static AI ai;
    static Heuristic heuristic;
    static Board board;
    static int[] columns;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ai = new AI();
        columns = new int[] { 0, 1, 2, 3, 4, 5, 6 };
        board = new Board(6, 7);
        board.takeDisk(3, 1);
        board.takeDisk(4, 2);
        board.takeDisk(3, 1);
        board.takeDisk(4, 2);
        board.takeDisk(3, 1);
        heuristic = new Heuristic();
    }

    @Test
    public void testAI() {
        assertNotNull(ai);
    }

    @Test
    public void testGetAIMove() {
        int column = ai.getAIMove(board, 2);
        assertTrue(Arrays.stream(columns).anyMatch(a -> a == column));
    }

}
