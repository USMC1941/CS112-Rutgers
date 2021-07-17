package apps.tree.scheduling;

/**
 * This class encapsulates a process that will be scheduled for execution on a
 * processor. 
 * 
 * @author Sesh Venugopal
 *
 */
class Process implements Comparable<Process> {
	
	/**
	 * Process id.
	 */
	int pid;         
	
	/**
	 * Execution time remaining.
	 */
	int execTime;   
	
	/**
	 * Arrival time of process in the process priority queue.
	 */
	int arrivalTime; 
	
	/**
	 * Priority of execution of the process.
	 */
	int priority;    
	
	/**
	 * Initializes a new instance with given id, execution time and priority.
	 * 
	 * @param pid Process id.
	 * @param execTime Execution time.
	 * @param priority Relative priority.
	 */
	Process(int pid, int execTime, int priority) {
		this.pid = pid;
		this.execTime = execTime;
		this.priority = priority;
		arrivalTime = 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + pid + "," + execTime + "," +
		priority + "," + arrivalTime + ")";
	}
	
	/**
	 * Compares the priority of this process with that of another.
	 * 
	 * @param other Other process with which priority is compared.
	 * @return 0 if priorities are equal, < 0 if this process has lower priority, 
	 * 			> 0 if this process has higher priority.
	 */
	public int compareTo(Process other) {
		int c = priority - other.priority;
		if (c != 0) {
			return c;
		}
		return other.arrivalTime - arrivalTime;
	}
}
