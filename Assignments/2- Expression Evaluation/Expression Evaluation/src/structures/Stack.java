package structures;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A generic stack implementation.
 * 
 * @author ru-nb-cs111
 *
 * @param <T> Parameter type for items in the stack.
 */
public class Stack<T> {

	/**
	 * Items in the stack.
	 */
	private ArrayList<T> items;

	/**
	 * Initializes stack to empty.
	 */
	public Stack() {
		items = new ArrayList<T>();
	}

	/**
	 * Pushes a new item on top of stack.
	 * 
	 * @param item Item to push.
	 */
	public void push(T item) {
		items.add(item);
	}

	/**
	 * Pops item at top of stack and returns it.
	 * 
	 * @return Popped item.
	 * @throws NoSuchElementException If stack is empty.
	 */
	public T pop() 
	throws NoSuchElementException {
		if (items.isEmpty()) {
			//return null;
			throw new NoSuchElementException("can't pop from an empty stack");
		}
		return items.remove(items.size()-1);
	}

	/**
	 * Returns item on top of stack, without popping it.
	 * 
	 * @return Item at top of stack.
	 * @throws NoSuchElementException If stack is empty.
	 */
	public T peek() 
	throws NoSuchElementException {
		if (items.size() == 0) {
			//return null;
			throw new NoSuchElementException("can't peek on an empty stack");
		}
		return items.get(items.size()-1);
	}

	/**
	 * Tells if stack is empty.
	 * 
	 * @return True if stack is empty, false if not.
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}

	/**
	 * Returns number of items in stack.
	 * 
	 * @return Number of items in stack.
	 */
	public int size() {
		return items.size();
	}

	/**
	 * Empties the stack.
	 */
	public void clear() {
		items.clear();
	}
}
