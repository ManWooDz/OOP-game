import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;

public class playpeaceful extends JPanel implements ActionListener, Runnable {
    JButton restartJB = new JButton("Restart");
    JButton mainmenuJB = new JButton("Main Menu");
    JButton quitJB = new JButton("Quit");
    JButton pauseJB = new JButton("||");
    

    //
    keyHandler keyH = new keyHandler(this);
    Thread gameThread;
    public player_peaceful player = new player_peaceful(this,keyH);

    lobbygame lobbyscreen = new lobbygame();

    // peacefulMaze mazelayout = new peacefulMaze();

    //SYSYEM
    tilesManager_peaceful tileM = new tilesManager_peaceful(this);
    public collisionChecker cChecker = new collisionChecker(this);
    public UI_peaceful UI = new UI_peaceful(this);
    public EventHandler eHandler = new EventHandler(this);

    final int originalTileSize = 16; //16x16 pixel
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48
    // 4:3 res
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenHeight = tileSize*maxScreenCol; //768
    final int screenWidth = tileSize*maxScreenRow;  //576

    // final int screenHeight = 1000;
    // final int screenWidth = 800;

    //world setting
    public final int maxWorldCol = 53;
    public final int maxWorldRow = 53;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int fps = 60;

    //Game State
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogState = 3;
    public final int gameOverState = 4;
    public final int finishedState = 5;


    //player def pos
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public playpeaceful(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        // this.setLayout(null);
        // pauseJB.setBounds(700, 50, 40, 40);

        
        this.addKeyListener(keyH);
        // this.add(pauseJB);

        

        // player.x = 250;
        // player.y = 250;
        // actor.start();
    }

    public void setupGame(){
        gameState = playState;
    }

    public void startgameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps; //0.0166 sec
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while (gameThread != null){
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                // System.out.println(gameState);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        if(gameState == playState){
            player.update();
            // System.out.println("gameState == playState");
        }
        if(gameState == pauseState){

        }
        // if(gameState == dialogState){
        //     drawDialogScreen();
        // }
    }

    public void restart(){
        player.setDefaultValues();
        UI.resetTimer();
        
    }

    public void exitTheGame(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(playpeaceful.this);
        if (frame != null) {
            frame.dispose();
            System.exit(0);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        // System.out.println("draw tileM");
        player.draw(g2);
        // System.out.println("draw player");
        UI.draw(g2);

        g2.dispose();
       
        
    }



    //not using
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartJB) {
            //restart

            this.setSize(1000, 800);
            // this.add(difficulscreen);
            this.setLocation(null);
            // timestart = true;
            // startball = true;
        } else if(e.getSource() == mainmenuJB){
            this.setSize(1000, 800);
            this.add(lobbyscreen);
            this.setLocation(null);
            // timestart = true;
            // startball = true;
        }else if (e.getSource() == quitJB) {
            //quit
            System.exit(0);
        }
    }

    
}
