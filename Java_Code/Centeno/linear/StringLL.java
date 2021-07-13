package linear;

import java.util.NoSuchElementException;

public class StringLL {

	StringNode front; // front of our LL
	int        size; // size of the LL

	StringLL() {
		this.front = null;
		size = 0;
	}

	void clear() {
		front = null;
		size = 0;
	}

	void addToFront(String data) {
		/* O(1) */
		front = new StringNode(data, front);
		size++;
	}

	void traverse() {
		/* O(n) */
		System.out.printf("Linked list has %d nodes\n", size);
		for (StringNode ptr = front; ptr != null; ptr = ptr.next) {
			System.out.printf("%s ->", ptr.data);
		}
		System.out.println();
	}

	boolean search(String target) {
		for (StringNode ptr = front; ptr != null; ptr = ptr.next) {
			if (ptr.data.equals(target)) {
				return true;
			}
		}
		return false;
	}

	boolean addAfter(String target, String data) {
		for (StringNode ptr = front; ptr != null; ptr = ptr.next) {
			if (ptr.data.equals(target)) {
				StringNode node = new StringNode(data, ptr.next);
				ptr.next = node;
				size++;
				return true;
			}
		}
		return false;
	}

	void delete(String target) {
		StringNode ptr  = front;
		StringNode prev = null;
		while (ptr != null && !ptr.data.equals(target)) {
			prev = ptr;
			ptr = ptr.next;
		}
		if (ptr == null) {
			/* target was not found */
			throw new NoSuchElementException(target + " not found");
		}
		else if (ptr == front) {
			/* target is the first node of the LL */
			front = front.next;
			size--;
		}
		else {
			prev.next = ptr.next;
			size--;
		}
	}

	public static void main(String[] args) {
		StringLL ll = new StringLL();
		ll.addToFront("Tuesday");
		ll.addToFront("Monday");
		ll.addAfter("Tuesday", "Wednesday");
		ll.addToFront("Sunday");
		ll.traverse();
		try {
			ll.delete("Friday");
		}
		catch (NoSuchElementException e) {
			System.out.println("Exception happend");
			System.exit(1);
		}

		System.out.println("After");
	}
}
