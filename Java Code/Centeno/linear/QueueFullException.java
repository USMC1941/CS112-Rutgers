package linear;

public class QueueFullException extends Exception{

	public QueueFullException() {
		super();
	}
	public QueueFullException(String msg) {
		super(msg);
	}
}