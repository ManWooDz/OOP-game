import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UI_peaceful {
    playpeaceful gp;
    Graphics2D g2;

    public boolean messageOn = false;
    public String message = "";
    int messageCount = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0:00");

    private ImageIcon background = new ImageIcon(this.getClass().getResource("background_temp.jpg"));

    int subState = 0;
    public int commandNum = 0;
    public String currentDialog = "";

    Font pixellet;

    // JButton resumeJB = new JButton("RESUME");
    // JButton mainmenuJB = new JButton("MAIN MENU");


    public UI_peaceful(playpeaceful gp){
        this.gp = gp;


        //import font
        // InputStream is = getClass().getResourceAsStream("/font/Minecraft.ttf");
        // try{
        //     pixellet = Font.createFont(Font.TRUETYPE_FONT, is);
        //     // pixellet.deriveFont(12f);
        // }catch(FontFormatException e){
        //     e.printStackTrace();
        // } catch(IOException e){
        //     e.printStackTrace();
        // }
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        
        // g2.setFont(pixellet);
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
        /*
         * String text = "PAUSED";

            int x = getXforCenteredText(text);
            // FontMetrics metrics = g2.getFontMetrics(g2.getFont());
            // int x = (gp.screenWidth - metrics.stringWidth(text)) / 2;
            // int x = 384 - (gp.tileSize/2);
            // int y = gp.screenHeight/2;
            int y = 288 - (gp.tileSize/2);

            g2.drawImage(background.getImage(),0,0,768,576,null);
            g2.drawString(text,x,100);
            // resumeJB.setBounds(566, 432, 20, 10);
            // mainmenuJB.setBounds(182, 432, 20 ,10);
         */
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(32f));

            //sub window
            int frameX = gp.tileSize*4;
            int frameY = gp.tileSize / 2;
            int frameWidth = gp.tileSize*8;
            int frameHeight = gp.tileSize*10;

            drawSubWindows(frameX,frameY,frameWidth,frameHeight);

            switch(subState){
                case 0:
                    options_top(frameX, frameY);
                    break;
                case 1:
                    // options_htp(frameX, frameY);
                    options_exit(frameX, frameY);
                    break;
                case 2:
                    break;
            }
        
        
    }

    public void drawSubWindows(int x, int y, int width, int height){
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);

        
    }

    public void options_top(int frameX, int frameY){
        int textX;
        int textY;

        //Title
        String text = "Options";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        //How to play
        // textX = frameX + gp.tileSize;
        // textY += gp.tileSize*2;
        // g2.drawString("How to play", textX, textY);
        // if(commandNum == 0){
        //     g2.drawString(">", textX-25, textY);
        //     if(gp.keyH.enterPressed == true){
        //         subState = 1;
        //         commandNum = 0;
        //     }
        // }

        //Exit the game
        // textY += gp.tileSize;
        textY += gp.tileSize*2;
        g2.drawString("Quit", textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX-25, textY);
            if(gp.keyH.enterPressed == true){
                subState = 1;
                commandNum = 0;
                gp.keyH.enterPressed = false;
            }
        }

        //back
        textY += gp.tileSize*5;
        g2.drawString("Back", textX, textY);
        if(commandNum == 1){
            g2.drawString(">", textX-25, textY);
            if(gp.keyH.enterPressed == true){
                gp.gameState = gp.playState;
                commandNum = 0;
            }
        }
    }  

    // public void options_htp(int frameX, int frameY){
    //     int textX, textY;

    //     //Title
    //     String text = "How to play";
    //     textX = getXforCenteredText(text);
    //     textY = frameY + gp.tileSize;
    //     g2.drawString(text, textX, textY);

    //     g2.setFont(g2.getFont().deriveFont(15f)); //set font size to 12
    //     textX = frameX + gp.tileSize;
    //     textY += gp.tileSize;
    //     currentDialog = "Welcome to Maze Adventure! You're\ntrapped in a maze, your mission:\nfind the exit, dodge thorns, and avoid\nlosing hearts.\nYou only have 3 chances! Good luck!";
    //     for(String line : currentDialog.split("\n")){
    //         g2.drawString(line, textX, textY);
    //         textY += 40;
    //     }
    //     g2.setFont(g2.getFont().deriveFont(32f)); //reset font size to 32

    //     //back
    //     textY += gp.tileSize*3;
    //     g2.drawString("Back", textX, textY);
    //     if(commandNum == 0){
    //         g2.drawString(">", textX-25, textY);
    //         if(gp.keyH.enterPressed == true){
    //             subState = 0;
    //             commandNum = 0;
    //         }
    //     }
        
    // }

    public void options_exit(int frameX, int frameY){
        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize*3;
        currentDialog = "Do you really wish\nto quit the game?";
        for(String line : currentDialog.split("\n")){
            g2.drawString(line, textX, textY);
            textY += 40;
        }

        //yes
        String text = "Yes";
        textX = getXforCenteredText(text);
        textY += gp.tileSize*3;
        g2.drawString(text, textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX-25, textY);
            if(gp.keyH.enterPressed == true){
                subState = 0;
                gp.exitTheGame();
                // System.out.println(gp.keyH.enterPressed ? 1 : 0);
            }
        }

        //No
        text = "No";
        textX = getXforCenteredText(text);
        textY += gp.tileSize;
        g2.drawString(text, textX, textY);
        if(commandNum == 1){
            g2.drawString(">", textX-25, textY);
            if(gp.keyH.enterPressed == true){
                subState = 0;
                commandNum = 0;
                gp.keyH.enterPressed = false;
            }
        }
    }

    public int getXforCenteredText(String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = 384 - lenght/2;

        return x;
    }
}
