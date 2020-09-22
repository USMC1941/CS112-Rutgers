package apps;

import structures.Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class used for testing the MST
 */
public class Driver {

   public static void main(String[] args) {
      Graph graph = null;
      try {
         graph = new Graph("graph3.txt");
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      //
      PartialTreeList partialTreeList = MST.initialize(Objects.requireNonNull(graph));
      //
      ArrayList<PartialTree.Arc> arcArrayList = MST.execute(partialTreeList);
      //
      for (PartialTree.Arc anArcArrayList : arcArrayList) {
         System.out.println(anArcArrayList);
      }
   }
}
