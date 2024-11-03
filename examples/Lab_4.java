import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;

public class Lab_4 extends JFrame {
    
    JPanel textlabelPanel = new JPanel();
    JPanel tfPanel = new JPanel();
    JPanel abovePanel = new JPanel();
    JPanel underPanel = new JPanel();
    // JPanel fPiority = new JPanel();
    JTextField jtfUS = new JTextField(20);
    JTextField jtfCA = new JTextField(20);
    JLabel jlUS = new JLabel("US Dollars");
    JLabel jlCA = new JLabel("Canadian Dollars");
    
    Lab_4(){
        Listener spyObj = new Listener();
        setLayout(new BorderLayout());
        textlabelPanel.setLayout(new BorderLayout());
        tfPanel.setLayout(new BorderLayout());
        abovePanel.setLayout(new BorderLayout());
        underPanel.setLayout(new BorderLayout());
        // fPiority.setLayout(new BorderLayout());

        jtfCA.setEditable(false);

        JButton jbConvert = new JButton("Convert");

        // jtfMonitor.setHorizontalAlignment(JTextField.RIGHT);
        // jtfMonitor.setEditable(false);


        textlabelPanel.add(jlUS, BorderLayout.NORTH);
        textlabelPanel.add(jlCA, BorderLayout.SOUTH);
        abovePanel.add(textlabelPanel, BorderLayout.WEST);

        tfPanel.add(jtfUS, BorderLayout.NORTH);
        tfPanel.add(jtfCA, BorderLayout.SOUTH);
        abovePanel.add(tfPanel, BorderLayout.CENTER);

        jbConvert.addActionListener(spyObj);
        underPanel.add(jbConvert, BorderLayout.EAST);
        

        add(underPanel, BorderLayout.SOUTH);
        add(abovePanel, BorderLayout.NORTH);
        
    }

    //inner class
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String USnum = jtfUS.getText();
            double USd;
            if(e.getActionCommand().equals("Convert")){
                USd = Double.parseDouble(USnum);
                jtfCA.setText(""+(1.35605*USd));
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new Lab_4();
        f.setTitle("Convert US Dollars to Canadian Dollars");
        f.setSize(400, 120);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}