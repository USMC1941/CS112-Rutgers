package apps.linear.simulation;

/**
 * This class implements a registration window at which students will queue up for
 * registration.
 * 
 * @author Sesh Venugopal
 *
 */
class Register {
	
	/**
	 * Number of time intervals needed to register a student. 
	 */
	int duration;
	
	/**
	 * Registration clock that starts ticking when a student steps up to this window to
	 * register, and stops ticking (reset to zero) when registration of the student is completed. 
	 */
	int clock;
	
	/**
	 * Busy flag to tell if a student is currently at this registration window.
	 */
	boolean busy;
	
	/**
	 * Initializes a new instance with time taken to register a student.
	 * 
	 * @param timePerStudent Time taken to register a student.
	 */
	Register(int timePerStudent) {
		duration = timePerStudent;
		busy = false;
	}
	
	/**
	 * Starts up the registration process for a student, i.e. students steps up to this
	 * window. Sets the clock to zero and busy indicator to true.
	 */
	void startUp() {
		clock = 0;
		busy = true;
	}
	
	/**
	 * Steps up the time to the next interval. If the new time is equal to the duration
	 * of registration, the clock is reset to zero and the busy indicator is set to false, 
	 * i.e. the window is free. 
	 */
	void stepTime() {
		if (!busy) return;
		clock++;
		if (clock == duration) {
			// wrap the clock back to zero
			clock = 0;
			busy = false;
		}
	}
	
	/**
	 * Tells whether this window is free, i.e. available for registering the next student.
	 * 
	 * @return True if window is free, false otherwise.
	 */
	boolean isFree() {
		return !busy;
	}
	
	/**
	 * Returns the status of the clock, i.e. number of time intervals that have elapsed 
	 * since the current registration started.
	 * 
	 * @return Time elapsed since current registration started, zero if window if free.
	 */
	int getClock() {
		return clock;
	}
}
