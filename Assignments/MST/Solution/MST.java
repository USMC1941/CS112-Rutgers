package apps;

import structures.Graph;
import structures.MinHeap;
import structures.Vertex;

import java.util.ArrayList;

public class MST {

   /**
    * Initializes the algorithm by building single-vertex partial trees
    *
    * @param graph Graph for which the MST is to be found
    * @return The initial partial tree list
    */
   public static PartialTreeList initialize(Graph graph) {
      // Create an empty partialTreeList
      PartialTreeList partialTreeList = new PartialTreeList();

      // Create a PartialTree for every vertex and put it into the PartialTreeList
      for (int i = 0; i < graph.vertices.length; i++) {

         // Get one vertex from the list of vertices. Mark each vertex as belonging to PartialTree
         Vertex oneVertex = graph.vertices[i];

         // Create a PartialTree
         PartialTree partialTree = new PartialTree(oneVertex);

         // Loop through all neighbors of the current vertex
         // Begin at the head of the neighbors list
         Vertex.Neighbor oneNeighborInLoop = oneVertex.neighbors;
         while (oneNeighborInLoop != null) {
            // Arc <-> Neighbor
            PartialTree.Arc arc = new PartialTree.Arc(oneVertex, oneNeighborInLoop.vertex, oneNeighborInLoop.weight);

            // Insert all of the arcs (edges) connected to the current vertex into priority queue one at a time.
            partialTree.getArcs()
                       .insert(arc);

            // Move to the next element in the neighbors list in the current vertex
            oneNeighborInLoop = oneNeighborInLoop.next;
         }

         // Put the PartialTree into the PartialTreeList
         partialTreeList.append(partialTree);
      }
      //
      return partialTreeList;
   }

   /**
    * Executes the algorithm on a graph, starting with the initial partial tree list
    *
    * @param ptlist Initial partial tree list
    * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
    */
   public static ArrayList<PartialTree.Arc> execute(PartialTreeList ptlist) {
      // Create a new Array List of arcs to hold the MST
      ArrayList<PartialTree.Arc> arcArrayList = new ArrayList<>();

      // Go through the algorithm until there is only 1 PartialTree remaining in the list (MST)
      while (ptlist.size() > 1) {

         // Get/Remove the first PartialTree from the PartialTreeList
         PartialTree partialTree = ptlist.remove();

         // Get the MinHeap from that particular PartialTree
         MinHeap<PartialTree.Arc> minHeap = partialTree.getArcs();

         // Get/Remove the minimum weighted arc from the MinHeap
         PartialTree.Arc minArc = minHeap.deleteMin();
         // Loop the minHeap of arcs until it finds one that links to another partialTree
         while (minArc != null) {
            // Get V1 and V2 of the arc
            Vertex v1 = minArc.v1;
            Vertex v2 = minArc.v2;

            // Check whether V1 and V2 are in other PartialTrees using removeTreeContaining
            // Try to find v1 or v2 in the ptlist.
            PartialTree otherPartialTree;
            otherPartialTree = ptlist.removeTreeContaining(v1);         // See if v1 is in the other PartialTree
            if (otherPartialTree == null) {
               otherPartialTree = ptlist.removeTreeContaining(v2);     // See if v2 is in the PartialTree
            }
            if (otherPartialTree != null) {                             // Either v1 or v2 are in other PartialTree in the ptlist
               // Merge current PartialTree with the otherPartialTree, including the MinHeap
               partialTree.merge(otherPartialTree);
               arcArrayList.add(minArc);                               // Put the arc into the MST
               //
               ptlist.append(partialTree);                             // Put the combined PartialTree back into the ptlist.
               // The number of PartialTrees in the ptlist should decrease by 1
               break;                                                  // Exit minArc while loop. Go to ptlist loop
            }
            // Otherwise, v1 and v2 of the arc are not in any other PartialTree.
            // They both are in the current PartialTree. Ignore and continue with the next arc from the MinHeap

            // Go to the next arc in the MinHeap
            minArc = minHeap.deleteMin();
         }
      }
      //
      return arcArrayList;
   }
}
