import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equiButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myfont = new Font("Raleway", Font.BOLD, 30);
    double num1 = 0, num2 =0,result = 0;
    char operator;

    public Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(550,100,420,550);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equiButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equiButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;


        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equiButton);
        panel.add(divButton);
    
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Calculator();
    }
    public void actionPerformed(ActionEvent ae){
        for(int i=0;i<10;i++){
            if(ae.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(ae.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(ae.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(ae.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(ae.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(ae.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(ae.getSource() == equiButton){
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(ae.getSource() == clrButton){
            textfield.setText(String.valueOf(""));
        }
        if(ae.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(ae.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }

    }
}