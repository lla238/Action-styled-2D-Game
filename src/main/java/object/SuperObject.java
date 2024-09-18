package object;


import game.GPanel;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * The SuperObject class serves as a parent class for all objects in the game.
 * It contains common attributes such as images, name, collision status, and position.
 */
// parent object for all objects in the game
public class SuperObject {
	
    public BufferedImage image;
    public BufferedImage recoverImage; // when the object disappear, recover the object by this image
    public String name;
    public boolean collision = true;
    public int x, y;
    public Graphics2D g2 = null;
    
    /**
     * Constructs a new SuperObject with a default recover image.
     */
    public SuperObject(){
        try{
            recoverImage = ImageIO.read(getClass().getResourceAsStream("/grass.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Draws the object on the specified graphics context with the given tile size.
     *
     * @param g2 The graphics context on which to draw the object.
     * @param pg The GamePanel containing information about the tile size.
     */
    public void draw(Graphics2D g2, GamePanel pg) {
        g2.drawImage(image, x, y, GPanel.tileSize, GPanel.tileSize, null);
        this.g2 = g2;
    }

    /**
     * Draws the recover image of the object.
     */
    public void drawRecover(){
        this.g2.drawImage(recoverImage,x,y,GPanel.tileSize, GPanel.tileSize, null);
    }
}
