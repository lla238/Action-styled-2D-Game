import game.GPanel;
import game.GamePanel;
import game.StartPanel;
import org.junit.Before;
import org.junit.Test;

import cell.Cell;
import cell.CellManage;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

public class CellManageTest {

    private GamePanel gamePanel;
    private StartPanel startPanel;

    @Before
    public void setUp() {
        // Initialize GamePanel and StartPanel for testing
        gamePanel = new GamePanel();
        startPanel = new StartPanel();
    }

    @Test
    public void testConstructionForGamePanel() {
        CellManage cellManage = new CellManage(gamePanel);

        assertNotNull(cellManage);
        assertNotNull(cellManage.cell);
        assertNotNull(cellManage.mapCellNum);
        assertEquals(2, cellManage.cell.length);
        assertEquals(gamePanel.maxScreenCol, cellManage.mapCellNum.length);
        assertEquals(gamePanel.maxScreenRow, cellManage.mapCellNum[0].length);
    }

    @Test
    public void testConstructionForStartPanel() {
        CellManage cellManage = new CellManage(startPanel);

        assertNotNull(cellManage);
        assertNotNull(cellManage.cell);
        assertNotNull(cellManage.mapCellNum);
        assertEquals(2, cellManage.cell.length);
        assertEquals(startPanel.maxScreenCol, cellManage.mapCellNum.length);
        assertEquals(startPanel.maxScreenRow, cellManage.mapCellNum[0].length);
    }

    @Test
    public void testGetCellImg() {
        CellManage cellManage = new CellManage(gamePanel);

        // Ensure cell images are loaded
        cellManage.getCellImg();
        assertNotNull(cellManage.cell[0].image);
        assertNotNull(cellManage.cell[1].image);
    }

    @Test
    public void testLoadMap() {
        CellManage cellManage = new CellManage(gamePanel);

        // Ensure map is loaded
        cellManage.loadMap("/map01.txt");
        assertNotNull(cellManage.mapCellNum);
        assertEquals(gamePanel.maxScreenCol, cellManage.mapCellNum.length);
        assertEquals(gamePanel.maxScreenRow, cellManage.mapCellNum[0].length);
    }

    @Test
    public void testDraw() {
        CellManage cellManage = new CellManage(gamePanel);
        BufferedImage dummyImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        cellManage.cell[0] = new Cell();
        cellManage.cell[0].image = dummyImage;

        // Ensure draw method does not throw exceptions
        cellManage.draw(dummyImage.createGraphics());
    }
}
