import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JFrame;

class MyFrame extends JFrame
{
    MyFrame()
    {
        this.setTitle("My First GUI APPLICATION");      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        this.setResizable(true);                   
        this.setSize(400,550);                   
        this.setVisible(true);                              

        ImageIcon img = new ImageIcon("me.png");      
        this.setIconImage(img.getImage());                     
        this.getContentPane().setBackground(new Color(255,255,255));
    }
}
