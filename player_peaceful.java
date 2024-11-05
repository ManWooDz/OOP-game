import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class player_peaceful extends entity_peaceful{
    // public ImageIcon[] im = new ImageIcon[2];
    // public ImageIcon ActorF = new ImageIcon(getClass().getResource("playerfi1.png"));
    // public ImageIcon ActorB = new ImageIcon(getClass().getResource("playerfi2.png"));
    // public int x;
    // public int y;
    // public int speed;
    // public int count = 0;

    playpeaceful gp;
    keyHandler keyH;

    public final int screenX;
    public final int screenY;
    public final int screenXtemp;
    public final int screenYtemp;

    player_peaceful(playpeaceful gp, keyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        screenXtemp = 384;
        screenYtemp = 288;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        // worldX = 624;
        // worldY = 240;
        worldX = gp.tileSize * 18;
        worldY = gp.tileSize * 10;
        // worldX = gp.tileSize * 23;
        // worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/playerimg/boy_right_2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        // System.out.println("X: " + worldX + ", Y: " + worldY);
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction = "up";
                worldY -= speed;
            }else if(keyH.downPressed == true){
                direction = "down";
                worldY += speed;
            }else if(keyH.leftPressed == true){
                direction = "left";
                worldX -= speed;
            }else if(keyH.rightPressed == true){
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, screenXtemp, screenYtemp, gp.tileSize,gp.tileSize,null);
        // g2.drawImage(image, 100, 100, 50, 50, null);
    }

    // public int getX() {
    //     return x;  // Current X position of the player in grid coordinates
    // }
    
    // public int getY() {
    //     return y;  // Current Y position of the player in grid coordinates
    // }
    
    // public ImageIcon getIconF() {
    //     return new ImageIcon(this.getClass().getResource("playerfi1.png"));  // Replace with actual player icon
    // }

    // public ImageIcon getIconB() {
    //     return new ImageIcon(this.getClass().getResource("playerfi2.png"));  // Replace with actual player icon
    // }

    // public void setXY(int x, int y){
    //     this.x = x;
    //     this.y = y;
    // }
}
