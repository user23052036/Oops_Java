package code.Collection_Framework.List;
import java.util.*;

public class LinkedList_Demo
{
    public static void main(String args[])
    {
        LinkedList list = new LinkedList();

        list.add(12);
        list.add(13);

        ListIterator it = list.listIterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}