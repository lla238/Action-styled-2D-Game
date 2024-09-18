import entity.Player;
import game.GamePanel;
import game.KeyCatcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PlayerTest {

    private Player player;
    private KeyCatcher keyCatcher;

    @Before
    public void setUp() {
        // Set up before each test
        GamePanel gamePanel = new GamePanel();
        keyCatcher = new KeyCatcher();
        player = new Player(gamePanel, keyCatcher);
    }

    @Test
    public void testInitialization() {
        // Test entity initialization
        assertEquals(4, player.speed);
        assertEquals("up", player.direction);
        assertNotNull(player.solidArea);
        assertEquals(8, player.solidArea.x);
        assertEquals(16, player.solidArea.y);
        assertEquals(32, player.solidArea.width);
        assertEquals(32, player.solidArea.height);
        assertFalse(player.collisionOn);
        assertEquals(0, player.actionLockCounter);
    }

    @Test
    public void testAddScore() {
        // Test adding score
        player.changeScore(10);
        assertEquals("10",player.getScore(10));
        player.changeScore(20);
        assertEquals("30", player.getScore(20));
    }

    @Test
    public void testGetScore() {
        // Test getting score
        assertEquals("0", player.getScore(10));
        player.changeScore(15);
        assertEquals("15", player.getScore(10));
    }

    @Test
    public void testSetDefaultValues() {
        // Test setting default values
        player.setDefaultValues();
        assertEquals(player.gp.tileSize, player.x);
        assertEquals(9 * player.gp.tileSize, player.y);
        assertEquals("up", player.direction);
    }
    
    @Test
    public void testGetImage() {
        // Test if images are successfully loaded
        player.getImage();

        // Check if images are not null
        assertNotNull(player.stein);
        
    }
    
    
}
    

