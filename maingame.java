import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class maingame extends JFrame implements ActionListener{
    lobbygame lobbyscreen = new lobbygame();
    // difficultyselect difficulscreen = new difficultyselect();
    playpeaceful peacefulMode = new playpeaceful();

    // JPanel settingscreen = new JPanel();
    // JPanel selectDifficalty = new JPanel();
    
    public maingame(){
        // this.setSize(1000, 800);
        this.setSize(768, 576);
        this.add(lobbyscreen);
        lobbyscreen.exitJB.addActionListener(this);
        lobbyscreen.startJB.addActionListener(this);
        // lobbyscreen.settingJB.addActionListener(this);
        // difficulscreen.backJB.addActionListener(this);
        // difficulscreen.peacefulJB.addActionListener(this);
        // System.out.println("Game run");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == lobbyscreen.exitJB){
            this.dispose();
        }else if(e.getSource() == lobbyscreen.settingJB){
            // this.setLocationRelativeTo(null);
            // this.remove(lobbyscreen);
            // // this.setSize(1000, 800);
            // this.setSize(768, 576);
            // this.add(settingscreen);
        }else if(e.getSource() == lobbyscreen.startJB){
            // this.setLocationRelativeTo(null);
            // this.remove(lobbyscreen);
            // // this.setSize(1000, 800);
            // this.setSize(768, 576);
            
            // this.add(difficulscreen);
            
            // this.remove(difficulscreen);
            // this.setSize(1000, 800);
            
            this.setLocationRelativeTo(null);
            this.setSize(768, 576);
            this.add(peacefulMode);
            peacefulMode.startgameThread();
            peacefulMode.setupGame();
            peacefulMode.requestFocusInWindow();
        }
        // else if(e.getSource() == difficulscreen.backJB){
            // this.setLocationRelativeTo(null);
            // this.remove(difficulscreen);
            // // this.setSize(1000, 800);
            // this.setSize(768, 576);
            // this.add(lobbyscreen);
        // }else if(e.getSource() == difficulscreen.peacefulJB){
            // this.setLocationRelativeTo(null);
            // this.remove(difficulscreen);
            // // this.setSize(1000, 800);
            // this.setSize(768, 576);
            // this.add(peacefulMode);
            // peacefulMode.startgameThread();
            // peacefulMode.setupGame();
            // peacefulMode.requestFocusInWindow();
            // System.out.println("type");
        // }
        this.validate();
        this.repaint();
    }
    public static void main(String[] args) {
        JFrame mainFrame = new maingame();
        mainFrame.setTitle("Maze Adventure");
        // mainFrame.setSize(1000,800);
        mainFrame.setSize(768,576);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        // System.out.println("Game run");
    }
}
