package hu.unideb.inf.lali123.model;

import static org.junit.Assert.*;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
    static Player player;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        player = new Player("Test", Color.BLACK, true, 0);
    }

    @Test
    public void testPlayer() {
        assertNotNull(player);
    }

    @Test
    public void testAddScore() {
        assertEquals(0, player.getScore());
        player.addScore();
        assertEquals(1, player.getScore());
    }

    @Test
    public void testGetColor() {
        assertEquals(Color.BLACK, player.getColor());
    }

    @Test
    public void testGetName() {
        assertEquals("Test", player.getName());
    }

}
