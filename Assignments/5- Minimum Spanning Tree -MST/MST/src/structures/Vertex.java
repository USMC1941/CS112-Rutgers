package structures;

/**
 * Adjacency linked lists representation of a vertex in a graph.  Also maintains a
 * reference to a "parent" vertex, to allow the MST application to keep track of
 * partial trees within the graph.
 */
public class Vertex {
    
	/**
	 * Inner class - represents a neighbor (an outgoing edge) in a weighted graph.
	 */
	public static class Neighbor {
	    
		/**
	     * Neighboring vertex.
	     */
	    public Vertex vertex;
	    
	    /**
	     * Weight of edge to neighbor.
	     */
	    public int weight;
	    
	    /**
	     * Next neighbor in the linked list of neighbors.
	     */
	    public Neighbor next;

	    /**
	     * Initializes a new Neighbor object.
	     * 
	     * @param vertex Neighbor vertex
	     * @param weight Weight of edge to neighbor.
	     */
	    Neighbor(Vertex vertex, int weight) {
	    	this.vertex = vertex;
	    	this.weight = weight;
	    }
	}
	
	/**
     * Name of this vertex.
     */
    public String name;

    /**
     * Adjacency linked list of all neighbors.
     */
    public Neighbor neighbors;

    /**
     * Reference to the immediate parent of this vertex in the partial spanning
     * tree to which the vertex belongs.  Note that a vertex and its parent
     * are not necessarily connected by an actual edge of the graph.  Even
     * if they are directly connected, that edge may not form part of the
     * partial tree to which they both belong.  The parent reference is only a
     * mechanism for determining to WHICH partial tree a vertex belongs.
     */
    public Vertex parent;

    /**
     * Constructs a new Vertex object with no neighbors (i.e.,
     * no outgoing edges), and no parent vertex (i.e., it is its own partial
     * spanning tree).
     * @param name Name to give to this vertex.
     */
    Vertex(String name) {
    	this.name = name;
    	neighbors = null;
    	parent = this;
    }

    /**
     * Finds and returns the vertex at the root of the partial spanning tree to
     * which this vertex belongs.
     * @return Root of partial tree.
     */
    public Vertex getRoot() {
		Vertex v;
		for (v = this ; v.parent != v ; v = v.parent);
		return v;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	return name;
    }
}
