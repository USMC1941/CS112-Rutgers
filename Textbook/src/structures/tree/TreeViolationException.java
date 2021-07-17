package structures.tree;

/**
 * This is a runtime exception thrown to indicate that an attempt is being
 * made to violate the ordering of a binary tree structure.   
 * 
 * @author Sesh Venugopal
 *
 */
public class TreeViolationException extends RuntimeException {
	
	/**
	 * Initializes an instance with no message.
	 */
	public TreeViolationException() {
		super();
	}
	
	/**
	 * Initializes an instance with a message.
	 * 
	 * @param s Message that details the order violation.
	 */
	public TreeViolationException(String s) {
		super(s);
	}
}
