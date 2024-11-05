import java.util.*;
import javax.swing.*;

import javaapplication5.Fireball;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;

public class playpeaceful extends JPanel implements ActionListener, Runnable {
    private final ImageIcon route_block = new ImageIcon(this.getClass().getResource("temp_openwall.png"));
    private final ImageIcon exit_block = new ImageIcon(this.getClass().getResource("temp_exit.png"));
    private final ImageIcon wall_block = new ImageIcon(this.getClass().getResource("temp_grass.png"));
    private final ImageIcon puzzle_block = new ImageIcon(this.getClass().getResource("temp_puzzle.png"));
    private final ImageIcon trap_block = new ImageIcon(this.getClass().getResource("temp_trap.png"));
    private final ImageIcon player_img = new ImageIcon(this.getClass().getResource("playerfi1.png"));
    JButton restartJB = new JButton("Restart");
    JButton mainmenuJB = new JButton("Main Menu");
    JButton quitJB = new JButton("Quit");
    JButton pauseJB = new JButton("||");
    
    keyHandler keyH = new keyHandler();
    Thread gameThread;
    player_peaceful player = new player_peaceful(this,keyH);

    lobbygame lobbyscreen = new lobbygame();

    peacefulMaze mazelayout = new peacefulMaze();

    tilesManager_peaceful tileM = new tilesManager_peaceful(this);

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenHeight = tileSize*maxScreenCol;
    final int screenWidth = tileSize*maxScreenRow;


    //FPS
    int fps = 60;

    

    //player def pos
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    playpeaceful(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        // this.setLayout(null);
        // pauseJB.setBounds(750, 50, 40, 40);

        
        this.addKeyListener(keyH);
        this.add(pauseJB);

        

        // player.x = 250;
        // player.y = 250;
        // actor.start();
    }

    public void startgameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
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
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        player.draw(g2);

        g2.dispose();
       
        
    }


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
