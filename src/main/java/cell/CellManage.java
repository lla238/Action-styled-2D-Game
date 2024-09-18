package cell;

import game.GPanel;
import game.GamePanel;
import game.StartPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The CellManage class handles the management of cells in the game,
 * including loading cell images and maps, as well as drawing the cells on the screen.
 */
public class CellManage {
  
    GPanel gp;
    public Cell[] cell;
    public int[][] mapCellNum;

    /**
     * Constructs a new CellManage object for a GamePanel.
     *
     * @param gp The game panel for which the cell manager is created.
     */
    public CellManage(GamePanel gp){
        this.gp =gp;

        cell = new Cell[2];
        mapCellNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getCellImg();
        loadMap("/map01.txt");
    }

    /**
     * Constructs a new CellManage object for a StartPanel.
     *
     * @param gp The start panel for which the cell manager is created.
     */
    public CellManage(StartPanel gp){
        this.gp =gp;

        cell = new Cell[2];
        mapCellNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getCellImg();
        loadMap("/map_start.txt");
    }


    /**
     * Loads the images for different types of cells.
     */
    public void getCellImg(){
         
    	try{
            
            cell[0] = new Cell();
            cell[0].image = ImageIO.read(getClass().getResourceAsStream("/grass.png"));
            cell[1] = new Cell();
            cell[1].image = ImageIO.read(getClass().getResourceAsStream("/fence.png"));
            cell[1].collision = true;

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Loads the map from a text file and populates the mapCellNum array.
     *
     * @param mapName The name of the map file to load.
     */
    public void loadMap(String mapName){
        try{
            InputStream is = getClass().getResourceAsStream(mapName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();

                while (col < gp.maxScreenCol) {
                    // .split(" ")  split the string into an array of strings
                    String[] numbers;
                    numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    // 0 is grass, 1 is fence
                    mapCellNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e){

        }
    }
    
    
    /**
     * Draws the cells on the screen.
     *
     * @param g2 The graphics context used for drawing.
     */
    public void draw(Graphics2D g2){
        g2.drawImage(cell[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        
        int col = 0;
        int row = 0;
        int x = 0;
        int y =0;

        while(row < gp.maxScreenRow && col < gp.maxScreenCol){

            int cellNum = mapCellNum[col][row];

            g2.drawImage(cell[cellNum].image,x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x +=gp.tileSize;
            if(col == gp.maxScreenCol){
                col = 0;
                row++;
                x = 0;
                y += gp.tileSize;
            }
        }

//        while (col < gp.maxScreenC && row < gp.maxScreenR){
//            g2.drawImage(cell[0].image, x, y, gp.tileSize, gp.tileSize, null);
//        }
    }
}
