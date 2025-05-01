import java.util.*;

public class Vector_Demo
{
    public static void main(String[] args) 
    {
        Vector vec = new Vector();
        vec.add(91.65);
        vec.add("Souvik");

        // Enumeration enc = vec.elements();

        // while(enc.hasMoreElements())
        // {
        //     System.out.println(enc.nextElement());
        // }
        Iterator it = vec.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}