package collection;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache <K,V> implements Iterable<K>{
    int max = 3;

    public LRUCache(int max){
        this.max = max;
    }

    public LRUCache(){
        max = 3;
    }
    LinkedHashMap<K,V> cache = new LinkedHashMap<>();

    public void cache(K key,V value){
        if(cache.containsKey(key)){
            cache.remove(key);
        }else if(cache.size() >=max){

        }

    }
    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
