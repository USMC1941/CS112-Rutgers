package apps;

import structures.MinHeap;
import structures.Vertex;

public class PartialTree {

   /**
    * The root of the partial tree
    */
   private final Vertex       root;
   /**
    * The arcs included in this partial tree
    */
   private final MinHeap<Arc> arcs;

   /**
    * Initializes this partial tree with given vertex
    *
    * @param vertex Vertex used to initialize the tree
    */
   public PartialTree(Vertex vertex) {
      root = vertex;
      arcs = new MinHeap<Arc>();
   }

   /**
    * Merges another partial tree into this partial tree
    *
    * @param other The partial tree to be merged with this tree.
    */
   public void merge(PartialTree other) {
      other.root.parent = root;
      arcs.merge(other.arcs);
   }

   /**
    * Returns the root of this tree.
    *
    * @return Root of tree
    */
   public Vertex getRoot() {
      return root;
   }

   /**
    * Returns the priority-ordered arc set of this tree. The lower the weight of an arc,
    * the higher its priority.
    *
    * @return Priority-ordered arc set.
    */
   public MinHeap<Arc> getArcs() {
      return arcs;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString() {
      String ret = "Vertices: " + root.toString();
      ret += "  PQ: " + arcs;
      return ret;
   }

   /**
    * Inner class - represents an edge in a weighted, undirected graph.
    */
   public static class Arc implements Comparable<Arc> {

      /**
       * A vertex at one end of this arc.
       */
      Vertex v1;

      /**
       * A vertex at one end of this arc.
       */
      Vertex v2;

      /**
       * Weight assigned to this arc.
       */
      int weight;

      /**
       * Constructs a new Arc object from an existing edge in a graph.
       *
       * @param v1 Vertex at one end of the edge.
       * @param v2 Vertex at the other end of the edge.
       * @param weight Weight of the edge.
       */
      public Arc(Vertex v1, Vertex v2, int weight) {
         this.v1 = v1;
         this.v2 = v2;
         this.weight = weight;
      }

      @Override
      public boolean equals(Object o) {
         if (!(o instanceof Arc)) {
            return false;
         }
         Arc other = (Arc) o;
         return weight == other.weight && ((v1.name.equals(other.v1.name) && v2.name.equals(other.v2.name)) ||
                                           (v1.name.equals(other.v2.name) && v2.name.equals(other.v1.name)));
      }

      /**
       * Compares the weight of this arc with that of another.
       *
       * @param other Other arc
       * @return 0 if the weights are equal, +ve if this arc's weight is greater, -ve otherwise
       *
       */
      public int compareTo(Arc other) {
         return weight - other.weight;
      }

      /* (non-Javadoc)
       * @see java.lang.Object#toString()
       */
      public String toString() {
         return "(" + v1 + " " + v2 + " " + weight + ")";
      }
   }
}
