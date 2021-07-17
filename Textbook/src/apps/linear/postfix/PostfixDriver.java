package apps.linear.postfix;

import java.io.*;

/**
 * Postfix evaluation driver.
 * 
 * @author Sesh Venugopal
 *
 */
public class PostfixDriver {
	
	/**
	 * List of commands that may be issued to the driver.
	 *
	 */
	public enum Command { runall, runsome, restart, quit }
	
	/**
	 * BufferedReader used to read commands from terminal.
	 */
	static BufferedReader stdbr = 
		new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Postfix evaluator instance. 
	 */
	static PostfixEvaluator myEvaluator = new PostfixEvaluator();
	
	/**
	 * Gets the next driver command issued at the terminal. 
	 * 
	 * @return Next command. If there are three erroneous attempts, the quit command is returned.
	 * @throws IOException If there is an i/o error in reading the next command.
	 */
	static Command getCommand()
	throws IOException {
		int tries=3;
		while (tries > 0) {
			System.out.println();
			System.out.print("Choose one of the following commands:   ");
			for (Command cmd : Command.values()) {
				System.out.print(cmd + "    ");
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
	 * Starts the evaluation.
	 * 
	 * @throws IOException If there is an i/o error in reading the postfix expression.
	 */
	static void startEval()  
	throws IOException {
		System.out.println("Enter the postfix expression below");
		System.out.print("   ==> ");
		System.out.flush();
		
		String expr = stdbr.readLine();
		myEvaluator.init(expr);
	}
	
	/**
	 * Entry point into the driver.
	 * 
	 * @param args No arguments are required.
	 * @throws IOException If there is any i/o error in the evaluation process.
	 * @throws IllegalExpressionException If the given expression is not legal postfix.
	 */
	public static void main(String[] args)
	throws IOException, IllegalExpressionException  {
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		startEval();
		
		Command cmd;
		while ((cmd = getCommand()) != Command.quit) {
			switch(cmd) {
			case runall     : float result = myEvaluator.runAll(pw);
			System.out.println(String.format("     Result => %.2f", result));
			break;
			case runsome    : System.out.print("Evaluate how many steps? => ");
			System.out.flush();
			int howManySteps = 
				Integer.parseInt(stdbr.readLine());
			myEvaluator.runSome(howManySteps,pw);
			myEvaluator.printStatus(pw);
			pw.flush();
			break;
			case restart    : startEval();
			break;
			default         : break;
			}
		}
		pw.close();
	}
}
