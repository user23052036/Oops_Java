import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddNumber extends JFrame implements ActionListener
{
    private JLabel label1,label2,label3;
    private JTextField txt1,txt2,res;
    private JButton btn_add,btn_sub,btn_mul,btn_div;

    AddNumber()
    {
        setTitle("CALCULATOR");
        setSize(200,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label1 = new JLabel("Number1: ");
        txt1 = new JTextField(15);
        add(label1);
        add(txt1);

        label2 = new JLabel("Number2: ");
        txt2 = new JTextField(15);
        add(label2);
        add(txt2);

        label3 = new JLabel("Result: ");
        res = new JTextField(15);
        res.setEditable(false);
        add(label3);
        add(res);

        btn_add = new JButton(); //can be put inside the constructor string displayed inside the button
        btn_add.setText("SUM");
        add(btn_add);

        btn_sub = new JButton(); 
        btn_sub.setText("SUB");
        add(btn_sub);

        btn_mul = new JButton(); 
        btn_mul.setText("MUL");
        add(btn_mul);

        btn_div = new JButton(); 
        btn_div.setText("DIV");
        add(btn_div);

        btn_add.addActionListener(this);
        btn_sub.addActionListener(this);
        btn_mul.addActionListener(this);
        btn_div.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //parseInt ---> string to int
            //Integer.valueOf --- > string to Integer

            int num1 = Integer.parseInt(txt1.getText()); 
            int num2 = Integer.parseInt(txt2.getText());
            int result=0;

            if(e.getSource() == btn_add)
                result = num1+num2;
            else if(e.getSource() == btn_sub)
                result = num1-num2;
            else if(e.getSource() == btn_mul)
                result = num1*num2;
            else if(e.getSource() == btn_div)
            {
                if(num2==0)
                {
                    res.setText("error div by 0");
                    return;
                }
                result = num1/num2;
            }
            res.setText(String.valueOf(result));
        } catch(NumberFormatException exp){
            System.out.println(exp.getMessage());
        }
    }

    public static void main(String[] args) {
        new AddNumber();
    }
}