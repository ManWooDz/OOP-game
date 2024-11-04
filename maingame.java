import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class maingame extends JFrame implements ActionListener{
    lobbygame lobbyscreen = new lobbygame();
    JPanel setting = new JPanel();
    JPanel selectDifficalty = new JPanel();
    
    public maingame(){
        this.setSize(1000, 800);
        this.add(lobbyscreen);
        lobbyscreen.exitJB.addActionListener(this);
        lobbyscreen.startJB.addActionListener(this);
        lobbyscreen.settingJB.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == lobbyscreen.exitJB){
            this.dispose();
        }
    }
    public static void main(String[] args) {
        JFrame mainFrame = new maingame();
        mainFrame.setTitle("Maze Adventure");
        mainFrame.setSize(1000,800);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
