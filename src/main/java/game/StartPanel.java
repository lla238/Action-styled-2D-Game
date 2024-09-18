package game;

import cell.CellManage;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**
 * The StartPanel class represents the panel displayed at the beginning of the game.
 * It provides a start button to initiate the game and displays the title "RUN OUT MAZE !!!".
 */
public class StartPanel extends GPanel {

    CellManage cellM = new CellManage(this);
    JLayeredPane layeredPane = new JLayeredPane();
    JButton startButton = new JButton("Start Game >>");
    public JLabel titleLabel = new JLabel("RUN OUT MAZE !!!");

    /**
     * Constructs a new GamePanel with specified dimensions and initializes necessary components.
     */
    public StartPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        // Add the StartPanel to the layered pane at a lower depth
        this.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(this, JLayeredPane.DEFAULT_LAYER);

        // Create the start button and add it to the layered pane at a higher depth
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.GREEN);
        startButton.setUI(new BasicButtonUI());

        startButton.setBounds(screenWidth / 2 - 80, screenHeight / 2 - 75, 180, 50);
        layeredPane.add(startButton, JLayeredPane.PALETTE_LAYER);

        // Create the start title and add it to the layered pane at a higher depth
        Font font = new Font("Britannic", Font.BOLD, 24); // Change "Serif" to your desired font
        titleLabel.setFont(font);

        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(screenWidth / 2 - 90, screenHeight / 2 - 150, 220, 50);
        layeredPane.add(titleLabel, JLayeredPane.PALETTE_LAYER);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    /**
     * Paints the game components on the panel.
     *
     * @param g The Graphics object to paint on.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // TILE
        cellM.draw(g2);// draw cells before player to avoid hiding the player
        g2.dispose();
    }
}
