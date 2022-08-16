package Unit10_Collection_2;

public class TestNode {
    private static void test(Node<?> node){
        while(node != null){
            System.out.println("Value is "+node.getValue()+"");
            node=node.next;
        }
    }

    public static void main(String[] args) {
        Node<String> root = new Node<>("Step 1");
        Node<String> node1 = new Node<>("Step 2");
        Node<String> node2 = new Node<>("Step 3");
        root.next = node1;
        node1.next=node2;
        test(root);

        Node<Integer> root2;
        root2 =new Node<Integer>(99,
                new Node<Integer>(23,
                new Node<Integer>(11)));
        test(root2);
    }
}
