import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    private ImageIcon background = new ImageIcon(this.getClass().getResource("background_temp.jpg"));

    int subState = 0;
    public int commandNum = 0;
    public String currentDialog = "";

    Font pixellet;

    BufferedImage heart_full,heart_blank;

    int score;



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

        //CREATE HUD OBJECT
        SuperObect heart = new OBJ_hearts(gp);
        heart_full = heart.image2;
        heart_blank = heart.image;
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void resetTimer(){
        playTime = 0;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        
        // g2.setFont(pixellet);
        g2.setFont(new Font("Arial", Font.PLAIN,40));
        g2.setColor(Color.white);

        //Play
        if(gp.gameState == gp.playState){
            //play stuff
            drawPlayerLife();
            drawTimer();
        }
        //Pause || Option
        if(gp.gameState == gp.pauseState){
            drawPlayerLife();
            drawTimer();
            drawPauseScreen();
        }
        //Dialog
        if(gp.gameState == gp.dialogState){
            drawPlayerLife();
            drawTimer();
            drawDialogScreen();
        }
        //GAME OVER
        if(gp.gameState == gp.gameOverState){
            drawGameOverScreen();
        }
        //FINISH
        if(gp.gameState == gp.finishedState){
            drawFinishScreen();
        }
    }

    public void drawPlayerLife(){

        //test playerlife
        // gp.player.life = 1;

        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //Draw Blank Life
        while(i < gp.player.maxLife){
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        //Draw Current Life
        while(i < gp.player.life){
            g2.drawImage(heart_full, x, y, null);
            i++;
            x += gp.tileSize;
        }
    }

    public void drawTimer(){

        if(gp.gameState == gp.playState){
            playTime += (double)1/60;
            
            int minutes = (int) (playTime / 60); 
            int seconds = (int) (playTime % 60);
            String timeText = String.format("%02d:%02d", minutes, seconds);

            g2.drawString("Time: " + timeText, gp.tileSize*11, 65);
        }else if(gp.gameState == gp.pauseState || gp.gameState == gp.dialogState){
            int minutes = (int) (playTime / 60); 
            int seconds = (int) (playTime % 60);
            String timeText = String.format("%02d:%02d", minutes, seconds);

            g2.drawString("Time: " + timeText, gp.tileSize*11, 65);
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

    public void drawDialogScreen(){
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*2);
        int height = gp.tileSize*4;

        drawSubWindows(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32f));
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentDialog, x, y);
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

    public void drawGameOverScreen(){
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, gp.screenHeight, gp.screenWidth);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));

        text = "Game Over";
        //Shadow
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gp.tileSize*4;
        g2.drawString(text, x, y);

        //Main
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Retry";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-40, y);
        }

        //Quit
        text = "Quit";
        x = getXforCenteredText(text);
        y += 55;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-40, y);
        }
    }

    public void drawFinishScreen(){
        //calculate score
        score = gp.player.life * 20;

        if (playTime < 3 * 60) { 
            score += 40;           // Add 40 if playTime is under 3 minutes
        } else if (playTime < 5 * 60) {  
            score += 20;           // Add 20 if playTime is under 5 minutes but over 3 minutes
        } else {
            score += 0;            // Add 0 if playTime is over 5 minutes
        }

        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, gp.screenHeight, gp.screenWidth);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,70f));

        text = "Congratulations!";
        //Shadow
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gp.tileSize*3;
        g2.drawString(text, x, y);

        //Main
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //score
        g2.setFont(g2.getFont().deriveFont(30f));
        text = "Score: " + score;
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

        //Retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Retry";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-40, y);
        }

        //Quit
        text = "Quit";
        x = getXforCenteredText(text);
        y += 55;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-40, y);
        }
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
