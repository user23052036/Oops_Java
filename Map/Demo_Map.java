import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Objects;

/*
 * While not strictly required, it's good practice to declare overridden methods as public because the 
 * original toString() in Object is public.
 */
class Person
{
    String name;
    int id;

    Person(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);  //generated hashcode just based on the name not by default (object)
        //as with new key word every object will be different so hashcode for the same name will also be different
    }

    /*
     *  new Person("Alice", 1).equals(new Person("Alice", 2))  // false (same name, different ID)
        new Person("Alice", 1).equals(new Person("Alice", 1))  // true
        this.equals(Object o);
     */
    @Override
    public boolean equals(Object O)
    {
        if(this == O) return true;
        if(O == null || this.getClass() != O.getClass()) return false;
        Person person = (Person)O;
        return (id==person.id) && (Objects.equals(name, person.name));
    }

    @Override
    public String toString()
    {
        return "name: "+name+" ID: "+id;
    }
}

class Demo_Map
{
    public static void main(String[] args) 
    {
        HashMap<Integer,String> map = new HashMap<>();  
        map.put(1,"Souvik");
        map.put(2044,"Utkarsh");
        map.put(12,"Bhairava");
        map.put(22,"Maji");
        
        String std1 = map.get(2044);
        // String std2 = map.getvalue(); wrong can only be used on a specific entry
        System.out.println(std1);
        System.out.println(map.containsKey(2044));
        System.out.println(map.containsValue("sony"));

        Set<Integer> keys =  map.keySet();  //no particular order is followed
        for(Integer i: keys)
            System.out.println(map.get(i));

        Set<Map.Entry<Integer,String>> entries =  map.entrySet(); //type ---> Map.Entry<Integer,String>
        for(Map.Entry<Integer,String> entry: entries)
        {
            entry.setValue(entry.getValue().toUpperCase());
            System.out.println(entry.getKey()+" -> "+entry.getValue()); 
        }

        HashMap<Integer,Integer> map2 = new HashMap<>();
        map2.put(null, null);
        map2.put(null,2);
        System.out.println(map2);   // this will set the current current corresponsing value associated to null
        // null-->2

        String student = map.remove(21);    //declaired in map interface
        boolean status = map.remove(22,16); //declaired in AbstructMap abstruct Class

        //-----------------------------------------------------------------------------------

        Person p1 = new Person("Souvik",2036);
        Person p2 = new Person("Utkarsh",2044);
        Person p3 = new Person("Souvik",2036);

        HashMap<Person,String> map3 = new HashMap<>();
        map3.put(p1, "hero");
        map3.put(p2, "villain");
        map3.put(p3, "villain");

        System.out.println(map3);

    }
}