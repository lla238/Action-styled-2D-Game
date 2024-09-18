package game;

import cell.CellManage;
import enemy.ENMY_Monster;
import enemy.SuperEnemy;
import entity.Player;
import object.SuperObject;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * The `GamePanel` class represents the main game panel where the game logic is
 * executed and rendered.
 * It extends JPanel and implements the Runnable interface to create a dedicated
 * thread for the game loop.
 * The panel includes settings for screen dimensions, tile size, and frames per
 * second (FPS).
 * It manages player input through a KeyCatcher and updates and renders the game
 * elements accordingly.
 */
public class GamePanel extends GPanel implements Runnable {

    // Game setting instances
    private final KeyCatcher keyPress; // KeyCatcher instance to handle player input.
    private final AssetSetter aSetter;
    // Tool classes to help with the game
    private final DecimalFormat dFormat;
    private final Random rand;
    protected CellManage cellM;
    public Player player;
    public CollisionChecker collisionChecker; // Collision checker
    public UI ui = new UI(this);
    public Thread gameThread; // thread responsible for running the game loop.
    // ENTITIES AND OBJECTS
    public SuperObject[] obj = new SuperObject[10];
    public SuperEnemy[] enemy = new SuperEnemy[10];
    public boolean isEnd = false;
    public boolean isWin = false;

    /**
     * Constructs a new GamePanel with specified dimensions and initializes
     * necessary components.
     */
    public GamePanel() {
        // Initialize private fields
        cellM = new CellManage(this);
        keyPress = new KeyCatcher();
        collisionChecker = new CollisionChecker(this);
        aSetter = new AssetSetter(this);
        player = new Player(this, keyPress);
        dFormat = new DecimalFormat("#0.00");
        rand = new Random();

        // set default to game
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyPress);
        this.setFocusable(true);

        // Initialize public fields
        ui = new UI(this);
    }

    /**
     * Sets up the game by initializing the game objects 
     * and resetting the player and play time.
     */
    public void setupGame() {
        this.removeKeyListener(keyPress);  
        KeyCatcher keyPress = new KeyCatcher(); 
        this.addKeyListener(keyPress); 
        aSetter.setObject();
        aSetter.setEnemy();
        player = new Player(this, keyPress);
        ui.playTime = 0;
    }

    /**
     * Starts the game loop by creating and starting a new thread.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Stops the game loop by setting the gameThread to null.
     * Displays a popup message when the game ends, showing the player's score and play time.
     * It also gives the player the option to restart the game or end it.
     */
    public void showPopup() {
        // The message
        String message = "";
        if(isEnd){
            message = "You Lose the Game.\n";
        } else if(isWin){
            message = "You Win the Game.\n";
        }
        message += "Your award score: "+player.getScore(10)+"\n";
        message += "Your time is: "+ dFormat.format(ui.playTime) +"\n\n";
        // The options
        String[] options = { "Restart Game", "End the Game" };

        // Show the option dialog
        int selectedOption = JOptionPane.showOptionDialog(this, message, "Game End",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        isEnd = false;
        isWin = false;

        // Handle the selected option
        resetGameFlags(selectedOption);
    }

    // Handle the selected option
    private void resetGameFlags(int selectedOption) {
        isEnd = false;
        isWin = false;
    
        // Handle the selected option
        if (selectedOption == 0) {
            System.out.println("Restart Game Now");
            setupGame();
        } else if (selectedOption == 1) {
            System.out.println("End the Game");
            System.exit(0);
        }
    }

    /**
     * The main game loop that updates and renders the game elements at a consistent
     * frame rate.
     */
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        //  Implement game loop
        while (gameThread != null) {
            
            // Update: update information such as character position
            update();
            if (isEnd || isWin) {
                showPopup();
            }
            // Draw: draw the screen with the information
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                // System.out.println("remaining time is " + remainingTime);
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Updates the game state, including the player's state and the state of all monsters.
     * this would be called every tick of the game loop.
     * since the game loop is running at a fixed frame rate, the game state is updated at a fixed rate.
     * it updates the player's state and the state of all monsters.
     */
    public void update() {
        player.update();
        // move the monster
        for(SuperEnemy monster:this.enemy){
            if(monster!=null && monster instanceof ENMY_Monster && monster.collision){
                int x = rand.nextInt(3) - 1;  // Generates a random integer between -1 and 1
                int y = rand.nextInt(3) - 1;  // Generates a random integer between -1 and 1
                ((ENMY_Monster) monster).move(x * 5,y * 5);
            }
        }
    }

    /**
     * Paints the game components on the panel.
     *
     * @param g The Graphics object to paint on.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // TILE
        cellM.draw(g2);// draw cells before player to avoid hiding the player

        // OBJECT
        for (SuperObject superObject : obj) {
            if (superObject != null && superObject.collision) {
                superObject.draw(g2, this);
            }
        }
        for (SuperEnemy superEnemy : enemy) {
            if (superEnemy != null) {
                superEnemy.draw(g2, this);
            }
        }
        
        player.draw(g2);
        ui.draw(g2);

        g2.dispose();
    }

    /**
     * Requests a repaint of the game panel. This should be called whenever the game state changes
     * and the changes should be reflected on the screen.
     */
    public void redraw() {
        repaint();
    }
}
