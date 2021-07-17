package structures.graph;

import structures.linear.List;

/**
 * This class encapsulates a vertex by packaging together the client-supplied
 * vertex object and a reference to the list of its neighbors.
 * 
 * @author Sesh Venugopal
 *
 */
public class Vertex<T> {
	
	/**
	 * Client-supplied vertex information.
	 */
	protected T info;         
	
	/**
	 * Neighbors of this vertex.
	 */
	protected List<Neighbor> neighbors;  
	
	/**
	 * Initializes a new instance with vertex information.
	 * 
	 * @param vertexInfo Vertex information.
	 */
	protected Vertex(T vertexInfo) {
		info = vertexInfo;
		neighbors = new List<Neighbor>();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Vertex)) {
			Vertex another = (Vertex)other;
			return (info.equals(another.info));
		}
		return false;
	}
}
