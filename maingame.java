import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class maingame extends JFrame{
    JPanel lobby = new JPanel();
    JPanel setting = new JPanel();
    JPanel selectDifficalty = new JPanel();
    
    public static void main(String[] args) {
        JFrame mainFrame = new maingame();
        mainFrame.setTitle("Maze Adventure");
        mainFrame.setSize(800,800);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
