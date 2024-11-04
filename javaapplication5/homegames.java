package javaapplication5;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class homegames extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("eezy_61-01.jpg"));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
	private ImageIcon starts = new ImageIcon(this.getClass().getResource("start.png"));
	public JButton BStart = new JButton(starts);
	public JButton BExit1  = new JButton(exit);
	homegames(){
            setLayout(null);
            BExit1.setBounds(500, 650, 170,90);
            add(BExit1);
            add(BStart);
            BStart.setBounds(750,650,170,90);
            add(BStart);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);
            g.setColor(Color.GREEN);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));		
            g.drawString("Animation Example",70,200);	
	}
}