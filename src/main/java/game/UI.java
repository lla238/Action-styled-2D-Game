package game;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * The code UI class handles the user interface elements and messages in the game.
 * It provides methods for displaying messages, drawing scores, and updating the game status.
 */
public class UI {
    
	GamePanel gp;
	
	// MESSAGE SETTINGS
    Font calibri_30, calibri_80;
    public boolean msgOn = false;
    public String message = "";
    public int messageCounter = 0;
    
    public double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    
    public boolean gameFinish = false;

    /**
     * Constructs a new UI with the specified GamePanel.
     *
     * @param gp The GamePanel associated with this UI.
     */
    public UI(GamePanel gp){
        
    	this.gp = gp;
        calibri_30 = new Font("Calibri", Font.BOLD, 30);
        calibri_80 = new Font("Calibri", Font.BOLD, 80);
    }

    /**
     * Displays a message on the screen.
     *
     * @param text The message to be displayed.
     */
    public void showMsg(String text) {
        message = text;
        msgOn = true;
    }
    
    /**
     * Draws the user interface elements on the screen.
     *
     * @param g2 The Graphics2D object to draw on.
     */
    public void draw(Graphics2D g2){
        
        if(gameFinish == true) {

            String text;
            int textLeng, x, y;

            g2.setFont(calibri_80);
            g2.setColor(Color.white);
            text = "YOU WIN!!!";
            textLeng = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLeng/2;
            y = gp.screenHeight/2;
            g2.drawString(text,x,y);

            g2.setFont(calibri_30);
            g2.setColor(Color.white);
            text = "Time : " + dFormat.format(playTime) + "   Points: ";
            textLeng = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLeng/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text,x,y);

            gp.gameThread = null;
        }
        
        else{
            g2.setFont(calibri_30);
            g2.setColor(Color.white);
            String score = gp.player.getScore(10);
            g2.drawString("Points = "+score, gp.tileSize*1,65);
    
            // Time
            playTime +=(double)1/60;
            g2.drawString("Time: "+ dFormat.format(playTime), gp.tileSize*12, 65);

            if (msgOn == true){
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
                
                messageCounter++;

                if(messageCounter >60){
                    messageCounter = 0;
                    msgOn = false;
                }
            }
        }
    }
}
