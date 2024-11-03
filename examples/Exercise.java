import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise extends JFrame {
    public Exercise() {
        add(new RaceCar());
    }

    public static void main(String[] args) {
        Exercise frame = new Exercise();
        frame.setTitle("Exercise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}

class RaceCar extends JPanel {
    private int xBase = 0;
    // private Timer timer = new Timer(10, new Listener());
    private int speed = 10;

    public RaceCar() {
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == 61) {
                    if (speed > 5){
                        speed -= 5;
                    }
                } else if (e.isControlDown() && e.getKeyCode() == 45) {
                    speed += 1;
                }
            }
        });
        // this.setFocusable(true);
        // this.addKeyListener(new KeyAdapter() {
        // public void keyPressed(KeyEvent e) {
        //     if (e.isControlDown() && e.getKeyCode() == 61) {
        //         if (timer.getDelay() > 5)
        //             timer.setDelay(timer.getDelay() - 5);
        //     }
        //     else if (e.isControlDown() && e.getKeyCode() == 45)
        //         timer.setDelay(timer.getDelay() + 1);
        // }
        // });

        Thread gameThread = new Thread(){
            public void run(){
                while (true) {
                    xBase += 1;
                    if (xBase > getWidth()) {
                        xBase = -20;
                        // xBase = 0; 
                    }
                    repaint();
    
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        // Thread.currentThread().interrupt();
                    }
                }
            }
        };

        gameThread.start();
    }

    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();
        
        g.setColor(Color.BLACK);
        g.fillOval(xBase + 10, yBase - 10, 10, 10);
        g.fillOval(xBase + 30, yBase - 10, 10, 10);
        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase - 20, 50, 10);
        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(xBase + 10, yBase - 20);
        polygon.addPoint(xBase + 20, yBase - 30);
        polygon.addPoint(xBase + 30, yBase - 30);
        polygon.addPoint(xBase + 40, yBase - 20);
        g.fillPolygon(polygon);
    }
}
