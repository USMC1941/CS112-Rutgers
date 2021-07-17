package apps.graph;

import structures.graph.*;
import java.util.*;
import java.io.*;

/**
 * A driver for DFSTopsort.
 * 
 * @author Sesh Venugopal
 *
 */
public class DFSTopsortDriver {
	
	/**
	 * The graph on which topsort is to be done.
	 */
	static DirGraph<String> G;
	
	/**
	 * Reads a graph.
	 * 
	 * @throws IOException If there is an error in reading the graph.
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
	throws IOException {
		readGraph();
		DFSTopsort<String> DFSTop = new DFSTopsort<String>();
		
		DFSTop.init(G);
		
		int[] topSequence = DFSTop.sort();
		
		for (int i=0; i < topSequence.length; i++) {
			String vlabel = (String)G.vertexInfoOf(topSequence[i]);
			System.out.print("  " + vlabel);
		}
		System.out.println();
	}
}
