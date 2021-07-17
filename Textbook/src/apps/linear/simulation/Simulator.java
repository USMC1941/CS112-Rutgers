package apps.linear.simulation;

import structures.linear.Queue;
import java.io.PrintWriter;

/**
 * This class implements a registration simulator, in which students queue up
 * at a registration window to register for classes. Each student is labeled with
 * the time of the student's arrival in the registration queue. The simulation
 * can be run in a sequence of slices, and the status can be observed at the end
 * of every slice.
 * 
 * @author Sesh Venugopal
 *
 */
public class Simulator {
	
	/**
	 * Source that simulates student arrivals.
	 */
	StudentSource source;
	
	/**
	 * Registration window simulator.
	 */
	Register window;
	
	/**
	 * Queue of students, in which each student is labeled with the time of the student's arrival.
	 * The queue is maintained in a generic Queue instantiated with the Integer type.
	 */
	Queue<Integer> studentQ;
	
	/**
	 * The clock that keeps total simulation time.
	 */
	int clock;
	
	/**
	 * The clock that keeps time for current simulation slice.
	 */
	int intervalClock;
	
	/**
	 * Number of students who arrived to register since the start of the simulation.
	 */
	int numStudents;
	
	/**
	 * Number of students who arrived to register in the current simulation slice.
	 */
	/**
	 * 
	 */
	int intervalNumStudents;
	
	/**
	 * Number of students who have been registered for the duration of the simulation.
	 */
	int registered;
	
	/**
	 * Number of students who registered in current slice of simulation.
	 */
	int intervalRegistered;
	
	/**
	 * Total time spent in queue by all students who registered since start of simulation.
	 */
	int waitTime;
	
	/**
	 * Time spent in queue by all students who registered in current slice of simulation.
	 */
	int intervalWaitTime;
	
	/**
	 * Arrival time of student who is currently being registered at the window.
	 */
	int activeArrivalTime; 
	
	/**
	 * Initializes a new Simulator instance with an empty registration queue.
	 */
	public Simulator() {
		// create new registration queue object
		studentQ = new Queue<Integer>();
	}
	
	/**
	 * Primes this simulator with a probability of arrival of students, and a registration time.
	 * 
	 * @param probOfArrival Probability of arrival of a student in the next time interval.
	 * @param timeToRegister Time required to register a student.
	 */
	public void init(float probOfArrival, int timeToRegister) {
		// create new student source and register objects
		source = new StudentSource(probOfArrival);
		window = new Register(timeToRegister);
		clock = 0;
		numStudents = 0;
		// clear out registration queue
		studentQ.clear();
		registered = 0;
		waitTime = 0;
	}
	
	/**
	 * Runs the simulation for a given time interval of interest, and then pauses
	 * the simulation for examination of status.
	 * 
	 * @param howLong Time interval for which simulation should be run.
	 */
	public void run(int howLong) {
		intervalClock = 0;
		intervalNumStudents = 0;
		intervalWaitTime = 0;
		intervalRegistered = 0;
		
		while (intervalClock < howLong) {
			// iterate for specified time intervals
			// has a new student arrived?
			if (source.studentArrived()) {
				studentQ.enqueue(clock);
				intervalNumStudents++;
				numStudents++;
			}
			
			// if window is free, register the student at front of queue
			if (window.isFree()) {
				if (!studentQ.isEmpty()) {
					activeArrivalTime = studentQ.dequeue();
					intervalWaitTime += clock - activeArrivalTime;
					waitTime += clock - activeArrivalTime;
					registered++;
					intervalRegistered++;
					window.startUp();
				}
			}
			
			// step up the time
			clock++;
			intervalClock++;
			window.stepTime();
		}
	}
	
	/**
	 * Prints the status of the simulator including various statistics.
	 * 
	 * @param pw PrintWriter used to print status.
	 */
	public void printStatus(PrintWriter pw) {
		pw.println();
		pw.print("                        ");
		pw.println(" Interval   Cumulative");
		pw.print("                        ");
		pw.println(" --------   ----------");
		pw.println();
		pw.println("   Students Arrived         " + intervalNumStudents +
				"           " + numStudents);
		pw.println("   Students Registered      " + intervalRegistered +
				"           " + registered);
		int intervalAverage=0, cumAverage=0;
		if (intervalNumStudents != 0) {
			// average waiting time for interval
			intervalAverage = intervalWaitTime / intervalRegistered;
		}
		
		if (numStudents != 0) {
			// cumulative average waiting time over all intervals
			cumAverage = waitTime / registered;
		}
		
		pw.println("   Average Wait Time        " + intervalAverage +
				"           " + cumAverage);
	}
	
	/**
	 * Prints a snapshot of the simulation showing students in the queue (if any), student
	 * at the registration window (if any), regisration clock, and simulation clock.
	 * 
	 * @param pw PrintWriter used to print snapshot.
	 */
	public void printSnapshot(PrintWriter pw) {
		pw.println();
		pw.println("   -------------------------------");
		pw.print("   Registration Clock : " + window.getClock());
		pw.print("             ");
		pw.println("Simulation Clock: " + clock);
		pw.println();
		pw.println();
		
		pw.println("   WINDOW ");
		
		if (!window.isFree()) {
			int printTime = activeArrivalTime + 1;
			pw.print("  |   " + printTime + "  |   ");
		}
		
		// students waiting in line
		Integer arrivalTime = studentQ.first();
		while (arrivalTime != null) {
			int printTime = arrivalTime + 1;
			pw.print("  |   " + printTime + "  |   ");
			arrivalTime = studentQ.next();
		}
		pw.println();
		
		pw.println("   -------------------------------");
		pw.println();
	}
}
