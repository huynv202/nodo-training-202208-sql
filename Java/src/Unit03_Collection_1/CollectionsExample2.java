package Unit03_Collection_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample2 {
    public static void main(String[] args) {
        List<String>    list=new ArrayList<String>();
        Collections.addAll(list, new String[]{"Tu", "An","Hoa","Binh"});
        Collections.sort(list);
        for (int i =0;i< list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println(list);
        System.out.println("Vi tri thu "+ Collections.binarySearch(list,"Hoa"));
    }
}
