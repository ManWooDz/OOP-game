import java.util.*;
import javax.swing.*;
import java.awt.*;

public class lobbygame extends JPanel{
    private ImageIcon background = new ImageIcon(this.getClass().getResource("background_temp.jpg"));
    // private ImageIcon settingbackground = new ImageIcon(this.getClass().getResource("settingbanner.jpg"));
    // private ImageIcon exitbackground = new ImageIcon(this.getClass().getResource("exitbanner.jpg"));
    // private ImageIcon startbackground = new ImageIcon(this.getClass().getResource("startbanner.jpg"));
    public JButton startJB = new JButton("Start");
    public JButton settingJB = new JButton("Setting");
    public JButton exitJB = new JButton("Exit");

    lobbygame(){
        setLayout(null);
        exitJB.setBounds((int)707.5, 650, 170,90);
        startJB.setBounds((int)112.5,650,170,90);
        settingJB.setBounds(415,650,170,90);
        add(exitJB);
        add(settingJB);
        // add(start);
        
        add(startJB);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background.getImage(),0,0,1000,800,this);
        g.setColor(Color.GREEN);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));
        g.drawString("Maze Adventure",70,200);
    }
}
