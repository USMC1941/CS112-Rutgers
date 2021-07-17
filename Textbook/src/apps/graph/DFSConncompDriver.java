package apps.graph;

import structures.graph.*;

import java.util.*;
import java.io.*;

/**
 * Driver for DFSConncomp
 * 
 * @author Sesh Venugopal
 *
 */
public class DFSConncompDriver {
	
	/**
	 * Graph on which DFSConncomp is to be executed.
	 */
	static UndirGraph<String> G;
	
	/**
	 * Reads a graph.
	 * 
	 * @throws IOException If there is an error in reading the graph
	 */
	static void readGraph()
	throws IOException {
		
		BufferedReader stdbr = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.print("Enter name of input graph file => ");
		Scanner sc = new Scanner(new File(stdbr.readLine()));
		
		// read number of vertices
		int numVerts = sc.nextInt();
		
		// create and populate graph
		G = new UndirGraph<String>(numVerts);
		
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
			Neighbor nbr = new Neighbor(G.vertexNumberOf(vlabel2));
			G.addEdge(G.vertexNumberOf(vlabel1), nbr);
		}
	}
	
	/**
	 * Entry point into the driver.
	 * 
	 * @param args No arguments needed
	 * @throws IOException If there is any I/O error
	 */
	static public void main(String[] args)
	throws IOException
	{
		readGraph();
		DFSConncomp<String> DFSConn = new DFSConncomp<String>();
		
		DFSConn.init(G);
		
		int[] componentNumbers = DFSConn.findComponents();
		
		for (int i=0; i < componentNumbers.length; i++) {
			String vlabel = (String)G.vertexInfoOf(i);
			System.out.println("  " + vlabel + " " + componentNumbers[i]);
		}
		System.out.println();
	}
}
