package game;

import enemy.ENMY_Fire;
import enemy.ENMY_Monster;
import object.OBJ_Coin;
import object.OBJ_Special;
/**
 * The AssetSetter class is responsible for setting up objects and enemies in the game.
 * It initializes the objects and enemies with specific properties such as type, position, etc.
 */
public class AssetSetter {
    GamePanel gp;
    /**
     * Constructs a new AssetSetter with the specified GamePanel.
     *
     * @param gp The GamePanel for which assets are set up.
     */
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    /**
     * Sets up the objects in the game, including coins and special objects, with specific positions.
     */
    public void setObject(){

        gp.obj[0] = new OBJ_Coin();
        gp.obj[0].x = 3 * gp.tileSize;
        gp.obj[0].y = 6 * gp.tileSize;

        gp.obj[1] = new OBJ_Coin();
        gp.obj[1].x = 14 * gp.tileSize;
        gp.obj[1].y = 8 * gp.tileSize;

        gp.obj[2] = new OBJ_Coin();
        gp.obj[2].x = 10 * gp.tileSize;
        gp.obj[2].y = 5 * gp.tileSize;

        gp.obj[3] = new OBJ_Special();
        gp.obj[3].x = 2 * gp.tileSize;
        gp.obj[3].y = 3 * gp.tileSize;

        gp.obj[4] = new OBJ_Special();
        gp.obj[4].x = 8 * gp.tileSize;
        gp.obj[4].y = 9 * gp.tileSize;
    }
    
    /**
     * Sets up the enemies in the game, including Fire enemies and Monster enemies, with specific positions.
     */
    public void setEnemy(){

        gp.enemy[0] = new ENMY_Fire();
        gp.enemy[0].x = 12 * gp.tileSize;
        gp.enemy[0].y = 6 * gp.tileSize;

        gp.enemy[1] = new ENMY_Fire();
        gp.enemy[1].x = 8 * gp.tileSize;
        gp.enemy[1].y = 5 * gp.tileSize;

        gp.enemy[2] = new ENMY_Fire();
        gp.enemy[2].x = 2 * gp.tileSize;
        gp.enemy[2].y = 2 * gp.tileSize;

        gp.enemy[3] = new ENMY_Monster();
        gp.enemy[3].x = 5 * gp.tileSize;
        gp.enemy[3].y = 6 * gp.tileSize;

        gp.enemy[4] = new ENMY_Monster();
        gp.enemy[4].x = 14 * gp.tileSize;
        gp.enemy[4].y = 9 * gp.tileSize;

    }
}
