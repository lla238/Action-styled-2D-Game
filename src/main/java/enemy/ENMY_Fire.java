package enemy;

import enemy.SuperEnemy;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * The ENMY_Fire class represents a specific type of enemy - Fire.
 * It extends the SuperEnemy class and sets the name and image for the Fire enemy.
 */
public class ENMY_Fire extends SuperEnemy {
    /**
     * Constructs a new Fire enemy with the default name "Fire" and loads its image.
     */
    public ENMY_Fire(){
        name = "Fire";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/fire.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}