package linear;

import java.util.NoSuchElementException;

/** A queue implemented using a Circular Linked List */
public class Queue<T> {

    /** Reference to the last node of this Queue */
    Node<T> rear;

    /** Number of nodes in this Queue */
    int size;

    /** Initializes this Queue to empty */
    public Queue() {
        rear = null;
        size = 0;
    }

    /** Adds a new node to the end of our Circular Linked List (Queue) */
    public void enqueue(T item) {

        Node<T> newItem = new Node<>(item, null);

        if (rear == null) {
            newItem.next = newItem;
        } else {
            newItem.next = rear.next;
            rear.next = newItem;
        }
        rear = newItem;
        size++;
    }

    /**
     * Removes the first element of our Queue
     *
     * @return the first element of the CLL
     */
    public T dequeue() throws NoSuchElementException {
        T data;
        if (rear == null) {
            throw new NoSuchElementException("queue is empty");
        } else if (rear == rear.next) {
            /* One element */
            data = rear.data;
            rear = null;
        } else {
            data = (T) rear.next.data;
            rear.next = rear.next.next;
        }
        size--;
        return data;
    }

    /** @return the first element of the CLL */
    public T peek() throws NoSuchElementException {
        if (rear == null) {
            throw new NoSuchElementException("queue is empty");
        }
        return (T) rear.next.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        rear = null;
    }

    public void print() {
        Node<T> ptr = rear.next;
        do {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        } while (ptr != rear.next);
        System.out.println();
    }

    public static void main(String[] args) {}
}
