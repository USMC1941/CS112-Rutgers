package structures.linear;

/**
 * This class implements a generic unordered list.
 *
 * @author Sesh Venugopal
 * 
 * @param <T> The type of objects to be stored in this unordered list.
 */
public class List<T> {
	
	/**
	 * Entries in this list, stored in a generic linked list.
	 */
	LinkedList<T> elements;
	
	/**
	 * Keeps track of current position when iterating over this list using
	 * the first( ) and next methods( ). 
	 */
	int cursor;
	
	/**
	 * Initializes this list to empty.
	 *
	 */
	public List() {
		elements = new LinkedList<T>();
		cursor = -1;
	}
	
	/**
	 * Adds a given item to the end of this list.
	 * 
	 * @param item Item to be added to the end.
	 */
	public void add(T item) {
		elements.add(item);
	}
	
	/**
	 * Returns the number of items in this list.
	 * 
	 * @return Number of items in this list.
	 */
	public int size() {
		return elements.size();
	}
	
	/**
	 * Tells whether this list is empty or not.
	 * 
	 * @return True if this list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	/**
	 * Tells whether this list contains a given item.
	 * 
	 * @param item Item that is sought in this list.
	 * @return True if item is found, false otherwise.
	 */
	public boolean contains(T item) {
		return elements.indexOf(item) != -1;
	}
	
	/**
	 * Empties this list by removing all items.
	 */
	public void clear() {
		elements.clear();
	}
	
	/**
	 * Removes the first occurrence of a given item from this list.
	 * 
	 * @param item Item to be removed.
	 * @throws NoSuchElementException If this list does not contain the given item.
	 */
	public void remove(T item) { 
		elements.remove(item);
	}
	
	/**
	 * Removes all occurrences of a given item from this list.
	 * 
	 * @param item Item for which all instances are to be removed.
	 * @throws NoSuchElementException If this list does not contain the given item.
	 */
	public void removeAll(T item) { 
		elements.removeAll(item);
	}
	
	/**
	 * Returns the first item in this list, and sets the iteration cursor to the 
	 * first position. 
	 * 
	 * @return First item in this list, null if list is empty.
	 */
	public T first() {
		if (elements.size() == 0) {
			return null;
		}
		cursor = 0;
		return elements.getAt(cursor);
	}
	
	/**
	 * Sets the cursor to the next position, and returns the item in this list at
	 * that position. <br> To iterate over this list, there
	 * must be a call to first( ), followed by successive calls to next( ).
	 * 
	 * @return Next item in this list. Null if list is empty, or cursor is at the 
	 *         end of the list at the time this method is called, i.e. end of list was
	 *         reached. 
	 */
	public T next() {
		if (cursor < 0 || cursor == (elements.size()-1)) {
			return null;
		}
		cursor++;
		return elements.getAt(cursor);
	}
}
