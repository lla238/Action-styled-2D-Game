package object;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * The OBJ_Coin class represents a specific type of object - Coin.
 * It extends the {@code SuperObject} class, sets the name to "Coin," and loads the Coin's image.
 */
public class OBJ_Coin extends SuperObject{
    /**
     * Constructs a new Coin object with the default name "Coin" and loads its image.
     */
	public OBJ_Coin(){
        
		name = "Coin";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/coin.png"));
        
		}catch(IOException e){
            e.printStackTrace();
        }
    }
}
