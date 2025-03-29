//JFrame is a (GUI-window) to add components to
//label likes to ake as much room as possible

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BoilerPlate
{
    public static void main(String x[])
    {
        /* 
        JFrame frame = new JFrame();                              //creates a frame
        frame.setTitle("My First GUI APPLICATION");      //sets title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit out of the application
        frame.setResizable(true);                    //prevents frame from being resized
        frame.setSize(400,550);                   //sets both the dimentions of the frame
        frame.setVisible(true);                              //make frame visible

        ImageIcon img = new ImageIcon("me.png");        //create an imageicon
        frame.setIconImage(img.getImage());                     //change icon of the frame
        frame.getContentPane().setBackground(new Color(200,90,150)); //RGB colour set in the background
        // we can put a hex value 0x folowed by 6 value from (0x000000)-(0xFFFFFF)
        */
        ImageIcon image = new ImageIcon("me.png");


        JLabel label = new JLabel();        //create a label 
        label.setText("Walking Life 2001");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);//set text position relative to the ImageIcon LEFT,RIGHT,CENTER
        label.setVerticalTextPosition(JLabel.TOP); //TOP,CENTRE,BOTTOM
        label.setBackground(new Color(50,19,170));  //sets color of text
        label.setFont(new Font("MV  Boli",Font.PLAIN,30));      //sets the style of font and size
        label.setIconTextGap(20);   // set +ve or -ve number distance between text and Icon


        MyFrame mf = new MyFrame();
        mf.add(label);                         //add the label to frame

    }
}