package Unit03_Collection_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample2 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList(args));
        list.forEach((System.out::println));
    }
}
