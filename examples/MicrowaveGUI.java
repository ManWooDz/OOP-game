import javax.print.attribute.standard.JobHoldUntil;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MicrowaveGUI extends JFrame {
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JTextField jtfMonitor = new JTextField("Time",10);
    
    MicrowaveGUI(){
        Listener spyObj = new Listener();

        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(4,3));
        p2.setLayout(new BorderLayout());
        JButton[] jbtButtonArray = new JButton[9];
        JButton jbtZero = new JButton("0");
        JButton jbtStart = new JButton("Start");
        JButton jbtStop = new JButton("Stop");
        JButton jbtPress = new JButton("Press");

        for(int i = 0; i < 9; i++){
            jbtButtonArray[i] = new JButton(""+(i+1));
            jbtButtonArray[i].addActionListener(spyObj);
            p1.add(jbtButtonArray[i]);

        }
        jbtStart.addActionListener(spyObj);
        jbtStop.addActionListener(spyObj);
        jbtZero.addActionListener(spyObj);
        p1.add(jbtStart);
        p1.add(jbtZero);
        p1.add(jbtStop);
        p2.add(jtfMonitor,BorderLayout.NORTH);
        // add(p1);
        p2.add(p1,BorderLayout.CENTER);
        jbtPress.addActionListener(spyObj);
        add(jbtPress,BorderLayout.CENTER);
        add(p2,BorderLayout.EAST);

    }

    //inner class
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            for(int i = 0;i < 9;i++){
                if(e.getActionCommand().equals(""+(i+1))){
                    jtfMonitor.setText(""+(i+1));
                }
            }

            if(e.getActionCommand().equals("0")){
                jtfMonitor.setText("0");
            }
            if(e.getActionCommand().equals("Start")){
                jtfMonitor.setText("Starting");
            }
            if(e.getActionCommand().equals("Stop")){
                jtfMonitor.setText("Stopping");
            }
            if(e.getActionCommand().equals("Press")){
                jtfMonitor.setText("Processing");
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new MicrowaveGUI();
        f.setTitle("MicrowaveGUI");
        f.setSize(400, 250);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}