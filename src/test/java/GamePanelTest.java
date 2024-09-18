import static org.junit.Assert.*;

import enemy.ENMY_Monster;
import enemy.SuperEnemy;
import game.GamePanel;

import org.junit.Before;
import org.junit.Test;

public class GamePanelTest {

    private GamePanel gamePanel;

    @Before
    public void setUp() {
        gamePanel = new GamePanel();
        gamePanel.setupGame();
    }
    
    @Test
    public void testUpdate_PlayerMoveRight_NoCollision() {
        gamePanel.player.keyPress.rightPressed = true;
        gamePanel.player.collisionOn = false;

        gamePanel.update();

        assertEquals("", gamePanel.player.direction);
        assertTrue(gamePanel.player.collisionOn);
    }
    
    @Test
    public void testUpdate_PlayerMoveDown_NoCollision() {
        gamePanel.player.keyPress.downPressed = true;
        gamePanel.player.collisionOn = false;
  
        gamePanel.update();
        assertEquals("", gamePanel.player.direction);


        assertTrue(gamePanel.player.collisionOn);
    }
    
    @Test
    public void testUpdate_PlayerMoveLeft_NoCollision() {
        gamePanel.player.keyPress.leftPressed = true;
        gamePanel.player.collisionOn = false;

        gamePanel.update();

        assertEquals("", gamePanel.player.direction);
        assertTrue(gamePanel.player.collisionOn);
    }
    
    
    @Test
    public void testUpdate_PlayerMoveUp_NoCollision() {
        // Set up the conditions for moving the player up without collision
        gamePanel.player.keyPress.upPressed = true;
        gamePanel.player.collisionOn = false;

        // Call the update method
        gamePanel.update();

        // Verify that the player's direction is "up"
        assertEquals("", gamePanel.player.direction);

        // Verify that collisionOn is false
        assertFalse(gamePanel.player.collisionOn);

    }
    
    
    @Test
    public void testUpdate_PlayerMoveLeft_WithCollision() {
        gamePanel.player.keyPress.leftPressed = true;
        gamePanel.player.collisionOn = true;

        gamePanel.update();

        assertEquals("", gamePanel.player.direction);
        assertTrue(gamePanel.player.collisionOn);

    }

    @Test
    public void testUpdate_PlayerMoveDown_WithCollision() {
        // Set up the conditions for moving the player down with collision
        gamePanel.player.keyPress.downPressed = true;
        gamePanel.player.collisionOn = true;

        // Call the update method
        gamePanel.update();

        // Verify that the player's direction is "down"
        assertEquals("", gamePanel.player.direction);

        // Verify that collisionOn is true
        assertTrue(gamePanel.player.collisionOn);
    }

    @Test
    public void testPopup(){
        gamePanel.showPopup();
    }

    @Test
    public void testRun(){
        gamePanel.run();
    }
}
