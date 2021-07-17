package apps.graph;

import structures.graph.DirGraph;

/**
 * This class implements a visitor to used in directed graph traversals.
 * It may be subclassed to implement application-specific actions when vertices
 * are visited.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> Type of vertex objects stored in the graph to be visited.
 */
public class Visitor<T> {
	
	/**
	 * Array to mark vertices when they are visited.
	 */
	protected boolean[] visited;
	
	/**
	 * Directed graph that is the target of this visitor.
	 */
	protected DirGraph<T> G;
	
	/**
	 * Number of vertices in the target graph.
	 */
	protected int numverts;
	
	/**
	 * Lowest vertex number of not yet visited vertices.
	 */
	protected int unvisitedIndex;
	
	/**
	 * Initializes this visitor with a target directed graph.
	 * 
	 * @param G Target directed graph on which visits are done.
	 */
	public void init(DirGraph<T> G) {
		this.G = G;
		numverts = G.numberOfVertices();
		visited = new boolean[numverts];
		for (int i=0; i < numverts; i++) {
			visited[i] = false;
		}
		unvisitedIndex = 0;
	}
	
	/**
	 * Tells whether a given vertex has been visited or not.
	 * 
	 * @param vertex Vertex number.
	 * @return True if vertex has been visited, false otherwise.
	 */
	public boolean isVisited(int vertex) {
		return visited[vertex];
	}
	
	/**
	 * Tells whether there are vertices that are as yet not visited.
	 * 
	 * @return True if there is at least one unvisited vertex, false otherwise.
	 */
	public boolean hasMoreToVisit() {
		for (; unvisitedIndex < numverts; unvisitedIndex++) {
			if (!visited[unvisitedIndex]) {
				break;
			}
		}
		return unvisitedIndex < numverts;
	}
	
	/**
	 * Returns the lowest vertex number of all vertices that have not been visited yet.
	 * 
	 * @return Vertex number.
	 */
	public int nextToBeVisited() {
		return hasMoreToVisit() ? unvisitedIndex : -1;
	}
	
	/**
	 * Visits a given vertex - this implementation marks this vertex as visited,
	 * but does nothing else. Subclasses may override this method to add desired
	 * special features.
	 * 
	 * @param vertex Vertex number of vertex to be visited.
	 */
	public void visit(int vertex) {
		visited[vertex] = true;
	}
	
	/**
	 * Performs an action at a given vertex, to be called when the vertex is visited.
	 * This implementation prints the vertex information, 
	 * but does nothing else. Subclasses may override this method to add desired
	 * special features.
	 * 
	 * @param vertex Vertex number of vertex for which action is to be performed.
	 */
	public void action(int vertex) {
		System.out.println(" " + G.vertexInfoOf(vertex));
	}
}
