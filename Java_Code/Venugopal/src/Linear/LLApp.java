package Linear;

public class LLApp {

	public static IntNode addFront(int item, IntNode front) {
		return new IntNode(item, front);
	}

	public static IntNode deleteFront(IntNode front) {
		if (front == null) {
			System.out.println("Empty list, nothing to delete");
			return null;
		}
		return front.next;
	}

	public static boolean search(IntNode front, int target) {
		for (IntNode ptr = front; ptr != null; ptr = ptr.next) {
			if (target == ptr.data) {
				return true;
			}
		}
		return false;
	}

	public static void traverse(IntNode front) {
		if (front == null) {
			System.out.println("Empty list");
			return;
		}
		System.out.print(front.data);  // first item
		IntNode ptr = front.next;    // prepare to loop starting with second item
		while (ptr != null) {
			System.out.print("->" + ptr.data);
			ptr = ptr.next;
		}
		System.out.println();
	}

	// add newItem after oldItem
	// returns true if added, false if not
	public static boolean addAfter(IntNode front, int oldItem, int newItem) {
		// search and locate oldItem
		IntNode ptr = front;
		for (; ptr != null; ptr = ptr.next) {
			if (oldItem == ptr.data) {
				break;
			}
		}
		if (ptr == null) { // not found
			System.out.println("old item not in list, doing nothing");
			return false;
		}
		IntNode tmp = new IntNode(newItem, null);
		tmp.next = ptr.next;
		ptr.next = tmp;

		/** OR
		 * ptr.next = new IntNode(newItem, ptr.next);
		 *
		 */

		return true;
	}

	public static IntNode delete(IntNode front, int item) {
		IntNode ptr = front, prev = null;
		while (ptr != null) {
			if (ptr.data == item) {
				break;
			}
			prev = ptr;
			ptr = ptr.next;
		}
		// empty or item not found
		if (ptr == null) {
			System.out.print("item not in list");
			return front;
		}
		// deleting first node
		if (prev == null) {
			return front.next;
		}
		prev.next = ptr.next;
		return front;
	}

	public static void main(String[] args) {
		/*
		IntNode front = null;
        traverse(front);  // test traverse on empty list
        front = addFront(4,front);
        traverse(front);
        front = addFront(6,front);
        traverse(front);
        front = addFront(8,front);
        traverse(front);
        
        if (search(front,6)) {
        	System.out.println("6 is in the list");
        } else {
        	System.out.println("6 is not in the list");
        }
        
        front = deleteFront(front);
        traverse(front);
        front = deleteFront(front);
        traverse(front);
        front = deleteFront(front);
        traverse(front);
        front = deleteFront(front);
       
        front = addFront(4,front);
        traverse(front);
        front = addFront(6,front);
        traverse(front);
        addAfter(front, 6, 10);
        traverse(front);
        */
		// testing StringLL object
		StringLL stringLL = new StringLL();
		stringLL.addFront("4");
		stringLL.traverse();
		stringLL.addFront("5");
		stringLL.traverse();
		stringLL.deleteFront();
		stringLL.traverse();
		stringLL.deleteFront();
		stringLL.traverse();
		stringLL.deleteFront();
		stringLL.traverse();
	}
}
