import java.util.*;

class ArrayList_Demo
{
    public static void main(String args[])
    {
        ArrayList l1 = new ArrayList(4);
        l1.add("Souvik");
        l1.add(11);

        Iterator it = l1.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}