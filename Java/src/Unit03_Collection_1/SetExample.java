package Unit03_Collection_1;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers =new TreeSet<Integer>();
        numbers.add(1);
        numbers.add(14);
        numbers.add(17);
        numbers.add(2);
        numbers.add(6);
        System.out.println("Size of set: "+numbers.size());
    }
}
