package structures;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * A weighted, undirected graph, stored in adjacency linked lists format.
 */
public class Graph {
      
	/**
     * List of vertices in graph.
     */
    public Vertex[] vertices;

    /**
     * Hash map of vertex name -> vertex number mappings
     */
    HashMap<String,Integer> vertmap;

    /**
     * Constructs a graph out of a plain text description in an input file.
     * 
     * @param file Name of the file that has the input graph description.
     * @throws IOException If the input file is not found.
     */
    public Graph(String file) 
    throws IOException {
    	Scanner sc = new Scanner(new File(file));
    	// first line is number of vertices
    	vertices = new Vertex[sc.nextInt()];
    	vertmap = new HashMap<String,Integer>(vertices.length,2f);
    	// add all vertices
    	for (int v=0; v < vertices.length; v++) {
    		vertices[v] = new Vertex(sc.next());
    		vertmap.put(vertices[v].name, v);
    	}
    	
    	// add edges
    	while (sc.hasNext()) {
    		Vertex vx1 = vertices[vertmap.get(sc.next())];
    		Vertex vx2 = vertices[vertmap.get(sc.next())];
    		int wt = sc.nextInt();
    		
    		// add vx2 to vx1's list
    		Vertex.Neighbor nbr = new Vertex.Neighbor(vx2,wt);
    		nbr.next = vx1.neighbors;
    		vx1.neighbors = nbr;
    		// add vx1 to vx2's list
    		nbr = new Vertex.Neighbor(vx1,wt);
    		nbr.next = vx2.neighbors;
    		vx2.neighbors = nbr;
    	}
    }
    
    /**
     * Prints this graph
     */
    public void print() {
		System.out.println(vertices.length);
		// list all vertices
		for (int i=0; i < vertices.length; i++) {
			System.out.println(vertices[i].name);
		}
		// list all edges
		for (int i=0; i < vertices.length; i++) {
			for (Vertex.Neighbor nbr=vertices[i].neighbors; nbr != null; nbr=nbr.next) {
				System.out.println(vertices[i].name + " " + nbr.vertex.name + " " + nbr.weight);
			}
		}
	}
}
