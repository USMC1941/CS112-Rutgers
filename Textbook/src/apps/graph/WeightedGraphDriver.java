package apps.graph;

import structures.graph.*;
import java.io.*;
import apps.graph.WeightedNeighbor;


/**
 * A simple driver application to exercise the directed graph class, DirGraph, with weights
 * on the edges.
 * 
 * @author Sesh Venugopal
 *
 */
public class WeightedGraphDriver {  
	
	/**
	 * All the actions that can be issued to the driver.
	 *
	 */
	public enum Action { addvert, addedge, dispverts, dispnbrs, 
						numverts, containsvert, containsedge, quit } 
	
	/**
	 * All the actions that can be issued to the driver.
	 *
	 */
	static BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * Undirected graph instance, using string labels for vertex information.
	 */
	static DirGraph<String> G = new DirGraph<String>();
	
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
			System.out.println("Choose one of the following actions:  ");
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
	 * Adds a vertex to the graph.
	 * 
	 * @throws IOException If there is error reading from terminal.
	 */
	static void addVert()
	throws IOException {
		System.out.print("Vertex label? => ");
		System.out.flush();
		String label = stdbr.readLine();
		G.addVertex(label);
	}  
	
	/**
	 * Adds a weighted edge to the graph.
	 * 
	 * @throws IOException If there is error reading from terminal.
	 */
	static void addEdge()
	throws IOException {
		System.out.print("From Vertex label? => ");
		System.out.flush();
		String flabel = stdbr.readLine();
		System.out.print("To Vertex label? => ");
		System.out.flush();
		String tlabel = stdbr.readLine();
		System.out.print("Weight => ");
		System.out.flush();
		int wt = Integer.parseInt(stdbr.readLine());
		G.addEdge(G.vertexNumberOf(flabel),
				new WeightedNeighbor(G.vertexNumberOf(tlabel), wt));
	}       
	
	/**
	 * Displays all vertices in the graph.
	 * 
	 * @throws IOException If there is error reading from terminal.
	 */
	static void displayVerts() {
		for (int v=0; v < G.numberOfVertices(); v++) {
			System.out.println(G.vertexInfoOf(v));
		}
	}  
	
	/**
	 * Displays all neighbors of a vertex in the graph.
	 * 
	 * @throws IOException If there is error reading from terminal.
	 */
	static void displayNbrs()
	throws IOException {
		System.out.print("Of Vertex? => ");
		System.out.flush();
		String flabel = stdbr.readLine();
		int v = G.vertexNumberOf(flabel);
		WeightedNeighbor nbr = (WeightedNeighbor)G.firstNeighbor(v);
		while (nbr != null) {
			System.out.println("(" + G.vertexInfoOf(nbr.vertexNumber) + 
					"," + nbr.weight + ")");
			nbr = (WeightedNeighbor)G.nextNeighbor(v);
		}    
	}
	
	/**
	 * Tells if the graph contains a vertex.
	 * 
	 * @throws IOException If there is error reading from terminal.
	 */
	static void containsVert()
	throws IOException {
		System.out.print("Vertex label? => ");
		System.out.flush();
		String label = stdbr.readLine();
		
		if (G.containsVertex(label)) {      
			System.out.println("contains vertex");
		}
		else {
			System.out.println("does not contain vertex");
		}
	} 
	
	/**
	 * Tells if the graph contains an edge.
	 * 
	 * @throws IOException If there is error reading from terminal.
	 */
	static void containsEdge()
	throws IOException {
		System.out.print("From Vertex label? => ");
		System.out.flush();
		String flabel = stdbr.readLine();
		System.out.print("To Vertex label? => ");
		System.out.flush();
		String tlabel = stdbr.readLine();
		
		int srcVert = G.vertexNumberOf(flabel);
		if (srcVert == -1) {
			System.out.println("Vertex " + flabel + " not in graph");
			return;
		}
		
		int destVert = G.vertexNumberOf(tlabel);
		if (destVert == -1) {
			System.out.println("Vertex " + tlabel + " not in graph");
			return;
		}
		
		if (G.containsEdge(srcVert, new WeightedNeighbor(destVert, 0))) {
			System.out.println("contains edge");
		}
		else {
			System.out.println("does not contain edge");
		}
	}       
	
	/**
	 * Entry point into the driver.
	 * 
	 * @param args No arguments required.
	 * @throws IOException If there is an error in reading from terminal.
	 */
	public static void main(String[] args)
	throws IOException {
		Action act;
		while ((act = getAction()) != Action.quit) {
			switch(act) {
			case addvert    : addVert();
			break;
			case addedge    : addEdge();
			break;
			case dispverts  : displayVerts();
			break;
			case dispnbrs  : displayNbrs();
			break;
			case numverts  : System.out.println("Number of vertices = " +
							G.numberOfVertices());
			break;
			case containsvert:containsVert();
			break; 
			case containsedge:containsEdge();
			break; 
			default         : break;
			}
		}
	}
}

