//JFrame is a (GUI-window) to add components to
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class BoilerPlate
{
    public static void main(String x[])
    {
        JFrame frame = new JFrame();                              //creates a frame
        frame.setTitle("My First GUI APPLICATION");      //sets title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit out of the application
        frame.setResizable(false);                    //prevents frame from being resized
        frame.setSize(400,550);                   //sets both the dimentions of the frame
        frame.setVisible(true);                              //make frame visible

        ImageIcon img = new ImageIcon("me.png");
        frame.setIconImage(img.getImage());
    }
}