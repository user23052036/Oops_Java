import java.util.HashSet;

class Demo_HashSet
{
    public static void main(String x[])
    {
        HashSet hs = new HashSet();
        hs.add("omg");
        hs.add(12);
        hs.add("it works");
        hs.add("one");
        hs.add(12);
        hs.add("it works");
        
        System.out.println(hs);
    }
}