import java.util.IdentityHashMap;


/*
 * Key Comparison:
In IdentityHashMap, keys are always compared using the == operator (reference equality), not equals(). This 
means two keys are considered the same only if they are the exact same object in memory, regardless of their 
hashCode() or equals() implementation.

Hashing:
IdentityHashMap uses System.identityHashCode() for hashing keys, which is based on the object's memory address, 
not the result of the object's hashCode() method.

Value Comparison:
When you retrieve a value, the map first finds the key using ==. Only if the key reference matches will it 
return the associated value.
When using methods like containsValue(), the value references are also compared using ==, not equals().

No Use of equals():
At no point in key or value lookup does IdentityHashMap invoke the equals() method for comparison—neither for 
keys nor for values. Only object references are checked, never their logical equality.
 */

public class Demo_IdentityHashMap 
{
    @SuppressWarnings("removal")
    public static void main(String[] args)
    {
        Integer key1 = new Integer(10);  //depresiated need to use Integer.valueOf(int) not an object
        Integer key2 = new Integer(10);

        IdentityHashMap<Integer, String> map = new IdentityHashMap<>();
        map.put(key1, "A");
        map.put(key2, "B");

        // key1 == key2 is false, so both entries exist
        System.out.println(map.size()); // 2

        // map.get(key1) will return "A"
        // map.get(key2) will return "B"
    }
}
