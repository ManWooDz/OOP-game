import java.awt.*; 
import javax.swing.*;
public class NewClass5 extends JFrame{
   public static void main(String args[]){
      NewClass5 a = new NewClass5();
      a.setSize(600,500);
      a.setVisible(true);
   }


    Button okButton; 
    TextField nameField; 
    CheckboxGroup radioGroup; 
    Checkbox radio1; 
    Checkbox radio2; 
    Checkbox radio3; 
    Checkbox radio4; 
    Checkbox option; 
    public NewClass5(){ 
        setLayout(null); 
        okButton = new Button("A button"); 
        nameField = new TextField("A TextField",100); 
        radioGroup = new CheckboxGroup(); 
        radio1 = new Checkbox("Radio1",radioGroup,false); 
        radio2 = new Checkbox("Radio2",radioGroup,false); 
        radio3 = new Checkbox("Radio3",radioGroup,false); 
        radio4 = new Checkbox("Radio4",radioGroup,true); 
        option = new Checkbox("Option",false);
        okButton.setBounds(20,20,100,30); 
        nameField.setBounds(20,70,100,40); 
        radio1.setBounds(20,120,100,30); 
        radio2.setBounds(120,120,100,30); 
        radio3.setBounds(220,120,100,30); 
        radio4.setBounds(320,120,100,30); 
        option.setBounds(20,170,100,30);
        add(okButton); 
        add(nameField); 
        add(radio1); 
        add(radio2); 
        add(radio3); 
        add(radio4); 
        add(option); 
   }
}
