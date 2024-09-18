package game;

import javax.swing.*;
/**
 * The GPanel class represents a JPanel for the game graphics.
 * It defines constants such as tile size, screen dimensions, and frames per second (FPS) for the game loop.
 */
public class GPanel extends JPanel {
    final static int originalTileSize = 16;
    final static int scale = 3;
    public final static int tileSize = originalTileSize * scale;
    public final static int maxScreenCol = 16;
    public final static int maxScreenRow = 12;
    public final static int screenWidth = tileSize * maxScreenCol;
    public final static int screenHeight = tileSize * maxScreenRow;

    static int FPS = 45; //frames per second setting for the game loop.
}
