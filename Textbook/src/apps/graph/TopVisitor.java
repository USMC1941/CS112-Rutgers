package apps.graph;

import structures.graph.DirGraph;

/**
 * This class implements a specialized visitor that is used for toplogical sorting
 * of a directed acyclic graph (DAG). It subclasses the Visitor class and overrides
 * the action() method to label a vertex with its topological number.
 * 
 * 
 * @author Sesh Venugopal
 *
 * @param <T> Type of vertex objects.
 */
public class TopVisitor<T> extends Visitor<T> {
	
	/**
	 * Array that maintains the topological ordering of vertices.
	 */
	protected int[] topSequence;
	
	/**
	 * Current topological number to be assigned.
	 */
	protected int topnum;
	
	/**
	 * Initializes this visitor with an array to hold topological sequence generated.
	 * If a vertex v has topnum i, then topSequence[i] = v.
	 * 
	 * @param topSequence Array to hold topological sequence.
	 */
	public TopVisitor(int[] topSequence) {
		super();
		this.topSequence = topSequence;
	}
	
	/* (non-Javadoc)
	 * @see apps.graph.Visitor#init(structures.graph.DirGraph)
	 */
	public void init(DirGraph<T> G) {
		super.init(G);
		topnum = numverts-1;
	}
	
	/* (non-Javadoc)
	 * @see apps.graph.Visitor#action(int)
	 */
	public void action(int vertex) {
		// assign this vertex to current topnum spot in topSequence
		topSequence[topnum--] = vertex;
	}
}
