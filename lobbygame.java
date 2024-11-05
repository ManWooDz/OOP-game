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
        exitJB.setBounds((int)564.5, 432, 100,53);
        startJB.setBounds((int)121.5,432,100,53);
        settingJB.setBounds(343,432,170,53);
        add(exitJB);
        add(settingJB);
        // add(start);
        
        add(startJB);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background.getImage(),0,0,768,576,this);
        g.setColor(Color.GREEN);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));

        String text = "Maze Adventure";
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        g.drawString(text, x, 200);
        // g.drawString("Maze Adventure",120,200);
    }
}
