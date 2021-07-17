package apps.linear.postfix;

import java.io.PrintWriter;

/**
 * This class implements a status tracker that stores the portion of an expression
 * that has been processed so far. It is only visible in its package.
 * 
 * @author Sesh Venugopal
 *
 */
class StatusKeeper {
	
	/**
	 * Buffer in which status is stored. 
	 */
	StringBuffer status;
	
	/**
	 * Initializes a new instance to empty (clear) status. 
	 */
	StatusKeeper() {
		status = new StringBuffer();
	}
	
	/**
	 * Resets the status to empty (clear). 
	 */
	void init() {
		status.setLength(0);
	}
	
	/**
	 * Updates the status by appending a given token to the current status.
	 * 
	 * @param token Token to be appended.
	 */
	void update(String token) {
		status.append(token + " ");
	}
	
	/**
	 * Returns the current status.
	 * 
	 * @return Current status.
	 */
	String getStatus() {
		return status.toString();
	}
	
	/**
	 * Prints the current status.
	 * 
	 * @param pw PrintWriter used to print status.
	 */
	void printStatus(PrintWriter pw) {
		pw.println("     Processed : " + status);
	}
}
