/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extimer;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 *
 * @author studentcs
 */
public class EXMouse extends JFrame {
    EXMouse(){
        DrawArea p = new DrawArea();
        add(p);
        p.setFocusable(true);
    
    }
    
    //inner class 
    static class DrawArea extends JPanel{
        String s= "Moodeng";
        char ch ='K';
        Image imgActor = new ImageIcon(getClass().getResource("s30.png")).getImage();
        int x=10;
        int y=10;
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setFont(new Font("TimeRoman",Font.BOLD,40));
            //g.drawString(s, x, y);
            g.drawString("X position:"+x+" Y position:"+y, 20, 50);
            g.drawImage(imgActor, x, y, 100,100,this);
            //g.drawString(String.valueOf(ch), x, y);
        }
        
        DrawArea(){
            addKeyListener(new KeyListener(){
                @Override
                public void keyTyped(KeyEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    switch(e.getKeyCode()){
                        case KeyEvent.VK_W: y=y-10;break;
                        case KeyEvent.VK_X:y=y+10;break;
                        case KeyEvent.VK_A: x=x-10;break;
                        case KeyEvent.VK_D:x=x+10;break;
                        default: ch = e.getKeyChar();
                    }
                    repaint();
                
                
                
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            });
            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    x=e.getX();
                    y=e.getY();
                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    /*x=e.getX();
                    y=e.getY();
                    repaint();*/
                }
            });
            
        
        }
    }
    public static void main(String[] args) {
        JFrame f = new EXMouse();
        f.setTitle("Ex timer");
        f.setSize(1500,1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
