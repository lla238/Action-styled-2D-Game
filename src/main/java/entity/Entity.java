package entity;

import game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The `Entity` class represents a basic entity in the game.
 * It serves as a base class for other entities and includes properties
 * such as x and y coordinates to represent the position, and a speed attribute.
 */
public class Entity {
    public int x, y;
    public int speed;
    public GamePanel gp;
    public String direction = "up";
    public BufferedImage stein;
    public Rectangle solidArea;
    public int solidAreaX, solidAreaY;
    
    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    public Entity(GamePanel gp){
        this.gp = gp;
    }
}
