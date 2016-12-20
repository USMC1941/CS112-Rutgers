package Linear;

import java.util.NoSuchElementException;

class Node<T> {
	T data;
	Node<T> next;
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public String toString() {
		return data+"";
	}
}

public class LinkedList<T> {
	Node<T> front;
	int size;
	
	public LinkedList() {
		front = null;
		size = 0;
	}
	
	public void addFront(T item) {
		front = new Node<T>(item, front);
		size++;
	}
	
	public void deleteFront() 
	throws NoSuchElementException {
		if (front == null) {
			throw new NoSuchElementException("Empty list, nothing to delete");
		}
		front = front.next;
		size--;
	}
	
	public void traverse() {
		if (front == null) {
			System.out.println("Empty list");
			return;
		}
		System.out.print(front.data);  // first item
		Node<T> ptr=front.next;    // prepare to loop starting with second item
		while (ptr != null) {
			System.out.print("->" + ptr.data);
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
}
