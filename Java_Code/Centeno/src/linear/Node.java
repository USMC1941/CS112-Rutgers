package linear;

public class Node<T> {

    T data;
    Node next;

    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
