package Linear;

import java.util.NoSuchElementException;

public class Stack<T> {
    Node<T> front;
    int size;

    public Stack() {
        front = null;
        size = 0;
    }

    public void push(T item) {
        front = new Node<>(item, front);
        size++;
    }

    public T pop() throws NoSuchElementException {
        if (front == null) {
            throw new NoSuchElementException();
        }
        T temp = front.data;
        front = front.next;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = null;
        size = 0;
    }
}
