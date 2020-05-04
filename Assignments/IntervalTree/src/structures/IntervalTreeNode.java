package structures;

import java.util.ArrayList;

/**
 * Encapsulates a node of the interval tree. 
 *
 * @author runb-cs112
 */
public class IntervalTreeNode {

   /**
    * Split value of this node. For a leaf node, this is the same as the endpoint value.
    */
   float splitValue;

   /**
    * Maximum of all split values in this node's subtree, which is the split value
    * of the "rightmost" endpoint leaf node. If this is a leaf node, then this
    * value is the same as splitValue.
    */
   float maxSplitValue;

   /**
    * Minimum of all split values in this node's subtree, which is the split value
    * of the "leftmost" endpoint leaf node. If this is a leaf node, then this
    * value is the same as splitValue.
    */
   float minSplitValue;

   /**
    * Array list of intervals at this node sorted on left endpoint
    */
   ArrayList<Interval> leftIntervals;

   /**
    * Array list of intervals at this node sorted on right endpoint
    */
   ArrayList<Interval> rightIntervals;

   /**
    * Reference to left child of this node
    */
   IntervalTreeNode leftChild;

   /**
    * Reference to right child of this node
    */
   IntervalTreeNode rightChild;

   /**
    * Initializes a new IntervalTreeNode object with its split value, and the minimum
    * and maximum split values in its subtree. The left and right interval lists,
    * as well as the left and right children references are set to null.
    *
    * @param splitValue Split value of this node
    * @param minSplitValue Minimum of all split values in this node's subtree, which is the split
    *        value of the "leftmost" endpoint leaf node
    * @param maxSplitValue Maximum of all split values in this node's subtree, which is the split
    *        value of the "rightmost" endpoint leaf node
    */
   public IntervalTreeNode(float splitValue, float minSplitValue, float maxSplitValue) {
      this.splitValue = splitValue;
      this.maxSplitValue = maxSplitValue;
      this.minSplitValue = minSplitValue;
      leftIntervals = null;
      rightIntervals = null;
      leftChild = null;
      rightChild = null;
   }

   /**
    * Finds all left-endpoint sorted intervals at this node that intersect with a given interval.
    *
    * @param q The interval for which intersections are to be determined
    * @param retval An array list (created by the caller) to which the left-sorted intersecting intervals at this node are added
    */
   public void matchLeft(Interval q, ArrayList<Interval> retval) {
      if (leftIntervals == null) {
         return;
      }

      int i = 0;
      while (i < leftIntervals.size() && (leftIntervals.get(i)).intersects(q)) {
         retval.add(leftIntervals.get(i));
         i++;
      }
   }

   /**
    * Finds all right-endpoint sorted intervals at this node that intersect with a given interval.
    *
    * @param q The interval for which intersections are to be determined
    * @param retval An array list (created by the caller) to which the right-sorted intersecting intervals at this node are added
    */
   public void matchRight(Interval q, ArrayList<Interval> retval) {
      if (rightIntervals == null) {
         return;
      }

      int i;
      i = rightIntervals.size() - 1;
      while (i >= 0 && (rightIntervals.get(i)).intersects(q)) {
         retval.add(rightIntervals.get(i));
         i--;
      }
   }

   /**
    * @see Object#toString()
    */
   public String toString() {
      return "(" + maxSplitValue + "," + splitValue + "," + minSplitValue + "," + leftIntervals + "," + rightIntervals + ")";
   }
}
