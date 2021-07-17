package apps.graph;

import structures.graph.UndirGraph;

/**
 * This class implements a DFS-based connected components algorithm on an undirected gaph.
 * 
 * @author Sesh Venugopal
 *
 */
public class DFSConncomp<T> {
	
	/**
	 * Target undirected graph.
	 */
	protected UndirGraph<T> G;
	
	/**
	 * Components numbers of vertices.
	 */
	protected int[] componentNumbers;
	
	/**
	 * Specialized visitor.
	 */
	protected ConnVisitor<T> V;
	
	/**
	 * Initializes this instance with a target graph for which connected components
	 * are to be found.
	 * 
	 * @param G Target graph.
	 */
	public void init(UndirGraph<T> G) {
		this.G = G;
		componentNumbers = new int[G.numberOfVertices()];
		V = new ConnVisitor<T>();
		V.init(G);
		V.initComp(componentNumbers);
	}
	
	/**
	 * Performs the core components finding process.
	 * 
	 * @return The components numbers for all vertices.
	 */
	public int[] findComponents() {
		DFS<T> DFStraverse = new DFS<T>();
		
		DFStraverse.init(G, V);
		
		while (V.hasMoreToVisit()) {
			int vertex = V.nextToBeVisited();
			DFStraverse.postAction(vertex);
			V.updateComp();
		}
		return componentNumbers;
	}
}
