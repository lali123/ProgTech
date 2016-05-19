package hu.unideb.inf.lali123.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    static Board board;

    @Before
    public void initTable() {
        board = new Board(6, 7);
    }

    @Test
    public void testBoard() {
        assertNotNull(board);
    }

    @Test
    public void testApplicable() {
        board.takeDisk(0, 1);
        assertTrue(board.applicable(0));
    }

    @Test
    public void testNotApplicable() {
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        assertFalse(board.applicable(0));
    }

    @Test
    public void testCheckNoWinner() {
        int winner = board.checkWinner();
        assertEquals(0, winner);
    }

    @Test
    public void testCheckWinner() {
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        int winner = board.checkWinner();
        assertEquals(1, winner);
    }

    @Test
    public void testIsColumnFull() {
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        assertTrue(board.isColumnFull(0));
    }
    
    @Test
    public void testIsColumnNotFull() {
        board.takeDisk(0, 1);
        board.takeDisk(0, 2);
        board.takeDisk(0, 1);
        board.takeDisk(0, 2);
        board.takeDisk(0, 1);
        assertFalse(board.isColumnFull(0));
    }

    @Test
    public void testIsEndGame() {
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        board.takeDisk(0, 1);
        assertTrue(board.isEndGame());
    }

    @Test
    public void testTakeDisk() {
        board.takeDisk(0, 1);
        assertEquals(1, board.getTable()[0][5]);
    }
    
    @Test
    public void testTakeDiskToSecoundColoumn() {
        board.takeDisk(1, 2);
        assertEquals(2, board.getTable()[1][5]);
    }

    @Test
    public void testUndoMove() {
        board.takeDisk(0, 1);
        assertEquals(1, board.getTable()[0][5]);
        board.undoMove(0);
        assertEquals(0, board.getTable()[0][5]);
    }

}
