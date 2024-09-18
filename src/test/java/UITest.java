import org.junit.Test;

import game.GamePanel;
import game.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class UITest {

    @Test
    public void testShowMsg() {
        GamePanel gamePanel = new GamePanel();
        UI ui = new UI(gamePanel);

        // Set a message
        ui.showMsg("Hello world");

        // Verify that the message is set
        assertTrue(ui.msgOn);
        assertEquals("Hello world", ui.message);

        // Verify that the message counter is reset
        assertEquals(0, ui.messageCounter);
    }

    @Test
    public void testDraw_GameFinish() {
        GamePanel gamePanel = new GamePanel();
        UI ui = new UI(gamePanel);
        ui.gameFinish = true;

        // Set a play time
        ui.playTime = 10.5;

        // Create a Graphics2D object for testing
        Graphics2D g2 = (Graphics2D) new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();

        // Draw the UI
        ui.draw(g2);

        assertNull(gamePanel.gameThread);
    }

    @Test
    public void testDraw_GameInProgress() {
        GamePanel gamePanel = new GamePanel();
        UI ui = new UI(gamePanel);
        ui.gameFinish = false;

        // Set a play time
        ui.playTime = 5.25;

        // Create a Graphics2D object for testing
        Graphics2D g2 = (Graphics2D) new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();

        // Draw the UI
        ui.draw(g2);

        assertFalse(ui.msgOn);
    }

    @Test
    public void testTimeCalculation() {
        GamePanel gamePanel = new GamePanel();
        UI ui = new UI(gamePanel);
        ui.gameFinish = false;

        // Set a play time
        ui.playTime = 0;

        // Call draw method multiple times to simulate time passing
        for (int i = 0; i < 60; i++) {
            ui.draw((Graphics2D) new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics());
        }

        // Verify that play time is calculated correctly (1 second passed)
        assertEquals(1.0, ui.playTime, 0.01);
    }
}
