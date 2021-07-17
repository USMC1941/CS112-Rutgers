package structures.linear;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class implements a generic ordered list.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of objects stored in this list
 */
public class OrderedList<T extends Comparable<T>> { 
	
	/**
	 * Items in this ordered list, stored in an array list.
	 */
	ArrayList<T> elements;  
	
	/**
	 * Cursor for enumeration.
	 */
	int cursor;       
	
	/**
	 * Initializes an empty list with given initial capacity.
	 * 
	 * @param cap Initial capacity
	 */
	public OrderedList(int cap) {
		elements = new ArrayList<T>(cap);
		cursor = -1;
	}
	
	/**
	 * Initializes an empty list with default initial capacity.
	 *
	 */
	public OrderedList() {
		elements = new ArrayList<T>();
		cursor = -1;
	}
	
	/**
	 * Adds a given item to the end of this list.
	 * 
	 * @param item Item to be added.
	 * @throws OrderViolationException If the last item in the list 
	 * 			is greater or equal to the given item.
	 */
	public void add(T item) {
	
		int pos = elements.size();
		
		if (pos > 0) {   // there is a predecessor
			if (item.compareTo(elements.get(pos-1)) <= 0) {
				throw new OrderViolationException();
			}
		}
		elements.add(item);
	}
	
	/**
	 * Adds/inserts a given item at the given position in this list.
	 * 
	 * @param pos Position at which item is to be added/inserted. 
	 * @param item Item to be added/inserted.
	 * @throws IndexOutOfBoundsException If the given position is < 0 or >= list size.
	 * @throws OrderViolationException If the item in the list that would precede the
	 * 			new item is >= the new item, or the item in th list that would succeed
	 * 			the new item is <= the new item. 
	 */
	public void add(int pos, T item) {
	
		if (pos < 0 || pos >= elements.size()) {
			throw new IndexOutOfBoundsException("pos < 0 or >= " + elements.size()+1);
		}
		if (pos > 0) {  // there is a predecessor
			if (item.compareTo(elements.get(pos-1)) <= 0) {
				throw new OrderViolationException();
			}
		}
		if (pos < (elements.size()-1)) {  // there is a successor
			if (item.compareTo(elements.get(pos-1)) >= 0) {
				throw new OrderViolationException();
			}
		}
		elements.add(pos, item);
	}
	
	/**
	 * Inserts a given item into this list.
	 * 
	 * @param item Item to be inserted.
	 * @throws OrderViolationException If the new item is a duplicate of an existing item.
	 */
	public void insert(T item) {
		if (elements.size() == 0) {
			elements.add(item);
			return;
		}
		
		// find where the element should go
		int pos = binarySearch(item);
		
		if (pos >= 0) {  // this is a duplicate entry
			throw new OrderViolationException();
		} else {
			elements.add(-pos-1, item);
		}
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
	 * Tells whether this list is emmpty or not.
	 * 
	 * @return True if list is emmpty, false otherwise.
	 */
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	/**
	 * Searches for a given item in this list using binary search, and
	 * returns the position of the matching item.
	 * 
	 * @param item Item to be searched.
	 * @return Position of item, if match found. If there is no match, returns
	 * 			<em>pos</em>, where -<em>pos</em>-1 would be its position, <b>if it
	 * 			were to be inserted into this list.</b>   	
	 */
	public int binarySearch(T item) {
		if (elements.size() == 0) { // not found
			return -1;
		}
		int lo=0, hi=elements.size()-1;
		int mid=0;
		
		while (lo <= hi) {
			mid = (lo+hi)/2;
			int c = item.compareTo(elements.get(mid));
			if (c == 0) {
				return mid;
			}
			if (c < 0) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		
		if (item.compareTo(elements.get(mid)) < 0) {
			return(-(mid+1));
		} else {
			return(-(mid+2));
		}
	}
	
	/**
	 * Returns the item at a given position in this list.
	 * 
	 * @param pos Position in list.
	 * @return Item at given position.
	 */
	public T get(int pos) {
		if (pos < 0 || pos >= elements.size()) {
			throw new IndexOutOfBoundsException("pos < 0 or >= " + elements.size());
		}
		return elements.get(pos);
	}
	
	/**
	 * Removes a given item from this list.
	 * 
	 * @param item Item to be removed from this list.
	 * @throws NoSuchElementException If the given item is not in this list.
	 */
	public void remove(T item) {
		if (elements.size() == 0) {
			throw new NoSuchElementException();
		}
		int pos = binarySearch(item);
		if (pos < 0) {  // not found
			throw new NoSuchElementException();
		}
		elements.remove(pos);
	}
	
	/**
	 * Removes the item at a given position in this list.
	 * 
	 * @param pos Position of item to be removed.
	 * @throws IndexOutOfBoundsException If given position < 0 or >= size of list.  
	 */
	public void remove(int pos) {
		if (pos < 0 || pos >= elements.size()) {
			throw new IndexOutOfBoundsException("pos < 0 or >= " + elements.size());
		}
		elements.remove(pos);
	}
	
	/**
	 * Empties this list by removing all items.
	 */
	public void clear() {
		elements.clear();
	}
	
	/**
	 * Returns the first item in this list.
	 * 
	 * @return First item in this list, null if list is empty.
	 */
	public T first() {
		if (elements.size() == 0) {
			return null;
		}
		cursor = 0;
		return elements.get(cursor);
	}
	
	/**
	 * Returns the next item in this list, relative to a previous call to first or next.
	 * 
	 * @return Next item in this list, null if end of list is reached.
	 */
	public T next() {
		if (cursor < 0 || cursor == (elements.size()-1)) {
			return null;
		}
		cursor++;
		return elements.get(cursor);
	}
}


