import javax.swing.*;
import java.awt.FlowLayout;

class MyWindow
{
    JFrame jf;
    JLabel jl;
    JButton jb;

    MyWindow()
    {
        jf = new JFrame();
        jf.setTitle("My Window");
        jf.setSize(300,200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());

        jl = new JLabel();
        jl.setText("Welcome");
        jf.add(jl);

        jb = new JButton();
        jb.setText("Click");
        jf.add(jb);

        jf.setVisible(true);
    }

    public static void main(String args[])
    {
        new MyWindow();
    }
}