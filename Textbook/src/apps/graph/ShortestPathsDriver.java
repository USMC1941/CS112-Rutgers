package apps.graph;

import structures.graph.*;
import structures.linear.Stack;

import java.util.Scanner;
import java.io.*;

/**
 * This class implements a driver for the shortest paths algorithm.
 * 
 * @author Sesh Venugopal
 *
 */
public class ShortestPathsDriver {
	
	/**
	 * All the actions that can be issued to the driver.
	 *
	 */
	public enum Action { runall, runsome, result, restart, quit };
	
	/**
	 * The source vertex.
	 */
	static String source;
	
	/**
	 * The destination vertex.
	 */
	static String dest;
	
	/**
	 * The path stack.
	 */
	static Stack pathStack;
	
	/**
	 * The shortest paths instance.
	 */
	static ShortestPaths<String> sp = new ShortestPaths<String>();
	
	/**
	 * The target directed graph.
	 */
	static DirGraph<String> G;
	
	/**
	 * The reader used to read user input from the terminal.
	 */
	static BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * Reads a directed graph from a file.
	 * 
	 * @param file File that contains a directed graph representation.
	 * @throws IOException If there is an error reading the graph.
	 */
	static void readGraph(String file)
	throws IOException {
		Scanner sc = new Scanner(new File(file));
		
		// read number of vertices
		int numVerts = sc.nextInt();
		
		// create and populate graph
		G = new DirGraph<String>(numVerts);
		
		int i;
		String vlabel1;
		
		// add all vertices
		for (i=0; i < numVerts; i++) {
			vlabel1 = sc.next();
			G.addVertex(vlabel1);
		}
		
		String vlabel2;
		// read number of edges
		int numEdges = sc.nextInt();
		for (i=0; i < numEdges; i++) {
			vlabel1 = sc.next();
			vlabel2 = sc.next();
			int weight = sc.nextInt();
			WeightedNeighbor nbr = 
				new WeightedNeighbor(G.vertexNumberOf(vlabel2), weight);
			G.addEdge(G.vertexNumberOf(vlabel1), nbr);
		}
	}
	
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
				System.out.print(act + "  ");
			}
			System.out.print("\n\tEnter action => ");
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
	 * Starts the algorithm. 
	 * 
	 * @param newFile True if a new graph is used, false if this is a restart on the
	 * 					current graph with a different source vertex.
	 * @throws IOException If there is an error reading from the terminal.
	 */
	static void start(boolean newFile)  
	throws IOException {
		if (newFile) {
			System.out.print("Enter the graph file name ==> ");
			System.out.flush();
			
			String file = stdbr.readLine();
			readGraph(file);
		}
		
		System.out.print("Enter the start vertex ==> ");
		System.out.flush();
		source = stdbr.readLine();      
		
		sp.init(G);
		sp.from(source);
	}
	
	/**
	 * Prints the shortest path and distance from current source vertex to a given
	 * destination vertex.
	 * 
	 * @throws IOException If there is an error in reading from the terminal.
	 */
	static void result()
	throws IOException {
		System.out.print("\tEnter the destination vertex ==> ");
		dest = stdbr.readLine();      
		int dist = sp.distTo(dest);
		if (dist == -1) {
			System.out.println("Vertex " + dest + " not in graph!");
			return;
		}
		Stack<String> pathStack = sp.pathTo(dest);
		
		if (pathStack == null) {
			System.out.println("There is no path from " + source + " to " + dest);
		}
		else {
			System.out.print("Shortest path: ");
			String vertex = pathStack.pop();
			System.out.print(vertex);
			while (!pathStack.isEmpty()) {
				vertex = pathStack.pop();
				System.out.print(" ---> " + vertex);
				
			}
			System.out.println();
			System.out.println("Distance     : " + dist);      
		}
	}
	
	/**
	 * Entry point for the driver.
	 * 
	 * @param args No arguments are accepted by the driver.
	 * @throws IOException If there is an error in reading from the terminal.
	 */
	public static void main(String[] args)
	throws IOException {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		start(true);
		sp.printStatus(pw);
		pw.flush();
		Action act;
		while ((act = getAction()) != Action.quit) {
			switch(act) {
			case runall     : sp.runAll();
			break;
			case runsome    : System.out.print("\tHow many steps? => ");
			System.out.flush();
			int howManySteps = 
				Integer.parseInt(stdbr.readLine());
			sp.runSome(howManySteps);
			sp.printStatus(pw);
			pw.flush();
			break;
			case result     : result();
			break;
			case restart    : System.out.print("New graph? (y/n) => ");
			System.out.flush();
			String answer = stdbr.readLine();
			char ans = answer.charAt(0);
			if (ans == 'y' || ans == 'Y') 
				start(true);
			else
				start(false);
			break;
			default         : break;
			}
		}
	}
}

