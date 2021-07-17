package structures.linear;

/**
 * This is a runtime exception thrown to indicate that an attempt is being
 * made to violate the ordering of a structure.   
 * 
 * @author Sesh Venugopal
 *
 */
public class OrderViolationException extends RuntimeException {
	
	/**
	 * Initializes an instance with no message.
	 */
	public OrderViolationException() {
		super();
	}
	
	/**
	 * Initializes an instance with a message.
	 * 
	 * @param s Message that details the order violation.
	 */
	public OrderViolationException(String s) {
		super(s);
	}
}
