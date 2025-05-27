import java.util.HashMap;
import java.util.LinkedHashMap;

public class Demo_LinkedHashMap
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        
        HashMap<String,Integer> map = new HashMap<>();
        map.put("apple",60);
        map.put("orange",50);
        map.put("guava",10);
        map.put("lemon",5);
        map.put("Momos",null);
        map.put("Biriyani",67);

        LinkedHashMap linkedmap = new LinkedHashMap(map);
        System.out.println(linkedmap.getOrDefault("Momos",20));
        System.out.println(linkedmap.putIfAbsent("Biriyani",120));
        System.out.println(linkedmap);
    }
}