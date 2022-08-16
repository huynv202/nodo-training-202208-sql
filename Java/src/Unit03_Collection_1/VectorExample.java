package Unit03_Collection_1;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(14);
        vector.add(4);
        vector.add(3);
        vector.add(10);
        vector.add(9);
        System.out.println("Size of vector: "+vector.size());
        System.out.println("Element at 2 "+ vector.get(0));
    }
}
