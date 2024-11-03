import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;

import java.util.*;

public class Hangman extends JFrame implements ActionListener {
    JButton jbtStart = new JButton("Start");
    JButton jbtStop = new JButton("Stop");
    JPanel p = new JPanel();
    DrawArea h = new DrawArea();

    Timer timer = new Timer(50, new TimerListener());
    Hangman(){
        setLayout(new BorderLayout());
        p.add(jbtStart);
        p.add(jbtStop);
        jbtStart.addActionListener(this);
        jbtStop.addActionListener(this);
        add(h,BorderLayout.CENTER);
        add(p,BorderLayout.EAST);

        
        
    }
    private class TimerListener implements ActionListener {
        @Override /** Handle the action event */
        public void actionPerformed(ActionEvent e) {
            // Set new time and repaint the clock to display current time
            // clock.setCurrentTime();
            // clock.repaint();
            h.repaint();

        }
    }

    class DrawArea extends JPanel{
        int offset = 0;
        boolean swingForward;
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(offset > 20){
                swingForward = false;
            }else if(offset <= -20){
                swingForward = true;
            }
            if(swingForward){
                offset = offset+1;

            }else{
                offset = offset -1;
            }


            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(20 + 40, 220, 20 + 40, 20);
            g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);
            g.drawLine(20 + 40 + 100, 20, 20 + 40 + 100+offset, 40);
            int radius = 20;
            g.setColor(Color.RED);
            g.drawOval(20 + 40 + 100 - radius+offset, 40, 2 * radius, 2 * radius);
            g.drawLine(20 + 40 + 100 - (int)(radius * Math.cos(Math.toRadians(45)))+ offset, 40 + radius + (int)(radius * Math.sin(Math.toRadians(45))), 20 + 40 + 100 - 60+(int)(offset*1.5), 40 + radius + 60);
            g.drawLine(20 + 40 + 100 + (int)(radius * Math.cos(Math.toRadians(45)))+ offset, 40 + radius + (int)(radius * Math.sin(Math.toRadians(45))), 20 + 40 + 100 + 60+(int)(offset*1.5), 40 + radius + 60);
            g.drawLine(20 + 40 + 100 + offset, 40 + 2 * radius, 20 + 40 + 100 + (int)(offset*1.5), 40 + radius + 80);
            g.drawLine(20 + 40 + 100 + (int)(offset*1.5), 40 + radius + 80, 20 + 40 + 100 - 40 + offset, 40 + radius + 80 + 40);
            g.drawLine(20 + 40 + 100 + (int)(offset*1.5), 40 + radius + 80, 20 + 40 + 100 + 40 + offset, 40 + radius + 80 + 40);
        }


    }

    public static void main(String[] args) {
        JFrame f = new Hangman();
        f.setTitle("Hangman");
        f.setSize(400, 250);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==jbtStart){
            timer.start();
        }
        if(e.getSource()==jbtStop){
            timer.stop();
        }
    }
}