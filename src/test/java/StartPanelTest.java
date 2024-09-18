import org.junit.Test;

import game.StartPanel;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import static org.junit.Assert.*;

public class StartPanelTest {

    @Test
    public void testStartButton() {
        StartPanel startPanel = new StartPanel();

        // Verify that the start button is created
        JButton startButton = startPanel.getStartButton();
        assertNotNull(startButton);

        // Verify the button text
        assertEquals("Start Game >>", startButton.getText());

        // Verify the button background color
        assertEquals(Color.BLUE, startButton.getBackground());

        // Verify the button foreground color
        assertEquals(Color.GREEN, startButton.getForeground());
 

        assertEquals(180, startButton.getWidth());
        assertEquals(50, startButton.getHeight());
    }

    @Test
    public void testTitleLabel() {
        StartPanel startPanel = new StartPanel();

        // Verify that the title label is created
        JLabel titleLabel = startPanel.titleLabel;
        assertNotNull(titleLabel);

        // Verify the label text
        assertEquals("RUN OUT MAZE !!!", titleLabel.getText());

        // Verify the label font
        Font expectedFont = new Font("Britannic", Font.BOLD, 24);
        assertEquals(expectedFont, titleLabel.getFont());

        // Verify the label foreground color
        assertEquals(Color.WHITE, titleLabel.getForeground());
  
        assertEquals(220, titleLabel.getWidth());
        assertEquals(50, titleLabel.getHeight());
    }

}
