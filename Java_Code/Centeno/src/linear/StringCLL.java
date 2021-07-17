package linear;

public class StringCLL {

	private StringNode rear;
	private int        size;

	StringCLL() {
		rear = null;
		size = 0;
	}

	void addToFront(String data) {
		StringNode node = new StringNode(data, null);
		if (rear == null) {
			// list is empty
			node.next = node;
			rear = node;
		}
		else {
			node.next = rear.next;
			rear.next = node;
		}
		size++;
	}

	void search(String target) {
		if (rear == null) {
			System.out.println("List is empty");
			return;
		}
		StringNode ptr = rear.next;
		do {
			if (ptr.data.equals(target)) {
				System.out.println("Found it");
				return;
			}
			ptr = ptr.next;
		}
		while (ptr != rear.next);
		System.out.println(target + " not found");
	}

	void traverse() {
		StringNode ptr = rear.next;
		do {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
		while (ptr != rear.next);
		System.out.println();
	}

	void deleteFront() {
		if (rear == null || rear.next == rear) {
			rear = null;
			size = 0;
		}
		else {
			rear.next = rear.next.next;
			size--;
		}
	}
}
