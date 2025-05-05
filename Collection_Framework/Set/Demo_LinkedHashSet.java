import java.util.LinkedHashSet;

class Demo_LinkedHashSet
{
    public static void main(String x[])
    {
        LinkedHashSet hs = new LinkedHashSet();
        hs.add("omg");
        hs.add(12);
        hs.add("it works");
        hs.add("one");
        hs.add(12);
        hs.add("it works");
        
        System.out.println(hs);
    }
}