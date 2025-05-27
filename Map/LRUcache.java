import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache<K,V> extends LinkedHashMap<K,V>
{
    int capacity;
    LRUcache(int capacity)
    {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
    {
        return size()>capacity;
    }
    public static void main(String[] args) 
    {
        LRUcache<String,Integer> cache = new LRUcache<>(3);
        cache.put("Zombie",3);
        cache.put("comic",12);
        cache.put("rook",11);
        cache.put("knight",8); //Zombie removed

        System.out.println(cache);
    }
}