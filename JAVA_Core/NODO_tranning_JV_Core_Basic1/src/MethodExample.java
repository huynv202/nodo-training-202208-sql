public class MethodExample {
    private static  int add(int number1, int numer2){
        return  number1 +numer2;
    }

    public static void main(String[] args) {
        System.out.println("4 +7 =" + add(4,7));
        int value1 = Integer.parseInt(args[0]);
        int value2 = Integer.parseInt(args[1]);
        System.out.println("Value 1 + value 2 =" + add(value1,value2));
    }


}
