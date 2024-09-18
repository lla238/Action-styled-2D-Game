package entity;

import game.GamePanel;
import game.KeyCatcher;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * The `Player` class represents a player entity in the game.
 * It extends the base `Entity` class and includes additional properties
 * and methods specific to the player character.
 *
 * The player's position is updated based on keyboard input received
 * through the associated `KeyCatcher` instance, and it can be drawn
 * on the game panel using the provided `draw` method.
 */
public class Player extends Entity {
	
    public GamePanel gp;
    public KeyCatcher keyPress;
    public int collectScore = 0;

    /**
     * Constructs a new player with the specified GamePanel and KeyCatcher instances.
     *
     * @param gp       The GamePanel associated with the player.
     * @param keyPress The KeyCatcher instance for handling keyboard input.
     */
    public Player(GamePanel gp, KeyCatcher keyPress){
        super(gp);
        this.gp = gp;
        this.keyPress = keyPress;
        setDefaultValues();

        solidArea = new Rectangle(8, 16, 32, 32);

        //create a solid area for player

        setDefaultValues();
        getImage();
    }

    public int changeScore(int score){
        this.collectScore += score;
        return this.collectScore;
    }

    public String getScore(int i){
        return String.valueOf(this.collectScore);
    }
    
    public void setDefaultValues(){
        x = gp.tileSize;
        y = 9* gp.tileSize; // set x and y position of player
        speed = 4;
    }

    public void getImage(){

        try{
            
            stein = ImageIO.read(getClass().getResourceAsStream("/stein.png"));
        
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Updates the player's position based on keyboard input.
     */
    public void update(){
        
        if(keyPress.upPressed){
            direction = "up";
        }
        else if(keyPress.downPressed){
            direction = "down";
        }
        else if(keyPress.leftPressed){
            direction = "left";
        }
        else if(keyPress.rightPressed){
            direction = "right";
        }
        
        // CHECK TILE COLLISION
        this.collisionOn = false;
        gp.collisionChecker.checkCell(this);
        
        // If collision is false, player can move
        if(!this.collisionOn){
        	
            switch(direction){
                case "up": y -= speed; break;
                case "down": y += speed; break;
                case "left": x -= speed; break;
                case "right": x += speed; break;
                }
            } 
        direction="";
        }


    
    /**
     * Draws the player on the specified Graphics2D object.
     *
     * @param g2 The Graphics2D object to draw on.
     */
    public void draw(Graphics2D g2){

        BufferedImage image = stein;
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
