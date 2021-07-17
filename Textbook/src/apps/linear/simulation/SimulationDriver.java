package apps.linear.simulation;

import java.io.*;

/**
 * Simulation driver.
 * 
 * @author Sesh Venugopal
 *
 */
public class SimulationDriver {
	
	/**
	 * List of commands that may be issued to the simulator.
	 *
	 */
	enum Command { run, restart, quit }   
	
	/**
	 * BufferedReader used to read commands from terminal.
	 */
	static final BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * The simulator object.
	 */
	static Simulator registration;
	
	/**
	 * Gets the next simulation command issued at the terminal. 
	 * 
	 * @return Next command. If there are three erroneous attempts, the quit command is returned.
	 * @throws IOException If there is an i/o error in reading the next command.
	 */
	static Command getCommand()
	throws IOException  {
		int tries=3;
		while (tries > 0) {
			System.out.println();
			System.out.print("Choose one of the following commands:\t");
			for (Command cmd : Command.values()) {
				System.out.print(cmd + "\t");
			}
			System.out.print("\n  Enter command => ");
			System.out.flush();
			
			String choice = stdbr.readLine();
			for (Command cmd : Command.values()) {
				if (choice.trim().equals(cmd.name())) {
					return cmd;
				}
			}
			System.out.println("  Incorrect input, try again");
			tries--;
		}
		return Command.quit;
	}
	
	/**
	 * Starts the simulation based on parameters given.
	 * 
	 * @throws IOException If there is any i/o error when reading simulation parameters.
	 * @throws NumberFormatException If there is a numeric error in input.
	 */
	static void startSimul()
	throws IOException, NumberFormatException {
		System.out.print("Please enter probability of student arrivals => ");
		System.out.flush();
		float probArrival = Float.valueOf(stdbr.readLine()).floatValue();
		
		while (probArrival <= 0 || probArrival > 1) {
			System.out.print("Acceptable values: 0 (exclusive) thru 1 => ");
			System.out.flush();
			probArrival = Float.valueOf(stdbr.readLine()).floatValue();   
		}
		
		System.out.print("Please enter time to register one student => ");
		System.out.flush();
		int registDuration = Integer.parseInt(stdbr.readLine());
		
		registration.init(probArrival, registDuration);
	}
	
	/**
	 * Entry point into the simulation driver.
	 * 
	 * @param args No arguments are required.
	 * @throws IOException If there is any i/o error in running the simulation.
	 * @throws NumberFormatException If there is a numeric format error.
	 */
	public static void main(String[] args)
	throws IOException, NumberFormatException  {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		System.out.println("WELCOME TO REGISTRATION SIMULATION");
		System.out.println(); 
		
		registration = new Simulator();
		startSimul();
		
		Command cmd;
		while ((cmd = getCommand()) != Command.quit) {
			switch(cmd) {
			case run        : System.out.print("Run for how long? => ");
			System.out.flush();
			int howLong = 
				Integer.parseInt(stdbr.readLine());
			registration.run(howLong);
			registration.printSnapshot(pw);
			registration.printStatus(pw);
			pw.flush();
			break;
			case restart    : startSimul();
			break;
			default         : break;
			}
		}
		pw.close();
	}
}
