import java.util.*;
import javax.swing.*;
import java.awt.*;

public class difficultyselect extends JPanel{
    private ImageIcon background = new ImageIcon(this.getClass().getResource("background_temp.jpg"));
    public JButton peacefulJB = new JButton("Peaceful");
    public JButton EasyJB = new JButton("Easy");
    public JButton HardJB = new JButton("Hard");
    public JButton backJB = new JButton("<");

    difficultyselect(){
        setLayout(null);
        
        peacefulJB.setBounds((int)121.5,432,100,53);
        EasyJB.setBounds(343,432,100,53);
        HardJB.setBounds((int)564.5, 432, 100,53);
        backJB.setBounds((int)50,50,40,40);
        add(peacefulJB);
        add(EasyJB);
        // add(start);
        add(backJB);
        add(HardJB);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background.getImage(),0,0,768,576,this);
        g.setColor(Color.GREEN);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));

        String text = "Select Difficulty";
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        g.drawString(text, x, 200);
        // g.drawString("Select Difficulty",120,200);
    }
}
