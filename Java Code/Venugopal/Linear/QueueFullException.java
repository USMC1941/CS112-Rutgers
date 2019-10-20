package Linear;

public class QueueFullException extends Exception {

	public QueueFullException() {
		super();  // call superclass (Exception) constructor that does not take arguments
	}

	public QueueFullException(String message) {
		super(message);  // call superclass (Exception) constructor that takes a single String argument
	}
}
