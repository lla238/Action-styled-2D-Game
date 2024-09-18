package enemy;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * The ENMY_Monster class represents a specific type of enemy - Monster.
 * It extends the SuperEnemy class, sets the name to "Fire," and loads the Monster's image.
 */
public class ENMY_Monster extends SuperEnemy {
    /**
     * Constructs a new Monster enemy with the default name "Fire" and loads its image.
     */
    public ENMY_Monster(){
        name = "Monster";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/monster.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Moves the Monster enemy by the specified amounts in the x and y directions.
     *
     * @param moveX The amount to move the Monster along the x-axis.
     * @param moveY The amount to move the Monster along the y-axis.
     */
    public void move(int moveX,int moveY){
        this.x += moveX;
        this.y += moveY;
    }
}