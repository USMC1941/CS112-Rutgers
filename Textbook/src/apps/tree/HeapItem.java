package apps.tree;

/**
 * A class that encapsulates a heap item containing a generic data instance and
 * an integer priority.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> Type of data that will be stored in the heap item.
 */
public class HeapItem<T> implements Comparable<HeapItem<T>> {
	
	/**
	 * Data in heap item.
	 */
	private T data;
	
	/**
	 * Priority of heap item.
	 */
	private int priority;
	
	/**
	 * Initializes a new instance with given data and priority.
	 * 
	 * @param data Data.
	 * @param priority Priority.
	 */
	public HeapItem(T data, int priority) {
		this.data = data;
		this.priority = priority;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + data + "," + priority + ")";
	}
	
	/**
	 * Compares priority of this heap item instance with another.
	 * 
	 * @param other Other heap item.
	 * @return 0 if priorities are equal, < 0 if this item's priority is less than other's,
	 * 			> 0 if this item's priority is greater than other's.
	 */
	public int compareTo(HeapItem<T> other) {
		return priority - other.priority;
	}
	
	/**
	 * Returns data stored in this heap item.
	 * 
	 * @return Data stored in item.
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Returns priority of this heap item.
	 * 
	 * @return Priority of item.
	 */
	public int getPriority() {
		return priority;
	}
}


