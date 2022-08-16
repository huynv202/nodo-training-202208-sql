package NODO_tranning_JV_Core_Basic1;

public class StringExample2 {
    public static void main(String[] args) {
        char [] chars ={'h','e','l','l','o'};
        String text= new String(chars);
        System.out.println(text);
        text = text.concat("hello");

        System.out.println("new value is"+text);
        System.out.println("hello java" .equals(text));
    }
}
