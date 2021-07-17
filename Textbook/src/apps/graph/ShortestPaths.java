package apps.graph;

import structures.graph.DirGraph;
import structures.linear.List;
import structures.linear.Stack;
import java.io.PrintWriter;

/**
 * This class implements the Dijkstra's single-source shortest paths algorithm,
 * on a directed graph with positive edge weights. The algorithm can be run
 * with any source vertex. After the algorithm terminates on a specified source,
 * the shortest distance/path can be queried for any destination vertex.
 * 
 * This is a reference implementation that uses a simple list to store fringe
 * vertices. A more efficient implementation should use an updatable heap for the fringe,
 * i.e. a heap that supports insert, delete, and update operations in O(log n) time.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of vertex objects.
 */
public class ShortestPaths<T> {
	
	/**
	 * The weighted directed graph on which shortest paths are to be computed.
	 */
	DirGraph<T> G;
	
	/**
	 * Number of vertices in the graph.
	 */
	int numverts;
	
	/**
	 * The current starting (source) vertex number.
	 */
	int sourceNum;
	
	/**
	 * The current ending (destination) vertex number.
	 */
	int destNum;
	
	/**
	 * The simple list that stores the fringe vertices.
	 */
	List<WeightedNeighbor> fringe;
	
	/**
	 * The current distances of all vertices from the source vertex. 
	 */
	int Distance[];
	
	/**
	 * The set of previous vertices for the vertices that are done or in the fringe.
	 */
	int Previous[];
	
	/**
	 * The set of vertices that are done, i.e. for which shortest distances have been found.
	 */
	boolean Done[];
	
	/**
	 * Initializes the algorithm by setting up all data structures and parameters.
	 * 
	 * @param G The target weighted directed graph.
	 */
	public void init(DirGraph<T> G) {
		this.G = G;
		numverts = G.numberOfVertices();
		
		// create all data structures
		fringe = new List<WeightedNeighbor>();
		Distance = new int[numverts];
		Previous = new int[numverts];
		Done = new boolean[numverts];
	}
	
	/**
	 * Sets up the source vertex for a run of the algorithm.
	 * 
	 * @param sourceVertex Source vertex.
	 */
	public void from(T sourceVertex) {
		sourceNum = G.vertexNumberOf(sourceVertex);
		
		// initialize all data structures
		for (int i=0; i < numverts; i++) {
			Done[i] = false;
			Distance[i] = Integer.MAX_VALUE;
			Previous[i] = i;
		}
		fringe.clear();
		
		// do steps 1,2,3
		Done[sourceNum] = true;
		Distance[sourceNum] = 0;
		
		WeightedNeighbor nbr = (WeightedNeighbor)G.firstNeighbor(sourceNum);
		while (nbr != null) {
			int w = nbr.vertexNumber;
			Distance[w] = nbr.weight;
			Previous[w] = sourceNum;
			fringe.add(nbr);
			nbr = (WeightedNeighbor)G.nextNeighbor(sourceNum);
		}
	}
	
	/**
	 * Deletes the minimum distance vertex from the fringe.
	 * 
	 * @return The minimum-distance vertex number.
	 */
	int fringeDeleteMin() {
		int minWeight = Integer.MAX_VALUE;
		int minVertex = -1;
		WeightedNeighbor minnbr=null;
		
		WeightedNeighbor nbr = (WeightedNeighbor)fringe.first();
		while (nbr != null) {
			int w = nbr.vertexNumber;
			if (Distance[w] < minWeight) {
				minWeight = Distance[w];
				minVertex = w;
				minnbr = nbr;
			}
			nbr = (WeightedNeighbor)fringe.next();
		}
		fringe.remove(minnbr);
		return minVertex;
	}
	
	/**
	 * Runs the algorithm to completion for the current source vertex.
	 */
	public void runAll() {
		runSome(numverts-1);
	}
	
	/**
	 * Runs the algorithm for a specified number of steps--each step stands for
	 * one vertex pick from the fringe.
	 * 
	 * @param howManySteps Number of steps.
	 */
	public void runSome(int howManySteps) {
		int step=0;
		while (step < howManySteps) {
			if (fringe.isEmpty()) break;
			
			int minVertex = fringeDeleteMin();
			
			Done[minVertex] = true;
			
			WeightedNeighbor nbr = (WeightedNeighbor)G.firstNeighbor(minVertex);
			while (nbr != null) {
				int w = nbr.vertexNumber;
				if (Distance[w] == Integer.MAX_VALUE) {
					Distance[w] = Distance[minVertex] + nbr.weight;
					Previous[w] = minVertex;
					fringe.add(nbr);
				} else if (Distance[w] > (Distance[minVertex] + nbr.weight)) {
					Distance[w] = Distance[minVertex] + nbr.weight;
					Previous[w] = minVertex;
				}
				nbr = (WeightedNeighbor)G.nextNeighbor(minVertex);
			}
			step++;
		}
	}
	
	/**
	 * Returns the shortest distance from the current source vertex to a specified 
	 * destination vertex.
	 * 
	 * @param destVertex Destination vertex.
	 * @return Shortest distance to destination vertex.
	 */
	public int distTo(T destVertex) {
		destNum = G.vertexNumberOf(destVertex);
		if (destNum == -1) {
			return -1;
		}
		return Distance[destNum];
	}
	
	/**
	 * Returns a stack that contains the path from the current source vertex to a
	 * specified destination vertex.
	 *  
	 * @param destVertex Destination vertex.
	 * @return Path stack in which the source vertex is at the top and 
	 * 			the destination vertex is at the bottom.
	 */
	public Stack<T> pathTo(T destVertex) {
		destNum = G.vertexNumberOf(destVertex);
		
		if (Distance[destNum] == Integer.MAX_VALUE) {
			return null;
		}
		
		Stack<T> pathStack = new Stack<T>();
		pathStack.push(destVertex);
		
		int prev = destNum;
		do {
			prev = Previous[prev];
			pathStack.push(G.vertexInfoOf(prev));
		} while (prev != sourceNum);
		
		return pathStack;
	}
	
	/**
	 * Prints the current status of the execution of the algorithm.
	 * 
	 * @param pw PrintWriter used to print the status. 
	 */
	public void printStatus(PrintWriter pw) {
		pw.println();
		pw.print("DONE:\t");
		for (int i=0; i < numverts; i++) {
			if (Done[i]) {
				pw.print("(" + G.vertexInfoOf(i) + "," +
						G.vertexInfoOf(Previous[i]) + "," +
						Distance[i] + ") ");
			}
		}
		
		pw.print("\n\nFRINGE:\t");
		for (int i=0; i < numverts; i++) {
			if (!Done[i] && (Distance[i] != Integer.MAX_VALUE)) {
				pw.print("(" + G.vertexInfoOf(i) + "," +
						G.vertexInfoOf(Previous[i]) + "," +
						Distance[i] + ") ");
			}
		}
		pw.println();
	}
}


