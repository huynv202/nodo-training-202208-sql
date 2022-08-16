package NODO_tranning_JV_Core_Basic1;

import java.util.Arrays;

public class StreamProgram {
    public static void main(String[] args) {
        Arrays.stream(args).forEach((String value)->{
            System.out.println("Value is "+value);
        });
    }
}
