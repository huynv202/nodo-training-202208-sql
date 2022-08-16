package Unit10_Collection_2;

public class Node <T>{
    T value;
    Node<T> next;
    Node(T v){
        value=v;
    }
    Node(T v, Node<T>n){
        value = v;
        next =n;
    }
    T getter;

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getGetter() {
        return value;
    }


}
