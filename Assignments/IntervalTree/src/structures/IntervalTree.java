package structures;

import java.util.ArrayList;

/**
 * Encapsulates an interval tree.
 *
 * @author runb-cs112
 */
public class IntervalTree {

   /**
    * The root of the interval tree
    */
   IntervalTreeNode root;

   /**
    * Constructs entire interval tree from set of input intervals. Constructing the tree
    * means building the interval tree structure and mapping the intervals to the nodes.
    *
    * @param intervals Array list of intervals for which the tree is constructed
    */
   public IntervalTree(ArrayList<Interval> intervals) {
      // COMPLETE THIS CONSTRUCTOR
   }

   /**
    * Sorts a set of intervals in place, according to left or right endpoints.
    * At the end of the method, the parameter array list is a sorted list.
    *
    * @param intervals Array list of intervals to be sorted.
    * @param lr If 'l', then sort is on left endpoints; if 'r', sort is on right endpoints
    */
   public static ArrayList<Interval> sortIntervals(ArrayList<Interval> intervals, char lr) {
      // COMPLETE THIS METHOD
      // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
      return null;
   }

   /**
    * Given a set of intervals (left sorted and right sorted), extracts the left and right end points,
    * and returns a sorted list of the combined end points without duplicates.
    *
    * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
    * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
    * @return Sorted array list of all endpoints without duplicates
    */
   public static ArrayList<Integer> getSortedEndPoints(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
      // COMPLETE THIS METHOD
      // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
      return null;
   }

   /**
    * Builds the interval tree structure given a sorted array list of end points
    * without duplicates.
    *
    * @param endPoints Sorted array list of end points
    * @return Root of the tree structure
    */
   public static IntervalTreeNode buildTreeNodes(ArrayList<Integer> endPoints) {
      // COMPLETE THIS METHOD
      // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
      return null;
   }

   /**
    * Returns the root of this interval tree.
    *
    * @return Root of interval tree.
    */
   public IntervalTreeNode getRoot() {
      return root;
   }

   /**
    * Maps a set of intervals to the nodes of this interval tree.
    *
    * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
    * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
    */
   public void mapIntervalsToTree(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
      // COMPLETE THIS METHOD
   }

   /**
    * Gets all intervals in this interval tree that intersect with a given interval.
    *
    * @param q The query interval for which intersections are to be found
    * @return Array list of all intersecting intervals; size is 0 if there are no intersections
    */
   public ArrayList<Interval> findIntersectingIntervals(Interval q) {
      // COMPLETE THIS METHOD
      // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
      return null;
   }
}
