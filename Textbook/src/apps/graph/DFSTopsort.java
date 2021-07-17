package apps.graph;

import structures.graph.DirGraph;

/**
 * This class implements a DFS-based topological sort on a directed acyclic
 * graph (DAG).
 * 
 * @author Sesh Venugopal
 *
 */
public class DFSTopsort<T> {
	
	/**
	 * Target graph.
	 */
	protected DirGraph<T> G;
	
	/**
	 * Topological sequence.
	 */
	protected int[] topSequence;
	
	/**
	 * Specialized visitor.
	 */
	protected TopVisitor<T> V;
	
	/**
	 * Initializes this instance with a target graph on which topological sort
	 * is to be performed.
	 * 
	 * @param G Target graph.
	 */
	public void init(DirGraph<T> G) {
		this.G = G;
		topSequence = new int[G.numberOfVertices()];
		V = new TopVisitor<T>(topSequence);
		V.init(G);
	}
	
	/**
	 * Performs a topological sort.
	 * 
	 * @return The topological sequence, t, such that t[i] = v means vertex v
	 *         is at position i of the sequence. 
	 */
	public int[] sort() {
		DFS<T> DFStraverse = new DFS<T>();
		
		DFStraverse.init(G, V);
		
		while (V.hasMoreToVisit()) {
			int vertex = V.nextToBeVisited();
			DFStraverse.postAction(vertex);
		}
		
		return topSequence;
	}
}

