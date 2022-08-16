package Unit03_Collection_1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(5,3,6,33,12,43,86,76,54,32));
//        Comparator<Integer> comparator = Integer ::compare;
//        Collections.sort(listOfInteger,comparator);
//        listOfInteger.stream().filter(v -> v>5).forEach(System.out::println);
//        System.out.println("================");
//        Integer[] values = listOfInteger.stream().filter(v -> v > 5).toArray(size -> new Integer[size]);
//        Arrays.stream(values).forEach(System.out::println);
//
//        Collector<Integer,?,IntSummaryStatistics>collector = Collectors.summarizingInt(Integer::intValue);
//        IntSummaryStatistics summaryStatistics = listOfInteger.stream().collect(collector);
//        System.out.println("total ="+summaryStatistics.getSum());
//        System.out.println("Overage ="+summaryStatistics.getAverage());
//
//
//        Consumer<Integer> myConsumer = n->{
//            System.out.println("User input value ="+n);
//            if (n<5){
//                System.out.println("Invalid value!");
//                return;
//            }
//            listOfInteger.add(n);
//
//            System.out.println(listOfInteger);
//            listOfInteger.forEach(System.out::println);
//
//        };
//        myConsumer.accept(10000000);
//
//        Scanner scanner = new Scanner(System.in);
//        while (true){
//            System.out.println("Please  input a number :");
//            int value = scanner.nextInt();
//            myConsumer.accept(value);
//            System.out.println(value);
//        }



        Predicate<Integer> tester = v ->(v>5) ;

        Consumer<Integer> myC1 = n ->listOfInteger.add(n);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Please input a number: ");
            Integer value = Integer.parseInt(sc.nextInt()+"");
            if(value <0){
                break;
            }
            if(tester.test(value)){
                myC1.accept(value);
            }

        }
        listOfInteger.forEach(x->{
            System.out.println(x +"-");
        });
    }
}
