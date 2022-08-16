package Unit03_Collection_1;

import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map= new Hashtable<Integer,String>();
        map.put(3,"ok3");
        map.put(2,"ok2");
        map.put(1,"ok1");
        map.put(4,"ok4");
        System.out.println(map.get(3));
        map.put(3,"sss");
        System.out.println(map.get(3));
    }
}
