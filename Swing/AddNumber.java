import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddNumber extends JFrame implements ActionListener
{
    private JLabel label1,label2,label3;
    private JTextField txt1,txt2,res;
    private JButton button;

    AddNumber()
    {
        setTitle("ADDER");
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
        add(label3);
        add(res);

        button = new JButton(); //can be put inside the constructor string displayed inside the button
        button.setText("SUM");
        add(button);

        button.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int num1 = Integer.parseInt(txt1.getText());
        int num2 = Integer.parseInt(txt2.getText());
        int result = num1+num2;
        res.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new AddNumber();
    }
}