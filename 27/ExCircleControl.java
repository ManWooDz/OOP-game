/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package extimer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author studentcs
 */
public class ExCircleControl extends JFrame implements ActionListener{
    JButton jbtEnlarge = new JButton("Enlarge");
    JButton jbtShrink = new JButton("Shrink");
    JPanel p = new JPanel();
    DrawCircle circleObj = new DrawCircle();
    ExCircleControl(){
        setLayout(new BorderLayout());
        p.add(jbtEnlarge);
        p.add(jbtShrink);
        jbtEnlarge.addActionListener(this);
        jbtShrink.addActionListener(this);
        add(circleObj,BorderLayout.CENTER);
        add(p,BorderLayout.SOUTH);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbtEnlarge){
            circleObj.inc();
        }
        if(e.getSource()==jbtShrink){
            circleObj.dec();
        }
    
    }
     
    //inner class
    static class DrawCircle extends JPanel{
        int radius=5;
        void inc(){
            radius+=10;
            repaint();
        }
        void dec(){
            radius-=10;
            repaint();
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.red);
            g.drawOval((getWidth()/2)-radius,(getHeight()/2)-radius, 2*radius,2*radius);
        }
    
    }
    
    public static void main(String[] args) {
        JFrame f = new ExCircleControl();
        f.setTitle("Ex timer");
        f.setSize(1500,1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
}
