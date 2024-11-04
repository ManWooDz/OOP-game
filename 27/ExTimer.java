/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// package extimer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author studentcs
 */
public class ExTimer extends JFrame{
    URL imgBgURL = getClass().getResource("b.jpg");
    Image imgBg = new ImageIcon(imgBgURL).getImage();
    URL imgActorURL = getClass().getResource("s30.png");
    Image imgActor = new ImageIcon(imgActorURL).getImage();
    ExTimer(){
        DrawArea p =new DrawArea(imgBg,imgActor);
        add(p);
    
    }
    public static void main(String[] args) {
        JFrame f = new ExTimer();
        f.setTitle("Ex timer");
        f.setSize(1500,1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    //inner class
    static class DrawArea extends JPanel{
        Image imgBg;
        Image imgActor;
        int x=10;
        int y=500;
        Timer t = new Timer(1, new Listener());
        //inner class 
        class Listener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        
        }
        public DrawArea(Image imgBg, Image imgActor) {
            this.imgBg = imgBg;
            this.imgActor = imgActor;
            t.start();
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
           /* if(x>1500){
                x=10;
            }else{
                x+=10;
            }*/
           x++;
           y--;
           /*if(y<0){
               y=500;
           } else{
               y--;
           }*/
           
            
            g.drawImage(imgBg, 0, 0, getWidth(),getHeight(),this);
            g.drawImage(imgActor, x, y, 100,100,this);
        }
    
    }
    
    
}
