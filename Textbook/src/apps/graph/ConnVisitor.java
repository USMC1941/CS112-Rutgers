package apps.graph;

import structures.graph.UndirGraph;

/**
 * This class implements a specialized visitor that is used for finding connected components
 * of an undirected graph. It subclasses the Visitor class and overrides
 * the action() method to label a vertex with its connected component number.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> Type of vertex objects.
 */
public class ConnVisitor<T> extends Visitor<T> {
	
	/**
	 * Array that maintains the component numbers of vertices.
	 */
	int[] componentNumbers;
	
	/**
	 * Current component number to be assigned.
	 */
	int compNum;
	
	/**
	 * Initializes a new instance.
	 */
	public ConnVisitor() {
		super();
	}
	
	/**
	 * Sets up this instance with a target undirected graph.
	 * 
	 * @param G Target undirected graph.
	 */
	public void init(UndirGraph<T> G) {
		super.init(G);
	}
	
	/**
	 * Sets up this instance with an array to be used to fill in the component numbers.
	 * 
	 * @param componentNumbers Component numbers array.
	 */
	public void initComp(int[] componentNumbers) {
		this.componentNumbers = componentNumbers;
		compNum = 0;
	}
	
	/**
	 * Hook for connected components driver to update component number when a new
	 * component is entered fortraversal.
	 */
	public void updateComp() {
		compNum++;
	}
	
	/* (non-Javadoc)
	 * @see apps.graph.Visitor#action(int)
	 */
	public void action(int vertex) {
		// assign this vertex to current topnum spot in topSequence
		componentNumbers[vertex] = compNum;
	}
}
