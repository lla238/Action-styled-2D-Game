package enemy;

import game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * The SuperEnemy class serves as a base class for different types of enemies in the game.
 * It contains common attributes such as image, name, collision status, and position.
 */
public class SuperEnemy {
    public BufferedImage image;
    public String name;
    public boolean collision = true;
    public int x;
    public int y;
    
    /**
     * Draws the enemy on the specified graphics context with the given tile size.
     *
     * @param g2 The graphics context on which to draw the enemy.
     * @param pg The GamePanel containing information about the tile size.
     */
    public void draw(Graphics2D g2, GamePanel pg) {
        g2.drawImage(image, x, y, pg.tileSize, pg.tileSize, null);
    }

}
