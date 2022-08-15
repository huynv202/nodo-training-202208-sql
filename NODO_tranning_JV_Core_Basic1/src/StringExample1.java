public class StringExample1 {
    public static void main(String[] args) {
        String text ="say hello to everyone";
        System.out.println("length of text is :"+text.length());
        System.out.println("vi tri cua tu hello"+text.indexOf("hello"));
        System.out.println("cat :"+text.substring(4,9));

        int i =0;
        while (i <text.length()){
            char c =text.charAt(i);
            if(c ==' '){
                i++;
                continue;
            }
            System.out.println("Character at "+i+ "is "+c);
            i++;
        }
    }
}
