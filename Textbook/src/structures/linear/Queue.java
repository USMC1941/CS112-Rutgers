package structures.linear;

import java.util.NoSuchElementException;

/**
 * This class implements a generic FIFO queue.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of objects to be stored in this queue.
 */
public class Queue<T> {
	
	/**
	 * Items in this queue, stored in a generic linked list.  
	 */
	LinkedList<T> list;
	
	/**
	 * Keeps track of current position when iterating over this queue using
	 * the first( ) and next methods( ). 
	 */
	int cursor;
	
	/**
	 * Initializes this queue to empty.
	 */
	public Queue() {
		list = new LinkedList<T>();
		cursor = -1;
	}
	
	/**
	 * Enqueues a given item into this queue by adding to the end.
	 * 
	 * @param item Item to be enqueued.
	 */
	public void enqueue(T item) {
		list.add(item);
	}
	
	/**
	 * Dequeues from this queue by deleting and returning the item at the front.
	 * 
	 * @return Dequeued item.
	 * @throws NoSuchElementException If this queue is empty.
	 */
	public T dequeue() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		return list.removeAt(0);
	}
	
	/**
	 * Returns the number of items in this queue.
	 * 
	 * @return Number of items in this queue.
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Tells whether this queue is empty or not.
	 * 
	 * @return True if this queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Returns the position of a given item from the front of this queue.
	 * Front of the queue is position 0.
	 * 
	 * @param item Item for which position is to be found.
	 * @return Position of item, -1 if item is not in this queue.
	 */
	public int positionOf(T item) {
		return list.indexOf(item);
	}
	
	/**
	 * Empties this queue by removing all items.
	 */
	public void clear() {
		list.clear();
	}
	
	/**
	 * Removes the first occurrence (from the front) of a given item from this queue.
	 * 
	 * @param item Item to be removed.
	 * @throws NoSuchElementException If this queue does not contain the given item.
	 */
	public void remove(T item) { 
		list.remove(item);
	}
	
	/**
	 * Removes all occurrences of a given item from this queue.
	 * 
	 * @param item Item for which all instances are to be removed.
	 * @throws NoSuchElementException If this queue does not contain the given item.
	 */
	public void removeAll(T item) {
		list.removeAll(item);
	}
	
	/**
	 * Returns the first item in this queue, and sets the iteration cursor to the 
	 * first position. 
	 * 
	 * @return First item in this queue, null if queue is empty.
	 */
	public T first() {
		if (list.size() == 0) {
			return null;
		}
		cursor = 0;
		return list.getAt(cursor);
	}
	
	/**
	 * Sets the cursor to the next position, and returns the item in this queue at
	 * that position. <br> To iterate over this queue, there
	 * must be a call to first( ), followed by successive calls to next( ).
	 * 
	 * @return Next item in this queue. Null if queue is empty, or cursor is at the 
	 *         end of the queue at the time this method is called, i.e. end of queue was
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
