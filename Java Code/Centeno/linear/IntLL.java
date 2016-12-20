package linear;

/*
 * Linked List of IntNode
 */
public class IntLL {

	/*
	 * Create a new IntNode to be inserted at the front of the list.
	 * 
	 * @param data  the data of the node to be created
	 * @param front the reference to the front of the linked list
	 * @return      the new Node 
	 */
	public static IntNode addToFront(IntNode front, int data) {
		return new IntNode(data,front);
	}

	/*
	 * Create a new node and insert it after target
	 * 
	 * @param front    the reference to the front of the list
	 * @param target   the node data is to be inserted after
	 * @param newData  the data part of the node to be created
	 * @return         true if insertion is successful, false otherwise.
	 */
	public static boolean addAfter(IntNode front, int target, int newData){
		for (IntNode ptr = front; ptr != null; ptr=ptr.next){
			if (ptr.data == target) {
				IntNode node = new IntNode(newData,ptr.next);
				ptr.next = node;
				return true;
			}
		}
		return false;
	}

	/*
	 * Returns true if target is found, false otherwise
	 * 
	 * @param front  the reference to the front of the list
	 * @param target the value of the node the method is searching for
	 * @return       true if target is found, false otherwise
	 */
	public static boolean search (IntNode front, int target) {
		for (IntNode ptr = front; ptr != null; ptr=ptr.next){
			if (ptr.data == target) {
				return true;
			}
		}
		return false;
	}

	/* 
	 * Delete target and returns the front of the list
	 * 
	 * @param front  the reference to the front of the list
	 * @param target the node to be deleted
	 * @return       the reference to the front of the list
	 */
	public static IntNode delete(IntNode front, int target) {

		IntNode ptr = front;
		IntNode prev = null;

		/* 1. Traverse Linked List until target is found.
		 *    Have to keep two pointers: current and a previous. */
		while (ptr != null && ptr.data != target) {
			prev = ptr;
			ptr = ptr.next;
		}

		/* 2. Delete and return node. 
		 * Must handle: (a) the list is empty
		 * 				(b) target is not found, 
		 *              (c) target is at the front of the list. */
		if (ptr == null && front == null) {
			/* LL is empty */
			return null;
		} else if (ptr == null) {
			/* target is not found */
			return front;
		} else if (ptr == front) {
			/* target is the first node of the list */
			return ptr.next;
		} else {
			prev.next = ptr.next;
			return front;
		}	
	}

	/*
	 * Steps through all entries of the Linked List and prints its data.
	 * 
	 * @param start the reference to the front of the list
	 */
	public static void traverse(IntNode front) {
		System.out.print("Linked list: ");
		for (IntNode ptr = front; ptr != null; ptr=ptr.next){
			System.out.print(ptr.data + " - ");
		}
		System.out.println();
	}

	/*
	 * Testing our methods that handle a Linked List
	 */
	public static void main (String args[]) {	
		IntNode L = null;
		L = addToFront(L, 3);
		L = addToFront(L, 5);
		traverse(L);
		L = addToFront(L, 6);
		traverse(L);
		addAfter(L,5,4);
		traverse(L);
		System.out.println(addAfter(L,3,2));
		traverse(L);
		L = delete(L, 5);
		traverse(L);
	}
}
