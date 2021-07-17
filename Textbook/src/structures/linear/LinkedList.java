package structures.linear;

import java.util.NoSuchElementException;

/**
 * Helper class that implements linked list nodes.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of objects to be stored in this node
 */
class Node<T> {
	
	/**
	 * Data
	 */
	T data;
	
	/**
	 * Next reference
	 */
	Node<T> next;
	
	/**
	 * Initializes node with given data and null reference
	 * 
	 * @param dat Data
	 */
	Node(T dat) {
		data = dat;
		next = null;
	}
}

/**
 * This class implements a generic circular linked list (CLL).
 *
 * @author Sesh Venugopal
 * 
 * @param <T> The type of objects to be stored in this CLL.
 */
public class LinkedList<T> {
	
	
	
	/**
	 * Reference to the last node of this CLL
	 */
	Node<T> tail;   
	
	/**
	 * Number of nodes in this CLL.
	 */
	int count;   
	
	/**
	 * Initializes this CLL to empty.
	 */
	public LinkedList() {
		tail = null;
		count = 0;
	}
	
	/**
	 * Adds a new item to the end of this CLL.
	 * 
	 * @param item The item to be added to the end of this CLL.
	 */
	public void add(T item) {
		Node<T> itemnode = new Node<T>(item);
		
		if (count == 0) { // empty list
			itemnode.next = itemnode;
		} else {
			itemnode.next = tail.next;
			tail.next = itemnode;
		}
		tail = itemnode;
		count++;
	}
	
	/**
	 * Inserts a new item at a given index in this CLL. 
	 * 
	 * @param item Item to be inserted.
	 * @param index Index of inserted item.
	 * @throws IndexOutOfBoundsException If the index is < 0 or >= number of 
	 *         items currently in this CLL.
	 */
	public void insertAt(T item, int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + count);
		}
		
		// find predecessor
		Node<T> pred = tail;
		for (int i=0; i < index; i++) {
			pred = pred.next;
		}
		
		// insert after pred	
		Node<T> itemnode = new Node<T>(item);
		itemnode.next = pred.next;
		pred.next = itemnode;
		count++;
	}
	
	/**
	 * Removes the first occurrence of a given item from this CLL.
	 * 
	 * @param item Item to be removed.
	 * @throws NoSuchElementException If this CLL does not contain the given item.
	 */
	public void remove(T item) {
		int i = indexOf(item);
		if (i == -1) {
			throw new NoSuchElementException();
		}
		removeAt(i);
	}
	
	/**
	 * Removes the item at a given index.
	 * 
	 * @param index Index of item to be removed.
	 * @return The removed item.
	 * @throws IndexOutOfBoundsException If the index is < 0 or >= number of 
	 *         items currently in this CLL.
	 */
	public T removeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + count);
		}
		T ret=null;
		if (index == 0) {
			ret = tail.next.data;
			if (count == 1) { // single element, special case
				tail = null;
			} else {  // at least two entries
				tail.next = tail.next.next;
			}
			count--;
		} else { // at least two entries, and index > 0   
			// find the entry just prior to index
			Node<T> prev=tail.next;
			for (int i=0; i < index-1; i++) {
				prev = prev.next;
			}
			// remove after prev
			Node<T> curr = prev.next;
			ret = curr.data;  // save for return 
			prev.next = curr.next;
			curr.next = null;
			count--;
			if (curr == tail) {
				tail = prev;
			}
		}
		return ret;
	}
	
	/**
	 * Removes all occurrences of a given item from this CLL.
	 * 
	 * @param item The item, all instances of which are to be removed from this CLL.
	 * @throws NoSuchElementException If this CLL does not contain the given item.
	 */
	public void removeAll(T item) {
		if (count == 0) {
			throw new NoSuchElementException();
		}
		
		// step through all entries
		Node<T> prev=tail, curr=tail.next;
		int oldcount = count;
		for (int i=0; i < oldcount; i++) {
			if (item.equals(curr.data)) {
				prev.next = curr.next;
				curr.data = null;
				curr.next = null;
				count--;
			} else {
				prev = curr;
			}
			curr = prev.next;
		}
		if (count == oldcount) { // no match
			throw new NoSuchElementException();
		} 
		if (count == 0) {
			tail = null;
		} else {
			tail = prev;
		}
	}
	
	/**
	 * Empties this CLL by removing all items.
	 */
	public void clear() {
		tail = null;
		count = 0;
	}
	
	/**
	 * Replaces the item in this CLL at a given index by a given item.
	 * 
	 * @param item Item that replaces existing item.
	 * @param index Index at which replacement is done.
	 * @throws IndexOutOfBoundsException If the index is < 0 or >= number of 
	 *         items currently in this CLL.
	 */
	public void setAt(T item, int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + count);
		}
		Node<T> curr=tail.next;
		for (int i=0; i < index; i++) {
			curr = curr.next;
		}
		curr.data = item; // update
	}
	
	/**
	 * Returns the item at the specified index in this CLL.
	 * 
	 * @param index Position in this CLL from which item is to be returned.
	 * @return Item at specified index.
	 */
	public T getAt(int index) { 
		if (index < 0 || index >= count) { 
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + count); 
		}
		// skip over intervening nodes 
		Node<T> curr=tail.next; 
		for (int i=0; i < index; i++) { 
			curr = curr.next; 
		} 
		return curr.data; 
	}
	
	/**
	 * Returns the index of a given item in this CLL.
	 * 
	 * @param item Item for which index is to be found.
	 * @return Index of the given item.
	 */
	public int indexOf(T item) {
		if (count == 0) {
			return -1;
		}
		
		// step through list nodes
		Node<T> curr=tail.next;
		for (int i=0; i < count; i++) {
			if (item.equals(curr.data)) {
				return i;
			}
			curr = curr.next;
		}
		return -1;
	}
	
	/**
	 * Returns the number of nodes in this CLL.
	 * 
	 * @return Number of nodes in this CLL.
	 */
	public int size() {
		return count;
	}
	
	/**
	 * Tells whether this CLL is empty or not.
	 * 
	 * @return True if this CLL is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return count == 0;
	}
}
