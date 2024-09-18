package game;

import enemy.ENMY_Fire;
import enemy.ENMY_Monster;
import enemy.SuperEnemy;
import entity.Player;
import object.OBJ_Coin;
import object.OBJ_Special;
import object.SuperObject;
/**
 * The CollisionChecker class is responsible for checking collisions between entities (e.g., player),
 * objects (e.g., coins, special objects), and enemies in the game.
 */
public class CollisionChecker {
    
	GamePanel gamePanel;

    private static final int COIN_SCORE = 1;
    private static final int SPECIAL_SCORE = 2;
    private static final int FIRE_PENALTY = -1;
	
    /**
     * Constructs a new CollisionChecker with the specified GamePanel.
     *
     * @param gamePanel The GamePanel for which collisions are checked.
     */
    public CollisionChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    
    /**
     * Checks collisions between the player entity and cells, objects, and enemies in the game.
     *
     * @param entity The player entity for which collisions are checked.
     */
    public void checkCell(Player entity){
        int entityLeft = entity.x + entity.solidArea.x;
        int entityRight = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTop = entity.y + entity.solidArea.y;
        int entityBottom = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityColLeft = entityLeft / gamePanel.tileSize;
        int entityColRight = entityRight / gamePanel.tileSize;
        int entityRowTop = entityTop / gamePanel.tileSize;
        int entityRowBottom = entityBottom / gamePanel.tileSize;


        try{
            switch(entity.direction){
                case "up":
                    entityRowTop = (entityTop - entity.speed)/GPanel.tileSize;
                    entity.collisionOn = checkCollision(entityColLeft,entityRowTop,entityColRight,entityRowTop);
                    break;
                case "down":
                    entityRowBottom = (entityBottom + entity.speed)/GPanel.tileSize;
                    entity.collisionOn = checkCollision(entityColLeft,entityRowBottom,entityColRight,entityRowBottom);
                    break;
                case "left":
                    entityColLeft = (entityLeft - entity.speed)/GPanel.tileSize;
                    entity.collisionOn = checkCollision(entityColLeft,entityRowTop,entityColLeft,entityRowBottom);
                    break;
                case "right":
                    entityColRight = (entityRight + entity.speed)/GPanel.tileSize;
                    entity.collisionOn = checkCollision(entityColRight,entityRowTop,entityColRight,entityRowBottom);
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            // assume when the player reach the border, it ran out of maze.
            gamePanel.isWin = true;
        }

        // to check the collision with the coin/special obj
        for(SuperObject superObject: gamePanel.obj){
            if(superObject instanceof OBJ_Coin && superObject.collision){
                int objectX = superObject.x / GPanel.tileSize;
                int objectY = superObject.y / GPanel.tileSize;
                boolean collision = checkCenterCollision(objectX,objectY,entityColLeft,entityColRight,entityRowTop,entityRowBottom);
                
                if(collision){
                    // no need to detect, each object should be collected once
                    superObject.collision = false;
                    gamePanel.ui.showMsg("Great!");
                    gamePanel.redraw();
                    // add the score to the player
                    entity.changeScore(COIN_SCORE);
                    break;
                }
              
            }

            if(superObject instanceof OBJ_Special && superObject.collision){
                int objectX = superObject.x / GPanel.tileSize;
                int objectY = superObject.y / GPanel.tileSize;
                boolean collision = checkCenterCollision(objectX,objectY,entityColLeft,entityColRight,entityRowTop,entityRowBottom);
                
                if(collision){
                    // no need to detect, each object should be collected once
                    superObject.collision = false;
                    gamePanel.ui.showMsg("Great!");
                    gamePanel.redraw();
                    entity.changeScore(SPECIAL_SCORE);
                    break;
                }
            }
        }

        // to check the collision with the coin/special obj
        for(SuperEnemy superEnemy: gamePanel.enemy){
            if(superEnemy instanceof ENMY_Monster && superEnemy.collision){
                
            	int objectX = superEnemy.x / GPanel.tileSize;
                int objectY = superEnemy.y / GPanel.tileSize;
                boolean collision = checkCenterCollision(objectX,objectY,entityColLeft,entityColRight,entityRowTop,entityRowBottom);
                
                if(collision){
                    // end of the game
                    gamePanel.isEnd = true;
                    superEnemy.collision = false;
                    break;
                    }
                }

                if(superEnemy instanceof ENMY_Fire && superEnemy.collision){
                
            	int objectX = superEnemy.x / GPanel.tileSize;
                int objectY = superEnemy.y / GPanel.tileSize;
                boolean collision = checkCenterCollision(objectX,objectY,entityColLeft,entityColRight,entityRowTop,entityRowBottom);
                
                if(collision){
                    superEnemy.collision = false;
                    gamePanel.ui.showMsg("YOU ARE ON FIRE!");           
                    entity.changeScore(FIRE_PENALTY);                      
                    break;
                }
            }
        }
    }


    /**
     * Check the collision by the two locations' cell
     * @param col1 first cell's column index
     * @param row1 first cell's row index
     * @param col2 second cell's column index
     * @param row2 second cell's row index
     * @return whether is collision
     */
    private boolean checkCollision(int col1, int row1, int col2, int row2) {
        int tileNum1 = gamePanel.cellM.mapCellNum[col1][row1];
        int tileNum2 = gamePanel.cellM.mapCellNum[col2][row2];
        return gamePanel.cellM.cell[tileNum1].collision || gamePanel.cellM.cell[tileNum2].collision;
    }

    
    /**
     * Checks whether the center of an object is colliding with the specified area of the entity.
     *
     * @param objectX The x-coordinate of the object's center in terms of tiles.
     * @param objectY The y-coordinate of the object's center in terms of tiles.
     * @param entityColLeft The left column of the entity's collision area.
     * @param entityColRight The right column of the entity's collision area.
     * @param entityRowTop The top row of the entity's collision area.
     * @param entityRowBottom The bottom row of the entity's collision area.
     * @return True if there is a collision, otherwise false.
     */
    private boolean checkCenterCollision(int objectX,int objectY, int entityColLeft, int entityColRight, int entityRowTop, int entityRowBottom ){
        return objectX >= entityColLeft && objectX <= entityColRight && objectY >= entityRowTop && objectY <= entityRowBottom;
    }
}
