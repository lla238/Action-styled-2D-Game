package object;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * The OBJ_Special class represents a specific type of object - Special.
 * It extends the SuperObject class, sets the name to "Special," and loads the Special object's image.
 */
public class OBJ_Special extends SuperObject{
    /**
     * Constructs a new Special object with the default name "Special" and loads its image.
     */
	public OBJ_Special(){
        
		name = "Special";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/special.png"));
        
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
