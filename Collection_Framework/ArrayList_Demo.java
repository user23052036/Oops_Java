import java.util.*;

class ArrayList_Demo
{
    public static void main(String args[])
    {
        ArrayList l1 = new ArrayList(4);
        l1.add("Souvik");
        l1.add(16);
        l1.add(19.75);

        Iterator it = l1.iterator();   //(universal forward iterator)
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}