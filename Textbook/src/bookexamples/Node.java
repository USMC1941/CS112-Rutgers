package bookexamples;

/**
 * A standalone node class that may be used to build "homemade" linked lists,
 * and an application that exercises this class.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type parameter for the object contained in this node
 */
public class Node<T> {
	
	/**
	 * Data in node.
	 */
	T data;
	
	/**
	 * Next reference.
	 */
	Node<T> next;
	
	/**
	 * Initializes this node with given data and next reference.
	 * 
	 * @param dat Data
	 * @param next Next reference
	 */
	Node(T dat, Node<T> next) {
		data = dat;
		this.next = next;
	}
	
	/**
	 * A mystery method that does something on a linked list. What does it do?
	 * 
	 * @param <T> Type parameter for objects in the nodes of the given linked list
	 * @param L Reference to the front of the given linked list
	 * @return Reference to a node of the linked list
	 */
	static <T> Node<T> mystery(Node<T> L) {
		Node<T> p = L;
		Node<T> q = L;
		while (q.next != null) {
			q = q.next;
			if (q.next != null) {
				q = q.next;
				p = p.next;
			}
		}
		return p;
	}
	
	/**
	 * Determines the size (number of nodes) of a linked list.
	 * 
	 * @param <T> Type parameter for objects in the nodes of the given linked list
	 * @param list Reference to the front of the given linked list
	 * @return Number of nodes in linked list
	 */
	static <T> int size(Node<T> list) {
		return 0;
	}
	
	/**
	 * @param args Arguments to application - none needed
	 */
	public static void main(String[] args) {
		Node<String> list = null;
		Node<String> newNode = new Node<String>("Carrot", null);
		newNode.next = list;
		list = newNode;
		list = new Node<String>("Bread", list);
		list = new Node<String>("Milk", list);
		Node<String> ret = mystery(list);
		System.out.println(list.data);
		System.out.println(ret.data);
	}
}
