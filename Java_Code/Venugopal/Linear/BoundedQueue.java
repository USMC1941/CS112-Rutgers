package Linear;

import java.util.NoSuchElementException;

public class BoundedQueue<T> {

	private T[] items;
	private int front;
	private int rear;
	private int size;

	public BoundedQueue(int bound) {
		items = (T[]) new Object[bound];
		size = 0;

		// these two initial values will work even if bound = 1 
		front = 0;
		rear = -1;
	}

	public void enqueue(T item) throws QueueFullException {
		if (size == items.length) {
			throw new QueueFullException();
		}
		rear = (rear + 1) % items.length;
		items[rear] = item;
		size++;
	}

	public T dequeue() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		T temp = items[front];
		front = (front + 1) % items.length;
		size--;
		if (size == 0) {
			front = 0;
			rear = -1;
		}
		return temp;
	}

	public T peek() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return items[front];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		front = 0;
		rear = -1;
		size = 0;
	}
}
