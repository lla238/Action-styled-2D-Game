import enemy.SuperEnemy;
import game.GamePanel;
import object.SuperObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit test fixture for {@code CollisionTest}'s handler
 *
 */
public class CollisionTest {

    /**
     * Test the default collision set is right at the beginning
     */
    @Test
    public void testCollisionAttribute(){
        GamePanel gp = new GamePanel();
        gp.setupGame();

        System.out.println(gp.player.collisionOn);
        assertFalse(gp.player.collisionOn);

        boolean objTrue = false;

        for(SuperObject superObject:gp.obj){
            if(superObject!=null){
                objTrue |= superObject.collision;
            }
        }

        assertTrue(objTrue);

        boolean enemyTrue = false;

        for(SuperEnemy enemy:gp.enemy){
            if(enemy!=null){
                enemyTrue |= enemy.collision;
            }
        }
        assertTrue(enemyTrue);
    }

    /**
     * set player and coin collision and check the score
     */
    @Test
    public void testCollisionWithCoin(){
        GamePanel gp = new GamePanel();
        gp.setupGame();

        gp.player.x = 100;
        gp.player.y = 100;

        gp.obj[0].x = 100;
        gp.obj[0].y = 100;

        gp.collisionChecker.checkCell(gp.player);

        boolean collision = gp.obj[0].collision;
        assertFalse(collision);
        assertFalse(gp.player.collisionOn);

        int score = Integer.parseInt(gp.player.getScore(10));
        assertEquals(0,score);
    }

    /**
     * set player and cash collision and check the score
     */
    @Test
    public void testCollisionWithCash(){
        GamePanel gp = new GamePanel();
        gp.setupGame();

        gp.player.x = 100;
        gp.player.y = 100;

        gp.obj[3].x = 100;
        gp.obj[3].y = 100;

        gp.collisionChecker.checkCell(gp.player);

        boolean collision = gp.obj[3].collision;
        assertFalse(collision);
        assertFalse(gp.player.collisionOn);

        int score = Integer.parseInt(gp.player.getScore(10));
        assertEquals(1,score);
    }


    /**
     * set player and multiple object collision and check the score
     */
    @Test
    public void testCollisionWithMultiObj(){
        GamePanel gp = new GamePanel();
        gp.setupGame();

        gp.player.x = 100;
        gp.player.y = 100;

        gp.obj[0].x = 100;
        gp.obj[0].y = 100;

        gp.collisionChecker.checkCell(gp.player);

        boolean collision = gp.obj[0].collision;
        assertFalse(collision);
        assertFalse(gp.player.collisionOn);

        int score = Integer.parseInt(gp.player.getScore(10));
        assertEquals(0,score);

        gp.obj[3].x = 100;
        gp.obj[3].y = 100;
        gp.collisionChecker.checkCell(gp.player);

        assertFalse(gp.obj[0].collision);
        assertFalse(gp.obj[3].collision);
        assertFalse(gp.player.collisionOn);

        score = Integer.parseInt(gp.player.getScore(10));
        assertEquals(2,score);


    }

    /**
     * set player and enemy collision and check the end of the game
     */
    @Test
    public void testCollisionWithFire(){
        GamePanel gp = new GamePanel();
        gp.setupGame();

        gp.player.x = 100;
        gp.player.y = 100;

        gp.enemy[0].x = 100;
        gp.enemy[0].y = 100;

        gp.collisionChecker.checkCell(gp.player);

        boolean collision = gp.enemy[0].collision;
        assertFalse(collision);
        assertFalse(gp.player.collisionOn);
        int score = Integer.parseInt(gp.player.getScore(10));
        assertEquals(1, score);
    }

    /**
     * set player and coin collision and check the score and a more flexible bounder
     */
    @Test
    public void testCollisionWithCoinFlexible(){
        GamePanel gp = new GamePanel();
        gp.setupGame();

        gp.player.x = 101;
        gp.player.y = 102;

        gp.obj[0].x = 100;
        gp.obj[0].y = 100;

        gp.collisionChecker.checkCell(gp.player);

        boolean collision = gp.obj[0].collision;
        assertFalse(collision);
        assertFalse(gp.player.collisionOn);

        int score = Integer.parseInt(gp.player.getScore(10));
        assertEquals(0,score);
    }

    /**
     * set player and enemy collision and check the end of the game
     */
    @Test
    public void testCollisionWithFireFlexible(){
        GamePanel gp = new GamePanel();
        gp.setupGame();

        gp.player.x = 102;
        gp.player.y = 102;

        gp.enemy[0].x = 100;
        gp.enemy[0].y = 100;

        gp.collisionChecker.checkCell(gp.player);

        boolean collision = gp.enemy[0].collision;
        assertFalse(collision);
        assertFalse(gp.player.collisionOn);
    }
}
