package apps.graph;

import structures.graph.Neighbor;

/**
 * This class implements a weighted edge.
 * 
 * @author Sesh Venugopal
 *
 */
public class WeightedNeighbor extends Neighbor {
	
	/**
	 * Edge weight.
	 */
	public int weight;
	
	/**
	 * Initializes a new instance with a neighbor vertex, and edge weight.
	 * 
	 * @param vertexNum Neighbor vertex number.
	 * @param weight Edge weight.
	 */
	public WeightedNeighbor(int vertexNum, int weight) {
		super(vertexNum);
		this.weight = weight;
	}
}
