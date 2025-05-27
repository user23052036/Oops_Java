import java.util.WeakHashMap;

public class Demo_WeakHashMap 
{
    public static void main(String args[])
    {
        WeakHashMap<String,Image> map = new WeakHashMap<>();  // weak reference
        
        /*
        map.put("img1",new Image("image-1"));
        map.put("img2",new Image("image-2"));
        map.put("img3",new Image("image-3"));

        System.out.println(map);  // no ordering is preserved
        someworkdone();
        System.out.println(map);  

        Why Entries Are Not Removed?
        1. String Literals Are Interned
        When you use string literals (e.g., "img1"), Java automatically interns them(Strores then in a 
        special part of a heap memory called as String pool or intern String pool), placing them in the 
        String pool. These interned strings are strongly referenced by the pool and are not eligible for 
        garbage collection unless the JVM unloads the class.

        2. WeakHashMap Behavior
        WeakHashMap only weakly references its keys (not values). If the key is garbage-collected, the 
        entire entry (key-value pair) is automatically removed from the map.

        However, in your code, the keys ("img1", "img2", etc.) are strongly referenced by the String pool, 
        so they are not eligible for garbage collection. As a result, the entries remain in the map.
        
        To see WeakHashMap entries being garbage collected, use non-interned keys (e.g., new String("img1") 
        or non-String objects).
        */


        map.put(new String("img1"), new Image("image-1"));
        map.put(new String("img2"), new Image("image-2"));
        map.put(new String("img3"), new Image("image-3"));

        System.out.println("Before GC: " + map); // All entries present

        // Suggest GC (not guaranteed, but likely in this case)
        System.gc();
        someworkdone();

        System.out.println("After GC: " + map); // Entries likely removed
    }

    static void someworkdone()
    {
        try{Thread.sleep(10000);}
        catch(Exception e){e.printStackTrace();}
    }
}

class Image
{
    String name;
    Image(String name)
    {
        this.name=name;
    }
    @Override
    public String toString()
    {
        return "{"+name+"}";
    }
}
