package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The `KeyCatcher` class implements the KeyListener interface to handle keyboard input for the game.
 * It tracks the state of specific keys (W, A, S, D) and provides methods to check whether each key is pressed.
 * The class is designed to be used in conjunction with the GamePanel class to capture and respond to player input.
 */
public class KeyCatcher implements KeyListener{
    public boolean upPressed = false;
    public boolean rightPressed = false;
    public boolean downPressed = false;
    public boolean leftPressed = false;
    
    public void keyTyped(KeyEvent e){

    }
    
    /**
     * Invoked when a key is pressed. Updates the corresponding flag based on the pressed key.
     *
     * @param e The KeyEvent for the pressed key.
     */
    
    public void keyPressed(KeyEvent e) {
        int keyResponse = e.getKeyCode();

        switch (keyResponse) {
            case KeyEvent.VK_W:
                // System.out.println("W is pressed");
                upPressed = true;
                break;
            case KeyEvent.VK_A:
                // System.out.println("A is pressed");
                leftPressed = true;
                break;
            case KeyEvent.VK_S:
                // System.out.println("S is pressed");
                downPressed = true;
                break;
            case KeyEvent.VK_D:
                // System.out.println("D is pressed");
                rightPressed = true;
                break;
        }
    }
    
    /**
     * Invoked when a key is released. Updates the corresponding flag based on the released key.
     *
     * @param e The KeyEvent for the released key.
     */
    public void keyReleased(KeyEvent e) {
        int keyResponse = e.getKeyCode();

        switch (keyResponse) {
            case KeyEvent.VK_W:
                // System.out.println("W is released");
                upPressed = false;
                break;
            case KeyEvent.VK_A:
                // System.out.println("A is released");
                leftPressed = false;
                break;
            case KeyEvent.VK_S:
                // System.out.println("S is released");
                downPressed = false;
                break;
            case KeyEvent.VK_D:
                // System.out.println("D is released");
                rightPressed = false;
                break;
  
        }
    }
}
