package apps.linear.unixPrinter;

import java.io.*;

/**
 * This class drives the print queue.
 * 
 * @author Sesh Venugopal
 *
 */
class PrintQueueDriver {
	
	/**
	 * An enumerated list of commands that can be issued on a print queue.
	 *
	 */
	public enum Command { lpr, lpq, lprmid, lprmactive, lprmall, quit }
	
	/**
	 * BufferedReader to read commands issues at terminal.
	 */
	static final BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * Print queue instance that is driven.
	 */
	static PrintQueue myQ = new PrintQueue();
	
	/**
	 * PrintWriter instance using which listings from the print queue are written to
	 * terminal. 
	 */
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	/**
	 * Gets the command issued at terminal. If the command is still incorrect after
	 * three tries, returns the quit command.
	 * 
	 * @return Command issued at terminal, quit if three erroneous attempts.
	 * @throws IOException if there is an i/o error in reading the issued command.
	 */
	static Command getCommand()
	throws IOException {
		int tries=3;
		while (tries > 0) {
			System.out.println();
			System.out.println("Choose one of the following commands:  ");
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
	 * Queues a job at the print queue.
	 * 
	 * @throws IOException If there is an i/o error in reading job parameters.
	 */
	static void lpr()
	throws IOException {
		System.out.print("Owner Name? => ");
		System.out.flush();
		String owner = stdbr.readLine();
		
		System.out.print("Job Id? => ");
		System.out.flush();
		int id = Integer.parseInt(stdbr.readLine());
		
		System.out.print("File Name? => ");
		System.out.flush();
		String file = stdbr.readLine();
		
		myQ.lpr(owner, id, file);
	}
	
	/**
	 * Lists the jobs in the print queue.
	 * 
	 * @throws IOException If there is an i/o error in listing the jobs.
	 */
	static void lpq()
	throws IOException {
		myQ.lpq(pw);
		pw.flush();
	}
	
	/**
	 * Removes a job in the print queue that matches an owner name and an id.
	 * 
	 * @throws IOException If there is an i/o error in reading the name and id.
	 * @throws NoSuchElementException If there is no matching ob in the print queue.
	 */
	static void lprmid()
	throws IOException {
		System.out.print("Job Id? => ");
		System.out.flush();
		int id = Integer.parseInt(stdbr.readLine());
		
		System.out.print("Owner Name? => ");
		System.out.flush();
		String owner = stdbr.readLine();
		
		myQ.lprm(owner, id);
	}
	
	/**
	 * Removes the job at the front of his printer queue, provided its owner name
	 * matches a given owner name. 
	 * 
	 * @throws IOException If there is an i/o error in reading the job owner name.
	 * @throws NoSuchElementException If the job at the front does not have a matching owner name to
	 *                                given owner name, or if this queue is empty.
	 */
	static void lprmactive()
	throws IOException {
		System.out.print("Owner Name? => ");
		System.out.flush();
		String owner = stdbr.readLine();
		
		myQ.lprm(owner);
	}
	
	/**
	 * Removes the job at the front of his printer queue, provided its owner name
	 * matches the given owner name. 
	 * 
	 * @throws IOException If there is an error in reading the owner name.
	 * @throws NoSuchElementException If there is no matching job, or if this queue is empty.
	 */
	static void lprmall()
	throws IOException {
		System.out.print("Owner Name? => ");
		System.out.flush();
		String owner = stdbr.readLine();
		
		myQ.lprm(owner);
	}
	
	/**
	 * The entry point into this driver.
	 * 
	 * @param args No arguments are required.
	 * @throws IOException If there is any i/o error.
	 * @throws NoSuchElementException If a job is sought that does not exist in the print queue.
	 */
	public static void main(String[] args)
	throws IOException {
		Command cmd;
		while ((cmd = getCommand()) != Command.quit) {
			switch(cmd) {
			case lpr        : lpr();
			break;
			case lpq        : lpq();
			break;
			case lprmid     : lprmid();
			break;
			case lprmactive : lprmactive();
			break;
			case lprmall    : lprmall();
			break;
			default         : break;
			}
		}
	}
}
