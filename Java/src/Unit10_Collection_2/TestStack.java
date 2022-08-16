package Unit10_Collection_2;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(45);
        stack.push(55);
        stack.push(66);
        stack.push(11);
        while (stack.hashNext()){
            System.out.println("data ="+stack.pop());
        }
    }
}
