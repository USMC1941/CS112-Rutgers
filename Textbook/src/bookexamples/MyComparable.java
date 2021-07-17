package bookexamples;

/**
 * This is a sample comparable interface - see section "Implementing a Generic Interface"
 * in the text for a discussion.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type parameter for the objects that are compared.
 */
public interface MyComparable<T> {
	
	/**
	 * Checks if this object is less than the other object.
	 * 
	 * @param other Other object
	 * @return True if this object is less than the other, false otherwise
	 */
	boolean lessThan(T other);
	
	/**
	 * Checks if this object is greater than the other object.
	 * 
	 * @param other Other object
	 * @return True if this object is greater than the other, false otherwise
	 */
	boolean greaterThan(T other);
}
