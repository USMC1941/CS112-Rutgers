package apps.tree.scheduling;

import java.io.*;

/**
 * Drives the scheduling simulation.
 * 
 * @author Sesh Venugopal
 *
 */
public class ScheduleDriver {
	
	/**
	 * All the actions that can be issued to the driver.
	 *
	 */
	public enum Action { run, restart, quit }
	
	/**
	 * Reader to read actions from terminal.
	 */
	static final BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * The scheduler instance that coordinates all scheduling activities.
	 */
	static Scheduler myScheduler;
	
	/**
	 * Gets the next action issued at the terminal.
	 * 
	 * @return Action issued at terminal. If three incorrect attempts are made,
	 * returns quit.
	 * @throws IOException If there is an error in reading the action.
	 */
	static Action getAction()
	throws IOException {
		
		int tries=3;
		while (tries > 0) {
			System.out.println();
			System.out.print("Choose one of the following actions:  ");
			for (Action act : Action.values()) {
				System.out.print(act+ "   ");
			}
			System.out.print("\n  Enter action => ");
			System.out.flush();
			
			String choice = stdbr.readLine();
			for (Action act : Action.values()) {
				if (choice.trim().equals(act.name())) {
					return act;
				}
			}
			System.out.println("  Incorrect input, try again");
			tries--;
		}
		return Action.quit;
	}
	
	/**
	 * Starts or restarts the simulation from scratch.
	 * 
	 * @throws IOException If there is an error reading input from terminal.
	 */
	static void startSimul()
	throws IOException {
		System.out.print("Please enter probability of process arrivals => ");
		System.out.flush();
		float probArrival = Float.valueOf(stdbr.readLine()).floatValue();
		
		while (probArrival <= 0 || probArrival > 1) {
			System.out.print("Acceptable values: 0 (exclusive) thru 1 => ");
			System.out.flush();
			probArrival = Float.valueOf(stdbr.readLine()).floatValue();   
		}
		
		System.out.print("Please enter processor time slice => ");
		System.out.flush();
		int timeSlice = Integer.parseInt(stdbr.readLine());
		
		System.out.print("Please enter maximum process execution time => ");
		System.out.flush();
		int maxExecTime = Integer.parseInt(stdbr.readLine());
		
		System.out.print("Please enter maximum process priority => ");
		System.out.flush();
		int maxPriority = Integer.parseInt(stdbr.readLine());
		
		myScheduler.init(probArrival, maxExecTime, maxPriority,
				timeSlice);
	}
	
	/**
	 * Displays status of the simulation system.
	 * 
	 * @param pw PrintWriter used to print status. 
	 */
	static void display(PrintWriter pw)
	throws IOException {
		pw.println();
		myScheduler.printStatus(pw);
		myScheduler.printProcessor(pw);
		myScheduler.printHeap(pw);
	}
	
	/**
	 * Entry point into the driver.
	 * 
	 * @param argv No arguments required.
	 * @throws IOException If there is an input error from terminal.
	 * @throws BusyInterruptionException If the processor is interrupted when it is busy
	 * 									executing a process.
	 */
	public static void main(String[] argv)
	throws IOException, BusyInterruptionException  {
		System.out.println("WELCOME TO PROCESS SCHEDULING SIMULATION");
		System.out.println(); 
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		myScheduler = new Scheduler();
		startSimul();
		
		Action act;
		while ((act = getAction()) != Action.quit) {
			switch(act) {
			case run       : System.out.print("Run for how long? => ");
							System.out.flush();
							int howLong = Integer.parseInt(stdbr.readLine());
							myScheduler.run(howLong);
							display(pw);
							break;
			case restart   : startSimul();
							break;
			default        : break;
			}
		}
	}
}
