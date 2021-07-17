package structures.graph;

/**
 * This class encapsulated a neighbor of a vertex. In this implementation, the
 * neighbor is simply an vertex number, but this class may be subclassed by
 * adding an edge weight field, which may then be used in the implementation
 * of a weighted graph.
 * 
 * @author Sesh Venugopal
 *
 */
public class Neighbor {
	
	/**
	 * Internal vertex number of neighbor.
	 */
	public int vertexNumber;
	
	/**
	 * Initializes a new instance with given vertex number.
	 * 
	 * @param vertexNum Vertex number.
	 */
	public Neighbor(int vertexNum) {
		vertexNumber = vertexNum;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Neighbor)) {
			Neighbor another = (Neighbor)other;
			return (vertexNumber == another.vertexNumber);
		}
		return false;
	}
}
