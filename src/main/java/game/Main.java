package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The `Main` class serves as the entry point for the 2D game application.
 * It creates a JFrame window to contain the game panel and initializes the game
 * components.
 * The main method sets up the window properties, adds the game panel, and
 * starts the game thread.
 * 
 */
public class Main {

    public static void main(String[] args) {

        // Create windows and settings
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Run Out Maze");

        // Create Start Panel(As title UI)
        StartPanel startPanel = new StartPanel();

        // Add game panel to window
        GamePanel gamePanel = new GamePanel();
        // gamePanel.setWindow(window);
        
        // Add action listener to start button
        startPanel.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BUG: startButton would keep existing, haven't found way to stop it.
                //startPanel.getStartButton().setVisible(false);

                // Switch panels
                window.remove(startPanel);
                window.add(gamePanel);
                window.pack();
                
                // Game panel set up
                gamePanel.setupGame();
                // Request keyboard focus for game panel
                gamePanel.requestFocusInWindow();
                gamePanel.startGameThread();
                }
        });

        // Add start panel to window
        window.add(startPanel.getLayeredPane());
        window.setSize(GPanel.screenWidth,GPanel.screenHeight); // Set window size manually
        // window.pack();

        window.setLocationRelativeTo(null); // Center the window on the screen
        window.setVisible(true);
    }
}
