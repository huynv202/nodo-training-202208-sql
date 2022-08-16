package Unit03_Collection_1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
        map.put(3,"ok3");
        map.put(2,"ok2");
        map.put(1,"ok1");
        map.put(4,"ok4");
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String>entry =iterator.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());

            map.descendingKeySet().forEach(key ->{
                System.out.println("key ="+key +" value = "+map.get(key));
            });
        }
    }

}
