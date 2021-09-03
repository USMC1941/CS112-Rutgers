package linear;

import java.util.NoSuchElementException;

public class BoundedQueue<T> {

    T[] items;
    int size;
    int front, rear;

    public BoundedQueue(int cap) {
        items = (T[]) new Object[cap];
        size = 0;
        front = 0;
        rear = 0;
    }

    public void enqueue(T data) throws QueueFullException {
        if (size == 0) {
            /* empty queue */
            rear = front = 0;
        } else if (size == items.length) {
            throw new QueueFullException();
        } else if (rear == items.length - 1) {
            /* Queue is not full but rear is at the end of the array.
             * Must wrap around. */
            rear = 0;
        } else {
            rear += 1;
        }
        items[rear] = data;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            T data = items[front];
            size--;
            if (front == items.length - 1) {
                /* Front was at the end of the array, wrap around. */
                front = 0;
            } else {
                front++;
            }
            return data;
        }
    }

    public void print() {
        if (front < rear) {
            for (int i = front; i <= rear; i++) {
                System.out.println(items[i]);
            }
        } else {
            for (int i = front; i < items.length; i++) {
                System.out.println(items[i]);
            }
            for (int i = 0; i <= rear; i++) {
                System.out.println(items[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {}
}
