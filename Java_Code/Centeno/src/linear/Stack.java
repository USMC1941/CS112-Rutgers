package linear;

import java.util.NoSuchElementException;

/*
 * Stack using Linked List
 */
public class Stack<T> {

	/*
	 * front points to the top (front) item
	 */ Node<T> front;

	public Stack() {
		front = null;
	}

	/*
	 * Add item into the top of the stack (front of the Linked List)
	 * @param item to be pushed into the stack
	 */
	public void push(T item) {

		front = new Node<T>(item, front);
	}

	/*
	 * Removes top item from the stack (front of the Linked List)
	 * @return stack's top item
	 */
	public T pop() {

		if (front == null) {
			throw new NoSuchElementException();
		}
		else {
			T tmp = front.data;
			front = front.next;
			return tmp;
		}
	}

	/*
	 * Returns the top item from stack
	 * @return stack's top item
	 */
	public T peek() {

		if (front == null) {
			return null;
		}
		else {
			return front.data;
		}
	}

	/*
	 * Checks if stack is empty
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public String toString() {
		String string = "Stack: ";
		for (Node<T> ptr = front; ptr != null; ptr = ptr.next) {
			string += ptr.data + " ";
		}
		return string;
	}

	public static void main(String[] args) {
	}
}
