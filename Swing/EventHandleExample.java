import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

class ClickEvent extends JFrame implements ActionListener
{
    private JLabel label;
    private JTextField textfield;
    private JButton button;

    ClickEvent()
    {
        //set JFrame
        super("Button click app");
        setSize(200,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //set JLabel
        label = new JLabel("Click the button");
        add(label);

        //set JTextField
        textfield = new JTextField(15);
        add(textfield);

        //set JButton
        button = new JButton("Click ME");
        add(button);
        button.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String text = textfield.getText();

        if(!text.isEmpty())
            label.setText(text);
        else
            label.setText("CLICKED");
    }
}


//driver class
public class EventHandleExample
{
    public static void main(String[] args) 
    {
        new ClickEvent();
    }
}