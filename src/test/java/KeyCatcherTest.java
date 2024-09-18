
import org.junit.Test;

import game.KeyCatcher;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.event.KeyEvent;

public class KeyCatcherTest {
	



    @Test
    public void testKeyPressed() {
        KeyCatcher keyCatcher = new KeyCatcher();
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_W));
        assertTrue(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_A));
        assertTrue(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertTrue(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_S));
        assertTrue(keyCatcher.upPressed);
        assertTrue(keyCatcher.downPressed);
        assertTrue(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_D));
        assertTrue(keyCatcher.upPressed);
        assertTrue(keyCatcher.downPressed);
        assertTrue(keyCatcher.leftPressed);
        assertTrue(keyCatcher.rightPressed);
        
    }

    @Test
    public void testKeyReleased() {
        KeyCatcher keyCatcher = new KeyCatcher();
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_W));
        assertTrue(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyReleased(createKeyEvent(KeyEvent.VK_W));
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_S));
        assertFalse(keyCatcher.upPressed);
        assertTrue(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyReleased(createKeyEvent(KeyEvent.VK_S));
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_A));
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertTrue(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyReleased(createKeyEvent(KeyEvent.VK_A));
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);

        keyCatcher.keyPressed(createKeyEvent(KeyEvent.VK_D));
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertTrue(keyCatcher.rightPressed);

        keyCatcher.keyReleased(createKeyEvent(KeyEvent.VK_D));
        assertFalse(keyCatcher.upPressed);
        assertFalse(keyCatcher.downPressed);
        assertFalse(keyCatcher.leftPressed);
        assertFalse(keyCatcher.rightPressed);
    }

    // Helper method to create a KeyEvent
    private KeyEvent createKeyEvent(int keyCode) {
        return new KeyEvent(new Component() {}, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, KeyEvent.CHAR_UNDEFINED);
    }
}

