package apps.graph;

import structures.graph.DirGraph;
import structures.graph.Neighbor;

/**
 * This class implements depth-first traversal, with the flexibility to perform
 * an action at a vertex either in the forward motion (preAction) or just when
 * backing out of the vertex after examining and recursively traversing out of
 * all its neighbors (postAction).
 * 
 * A Visitor instance is supplied by the client to implement application-specific
 * actions.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> Type of vertex objects.
 */
public class DFS<T> {
	
	/**
	 * Target directed graph.
	 */
	protected DirGraph<T> G;
	
	/**
	 * Visitor that will be called when a vertex is visited.
	 */
	protected Visitor<T> V;
	
	/**
	 * Initializes this DFS instance with a target graph on which DFS
	 * is to be performed, and a visitor instance.
	 * 
	 * @param G Target graph.
	 * @param V Visitor.
	 */
	public void init(DirGraph<T> G, Visitor<T> V) {
		this.G = G;
		this.V = V;
	}
	
	/**
	 * Performs "preorder" recursive traversal.
	 * 
	 * @param startVertex Start vertex.
	 */
	public void preAction(int startVertex) {
		int numverts = G.numberOfVertices();
		// start up preorder recursive traversal process
		preTraverse(startVertex);
	}
	
	/**
	 * Performs a recursive "preorder" traversal.
	 * 
	 * @param vertex Current vertex out of which traversal is being done.
	 */
	protected void preTraverse(int vertex) {
		V.visit(vertex);
		V.action(vertex);
		
		Neighbor nbr = G.firstNeighbor(vertex);
		while (nbr != null) {
			if (!V.isVisited(nbr.vertexNumber)) {
				preTraverse(nbr.vertexNumber);
			}
			nbr = G.nextNeighbor(vertex);
		}
	}
	
	/**
	 * Performs "preorder" recursive traversal.
	 * 
	 * @param startVertex Start vertex.
	 */
	public void postAction(int startVertex) {
		int numverts = G.numberOfVertices();
		// start up recursive postorder traversal process
		postTraverse(startVertex);
	}
	
	/**
	 * Performs a recursive "preorder" traversal.
	 * 
	 * @param vertex Current vertex out of which traversal is being done.
	 */
	protected void postTraverse(int vertex) {
		V.visit(vertex);
		
		Neighbor nbr = G.firstNeighbor(vertex);
		while (nbr != null) {
			if (!V.isVisited(nbr.vertexNumber)) {
				postTraverse(nbr.vertexNumber);
			}
			nbr = G.nextNeighbor(vertex);
		}
		V.action(vertex);
	}
}
