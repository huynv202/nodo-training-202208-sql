import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamArrayExample {
    public static void main(String[] args) {
        Integer[] values ={2,4,7,1,3,5,9,11,13};
        Arrays.sort(values,(Integer o1,Integer o2)->
        {
            return  o2-o1;
        });


        for (int i =0; i<args.length;i++){
            Stream<Integer> st = Arrays.stream(values);
            st.forEach(value -> System.out.println(value));
            Consumer<Integer> c =(Integer value)->{
                System.out.println(value);
            };

            st.forEach(c);
        }

    }
}
