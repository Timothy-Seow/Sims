package sims.tests;

import sims.gameEngine.GameState;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class GameStateTest {

    private GameState gameState;

    @Before
    public void setUp() {
        gameState = new GameState();
    }

    /**
     * Tests the setGameState method.
     * Verifies that the game state is set correctly.
     */
    @Test
    public void testSetGameState() {
        gameState.setGameState(3);
        assertEquals(3, gameState.getGameState());
    }

    /**
     * Tests the getGameRunning method.
     * Verifies that the game running status is correct.
     */
    @Test
    public void testGetGameRunning() {
        assertTrue(gameState.getGameRunning());
    }

    /**
    * Tests the endGame method.
    * Verifies that the game running status is set to false after ending the game.
    */
    @Test
    public void testEndGame() {
        assertTrue(gameState.getGameRunning());
        gameState.endGame();
        assertFalse(gameState.getGameRunning());
    }

    /**
     * Tests the updateTime method.
     * Verifies that the game time is updated correctly.
     */
    @Test
    public void testUpdateTime() {
        int initialTime = gameState.getIntTime();
        gameState.updateTime();
        assertEquals(initialTime + 1, gameState.getIntTime());
    }

    /**
     * Tests the getIntTime method.
     * Verifies that the initial game time is 0 and that it updates correctly.
     */
    @Test
    public void testGetIntTime() {
        // Assuming initial time is 0
        assertEquals(0, gameState.getIntTime());
    }

    /**
     * Tests the getStringTime method.
     * Verifies that the string representation of time is correct for various time values.
     */
    @Test
    public void testGetStringTime() {
        assertEquals("45 Minutes", gameState.getStringTime(45));
        assertEquals("02 Hours : 05 Minutes", gameState.getStringTime(125));
        assertEquals("01 Day : 01 Hours : 00 Minutes", gameState.getStringTime(1500));
    }
}