package linear;

import java.util.NoSuchElementException;

public class LinkedList <T> {

	Node <T> front;
	int size;
	LinkedList () {
		front = null;
		size = 0;
	}
	void addToFront (T data) {
		front = new Node<T>(data, front);
		size++;
	}
	T deleteFront () {
		if (front == null) {
			throw new NoSuchElementException("Linked List is empty");
		}
		T data = front.data;
		front = front.next;
		size--;
		return data;
	}
	void traverse () {
		for (Node<T> ptr = front; ptr != null; ptr = ptr.next) {
			System.out.print(ptr.data + " -> ");
		}
		System.out.println("\\");
	}
}
