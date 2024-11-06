import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI_peaceful {
    playpeaceful gp;
    Graphics2D g2;

    public boolean messageOn = false;
    public String message = "";
    int messageCount = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0:00");

    public UI_peaceful(playpeaceful gp){
        this.gp = gp;

    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(new Font("Arial", Font.PLAIN,40));
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState){
            //play stuff
        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
    }
    public void drawPauseScreen(){
        String text = "PAUSED";

        // int x = getXforCenteredText(text);
        int x = 384 - (gp.tileSize/2);
        // int y = gp.screenHeight/2;
        int y = 288 - (gp.tileSize/2);

        g2.drawString(text,x,y);
    }
    public int getXforCenteredText(String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;

        return x;
    }
}
