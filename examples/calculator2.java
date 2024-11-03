import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

public class calculator2 extends JFrame {
    boolean recentlyPressed = false;
    JPanel stack1 = new JPanel();
    JPanel stack2 = new JPanel();

    JPanel buttonpad = new JPanel();

    JTextField jtfScreen = new JTextField(10);
    final int BUTTON_SIZE = 80; // Define button size
    String operator = "";
    double firstOperand = 0;
    boolean startNewNumber = true;

    calculator2() {
        Listener spyObj = new Listener();
        setLayout(new BorderLayout());
        jtfScreen.setEditable(false);
        jtfScreen.setHorizontalAlignment(JTextField.RIGHT);
        
        stack2.setLayout(new GridLayout(5,4,10,10));
        String[] button = {
            "√", "x²", "±", "C",
            "7", "8", "9", "-",
            "4", "5", "6", "+",
            "1", "2", "3", "*",
            ".", "0", "=", "/",
        };
        


        for(String t : button){
            JButton temp = new JButton(t);
            temp.addActionListener(spyObj);
            stack2.add(temp);
        }

        add(jtfScreen, BorderLayout.NORTH);
        add(stack2, BorderLayout.CENTER);

        // Add action listeners for buttons
    }

    // class Listener implements ActionListener{
    //     @Override
    //     public void actionPerformed(ActionEvent e){
    //         String USnum = jtfUS.getText();
    //         double USd;
    //         if(e.getActionCommand().equals("Convert")){
    //             USd = Double.parseDouble(USnum);
    //             jtfCA.setText(""+(1.35605*USd));
    //         }
    //     }
    // }
    
    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (recentlyPressed == true) {
                jtfScreen.setText("");
                recentlyPressed = false;
            }

            String inp = e.getActionCommand();
            String current = jtfScreen.getText();

            if (inp.equals("c")) {
                jtfScreen.setText("");
            }
            for (int i = 0; i <= 9; i++) {
                if (inp.equals("" + i)) {
                    jtfScreen.setText("" + (current + i));
                }

            }

            if (inp.equals(".")) {
                jtfScreen.setText("" + (current + "."));
            }

            if (inp.equals("*")) {
                jtfScreen.setText("" + (current + "*"));
            } else if (inp.equals("/")) {
                jtfScreen.setText("" + (current + "/"));
            } else if (inp.equals("+")) {
                jtfScreen.setText("" + (current + "+"));
            } else if (inp.equals("-")) {
                jtfScreen.setText("" + (current + "-"));
            } else if (inp.equals("x²")) {
                jtfScreen.setText("" + (current + "^2"));
            } else if (inp.equals("=")) {
                if (current.equals("")) {

                } else {
                    recentlyPressed = true;
                    Double result = eval(current);
                    jtfScreen.setText(result.toString());

                }

            }
        }

    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ')
                    nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length())
                    throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            // | functionName `(` expression `)` | functionName factor
            // | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+'))
                        x += parseTerm(); // addition
                    else if (eat('-'))
                        x -= parseTerm(); // subtraction
                    else
                        return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*'))
                        x *= parseFactor(); // multiplication
                    else if (eat('/'))
                        x /= parseFactor(); // division
                    else
                        return x;
                }
            }

            double parseFactor() {
                if (eat('+'))
                    return +parseFactor(); // unary plus
                if (eat('-'))
                    return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')'))
                        throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.')
                        nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z')
                        nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')'))
                            throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt"))
                        x = Math.sqrt(x);
                    else if (func.equals("sin"))
                        x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos"))
                        x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan"))
                        x = Math.tan(Math.toRadians(x));
                    else
                        throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^'))
                    x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
    public static void main(String[] args) {
        JFrame f = new calculator2();
        f.setTitle("Simple Calculator");
        f.setSize(400, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
