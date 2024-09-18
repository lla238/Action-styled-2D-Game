import org.junit.Test;

import game.AssetSetter;
import game.GamePanel;

import static org.junit.Assert.*;

public class AssetSetterTest {

    @Test
    public void testSetObject() {
        GamePanel gp = new GamePanel();
        AssetSetter assetSetter = new AssetSetter(gp);

        assetSetter.setObject();

        // Verify that coins are set up at specific positions
        assertEquals(3 * gp.tileSize, gp.obj[0].x);
        assertEquals(6 * gp.tileSize, gp.obj[0].y);

        assertEquals(14 * gp.tileSize, gp.obj[1].x);
        assertEquals(8 * gp.tileSize, gp.obj[1].y);

        assertEquals(10 * gp.tileSize, gp.obj[2].x);
        assertEquals(5 * gp.tileSize, gp.obj[2].y);

        // Verify that special objects are set up at specific positions
        assertEquals(2 * gp.tileSize, gp.obj[3].x);
        assertEquals(3 * gp.tileSize, gp.obj[3].y);

        assertEquals(8 * gp.tileSize, gp.obj[4].x);
        assertEquals(9 * gp.tileSize, gp.obj[4].y);
    }

    @Test
    public void testSetEnemy() {
        GamePanel gp = new GamePanel();
        AssetSetter assetSetter = new AssetSetter(gp);

        assetSetter.setEnemy();

        // Verify that Fire enemies are set up at specific positions
        assertEquals(12 * gp.tileSize, gp.enemy[0].x);
        assertEquals(6 * gp.tileSize, gp.enemy[0].y);

        assertEquals(8 * gp.tileSize, gp.enemy[1].x);
        assertEquals(5 * gp.tileSize, gp.enemy[1].y);

        assertEquals(2 * gp.tileSize, gp.enemy[2].x);
        assertEquals(2 * gp.tileSize, gp.enemy[2].y);

        // Verify that Monster enemies are set up at specific positions
        assertEquals(5 * gp.tileSize, gp.enemy[3].x);
        assertEquals(6 * gp.tileSize, gp.enemy[3].y);

        assertEquals(14 * gp.tileSize, gp.enemy[4].x);
        assertEquals(9 * gp.tileSize, gp.enemy[4].y);
    }
}
