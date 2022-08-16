package NODO_Traning_JV_Core_Basic2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamArrayExample {
    public static void main(String[] args) {
        Integer[] values ={2,4,7,1,3,5,9,11,13};
//        Arrays.sort(values,(Integer o1,Integer o2)->
//        {
//            return  o2-o1;
//        });
        Stream<Integer> stream = Arrays.stream(values);
//        Optional<Integer> max = stream.max((Integer m1, Integer m2) -> {
//            return m1 - m2;
//        });
//        System.out.println("gia tri lon nhat ="+max.get());

        Predicate<Integer> predicate=(Integer value)->{
            return value>5;
        };
        Stream<Integer> older = stream.filter(predicate);
        older.forEach(System.out::println);

//
//        for (int i =0; i<args.length;i++){
//            Stream<Integer> st = Arrays.stream(values);
//            st.forEach(value -> System.out.println(value));
//            Consumer<Integer> c =(Integer value)->{
//                System.out.println(value);
//            };
//
//            st.forEach(c);
//        }


    }
}
