package structures.linear;

import java.util.NoSuchElementException;

/**
 * This class implements a generic LIFO stack.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of objects to be stored in this stack.
 */
public class Stack<T> {
	
	/**
	 * Items in this stack, stored in a generic linked list.  
	 */
	LinkedList<T> list;
	
	/**
	 * Keeps track of current position when iterating over this stack using
	 * the first( ) and next methods( ). 
	 */
	int cursor;
	
	/**
	 * Initializes this stack to empty.
	 */
	public Stack() {
		list = new LinkedList<T>();
		cursor = -1;
	}
	
	/**
	 *  Pushes a given item on this stack by adding to the top.
	 * 
	 * @param item Item to be pushed.
	 */
	public void push(T item) {
		if (list.size() == 0) {
			list.add(item);
		} else {
			list.insertAt(item,0);
		}
	}
	
	/**
	 * Pops from this stack by deleting and returning the item at the top.
	 * 
	 * @return Popped item.
	 * @throws NoSuchElementException If this stack is empty.
	 */
	public T pop() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		return list.removeAt(0);
	}
	
	/**
	 * Returns the number of items in this stack.
	 * 
	 * @return Number of items in this stack.
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Tells whether this stack is empty or not.
	 * 
	 * @return True if this stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Empties this stack by removing all items.
	 */
	public void clear() {
		list.clear();
	}
	
	/**
	 * Returns the item at the top of this stack, and sets the iteration cursor to the 
	 * top position. 
	 * 
	 * @return Item at the top of this stack, null if queue is empty.
	 */
	public T first() {
		if (list.size() == 0) {
			return null;
		}
		cursor = 0;
		return list.getAt(cursor);
	}
	
	/**
	 * Sets the cursor to the next position, and returns the item in stack queue at
	 * that position. <br> To iterate over this stack, there
	 * must be a call to first( ), followed by successive calls to next( ).
	 * 
	 * @return Next item in this stack. Null if stack is empty, or cursor is at the 
	 *         bottom of the stack at the time this method is called, i.e. end of stack was
	 *         reached. 
	 */
	public T next() {
		if (cursor < 0 || cursor == (list.size()-1)) {
			return null;
		}
		cursor++;
		return list.getAt(cursor);
	}
}
