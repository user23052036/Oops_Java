import java.util.TreeSet;

public class Demo_TreeSet
{
    public static void main(String args[])
    {
        TreeSet tree = new TreeSet();
        tree.add(null);
        // this was valid till version-6 but now it is removed.
        //NULLPOINTEREXCEPTION  can not compare null with any value 

        System.out.println(tree);
    }
}