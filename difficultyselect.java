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
        
        peacefulJB.setBounds((int)112.5,645,170,90);
        EasyJB.setBounds(415,645,170,90);
        HardJB.setBounds((int)707.5, 645, 170,90);
        backJB.setBounds((int)50,50,50,50);
        add(peacefulJB);
        add(EasyJB);
        // add(start);
        add(backJB);
        add(HardJB);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background.getImage(),0,0,1000,800,this);
        g.setColor(Color.GREEN);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));

        String text = "Select Difficulty";
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        g.drawString(text, x, 200);
        // g.drawString("Select Difficulty",120,200);
    }
}
