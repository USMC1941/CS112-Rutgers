package apps.tree.scheduling;

/**
 * This class implements a processor that executes processes in the simulation system.
 * 
 * @author Sesh Venugopal
 *
 */
class Processor {
	
	/**
	 * Time slice for which each process will be executed at this processor.
	 */
	int timeSlice;  
	
	/**
	 * Clock for timing each time slice.
	 */
	int clock;      
	
	/**
	 * Flag to indicate is processor is busy executing a process. 
	 */
	boolean busy;
	
	/**
	 * Process that is currently executing at this processor, if the processor is busy.
	 * After process gets its time slice, processor becomes idle, and the process
	 * can be retrieved, at which time this field is set to null. 
	 */
	Process currProc;  
	
	/**
	 * Initializes a new instance with a time slice.
	 * 
	 * @param timeSlice Execution time slice.
	 */
	Processor(int timeSlice) {
		this.timeSlice = timeSlice;
	}
	
	/**
	 * Gives the processor a process to execute.
	 * 
	 * @param currProc Process given to the processor.
	 */
	void startUp(Process currProc) {
		this.currProc = currProc;
		clock = 0;
		busy = true;
	}
	
	/**
	 * Steps up the execution time by one unit.
	 */
	void stepTime() {
		if (!busy) {
			return;
		}
		clock++;
		if (clock == timeSlice || clock == currProc.execTime) { 
			// process has finished its allowed cycle
			clock = 0;
			busy = false;
		}
	}
	
	/**
	 * Tells whether this process is idle (free to execute a process) or not.
	 * 
	 * @return True if processor is idle, false otherwise.
	 */
	boolean isIdle() {
		return !busy;
	}
	
	/**
	 * Returns the process, if any, that finished its time time slice at this
	 * process, and has not been retrieved yet.
	 * 
	 * @return Process, if any, that just finished its time slice of execution at this 
	 * 			processor, null if no process.
	 * @throws BusyInterruptionException If this method is called when the processor is busy
	 * 			executing a process, i.e. the process' time slice is not yet done.
	 */
	Process getProcess()
	throws BusyInterruptionException {
		if (busy) { // busy executing, go away
			throw new BusyInterruptionException();
		}
		Process ret = currProc;
		currProc = null;
		return ret;
	}
	
	/**
	 * Returns the time on the time slice clock.
	 * 
	 * @return Time slice clock time.
	 */
	public int getClockTime() {
		return clock;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return currProc + "<" + clock + "," + timeSlice + ">";
	}
}





