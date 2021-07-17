package apps.tree.scheduling;

/**
 * This class implements a checked exception that is raised when a processor
 * is interrupted when it is busy executing a process. 
 * 
 * @author Sesh Venugopal
 *
 */
public class BusyInterruptionException extends Exception {
	
	/**
	 * Initializes a new instance with no detailed message.
	 */
	public BusyInterruptionException() {
		super();
	}
	
	/**
	 * Initializes a new instance with a detailed message.
	 * 
	 * @param s Detailed exception message.
	 */
	public BusyInterruptionException(String s) {
		super(s);
	}
}
