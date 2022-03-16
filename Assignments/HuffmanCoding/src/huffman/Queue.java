/**
 * This class contains a generic queue class which supports isEmpty, size, enqueue, dequeue, and
 * peek. It is implemented using a circular linked list.
 *
 * @author Ishaan Ivaturi
 */
public class Queue<T> {
    private Node<T> back;
    private int size;

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T d, Node<T> n) {
            data = d;
            next = n;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        size++; // Enqueueing increases the size by 1

        // If there were no elements before, make a node that points to itself
        if (size == 1) {
            back = new Node<>(item, null);
            back.next = back;
            return;
        }

        // Otherwise, add a node after back and update back
        // Represents adding at the end
        back.next = new Node<>(item, back.next);
        back = back.next;
    }

    public T dequeue() {
        T item = back.next.data;
        size--; // Dequeueing decreases the size by 1

        // If there are no elements left, just make back null
        if (size == 0) {
            back = null;
            return item;
        }

        // Otherwise, remove the front of the list (back.next)
        back.next = back.next.next;
        return item;
    }

    public T peek() {
        // Just return the data of the front of the queue
        return back.next.data;
    }
}
