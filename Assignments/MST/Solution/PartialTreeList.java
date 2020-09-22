package apps;

import structures.Vertex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PartialTreeList implements Iterable<PartialTree> {

   /**
    * Inner class - to build the partial tree circular linked list
    *
    */
   public static class Node {
      /**
       * Partial tree
       */
      public PartialTree tree;

      /**
       * Next node in linked list
       */
      public Node next;

      /**
       * Initializes this node by setting the tree part to the given tree,
       * and setting next part to null
       *
       * @param tree Partial tree
       */
      public Node(PartialTree tree) {
         this.tree = tree;
         next = null;
      }
   }

   /**
    * Pointer to last node of the circular linked list
    */
   private Node rear;

   /**
    * Number of nodes in the CLL
    */
   private int size;

   /**
    * Initializes this list to empty
    */
   public PartialTreeList() {
      rear = null;
      size = 0;
   }

   /**
    * Adds a new tree to the end of the list
    *
    * @param tree Tree to be added to the end of the list
    */
   public void append(PartialTree tree) {
      Node ptr = new Node(tree);
      if (rear == null) {
         ptr.next = ptr;
      }
      else {
         ptr.next = rear.next;
         rear.next = ptr;
      }
      rear = ptr;
      size++;
   }

   /**
    * Removes the tree that is at the front of the list.
    *
    * @return The tree that is removed from the front
    * @throws NoSuchElementException If the list is empty
    */
   public PartialTree remove() throws NoSuchElementException {
      // If the list contains no elements
      if (size <= 0) {
         throw new NoSuchElementException("List is Empty.");
      }

      // If the list contains 1 element, return the tree in that element.
      if (size == 1) {
         Node returnNode = rear;                                             // The only element
         rear = null;                                                        // Set the list as empty
         size = 0;
         returnNode.next = null;                                             // Clean up the removed node (just in case)
         return returnNode.tree;
      }
      else {
         // If the list contains more than 1 element.
         Node first = rear.next;                                             // Get the head of the list
         rear.next = first.next;                                             // Second -> New first
         size--;
         first.next = null;
         return first.tree;
      }
   }

   /**
    * Removes the tree in this list that contains a given vertex.
    *
    * @param vertex Vertex whose tree is to be removed
    * @return The tree that is removed
    * @throws NoSuchElementException If there is no matching tree
    */
   public PartialTree removeTreeContaining(Vertex vertex) throws NoSuchElementException {
      PartialTree partialTreeToRemove = null;

      // Empty list
      if (rear == null) {
         throw new NoSuchElementException("Empty Tree List.");
      }

      // The loop variable
      Node temp = rear;

      // Loop through the list starting from rear
      do {
         //current node temp handling one node
         PartialTree tree           = temp.tree;
         boolean     isVertexInTree = checkVertexInPartialTree(tree, vertex);
         if (isVertexInTree) {
            // Return the tree in that node
            partialTreeToRemove = tree;

            // Remove the node from the list
            removeNodeFromList(temp);

            break;
         }
         // go to next one
         temp = temp.next;

         // Continue if not reach rear
      }
      while (temp != rear);
      //
      return partialTreeToRemove;
   }

   // Check if the vertex is in a particular tree
   private boolean checkVertexInPartialTree(PartialTree partialTree, Vertex vertex) {
      // Go up the parentTree to the top starting from the input vertex
      Vertex parentTree = vertex;
      while (parentTree.parent != parentTree) {         // Continue if it not the top of the parentTree
         // Go up to the next parent in the tree
         parentTree = parentTree.parent;
      }
      // If the top is the root of the partial tree checking, the vertex is in the partial tree
      return parentTree == partialTree.getRoot();
   }

   // Remove a node in the list
   private void removeNodeFromList(Node node) {
      // Find the node before
      Node nodeBefore;                // nodeBefore.next == node
      nodeBefore = node;
      while (!(nodeBefore.next == node)) {
         nodeBefore = nodeBefore.next;
      }

      // Find the node after
      Node nodeAfter = node.next;

      // Only 1 node in the list
      if (nodeAfter == node) {
         rear = null;
         size--;
      }
      // Two nodes in the list
      else if (nodeAfter == nodeBefore) {
         if (node == rear) {                     // If the removed node is the rear itself, point the rear to the next one first
            rear = rear.next;
         }
         //
         node.next.next = node.next;             // Point node.next to itself since the node will be removed
         size--;
      }
      // Three or more nodes in the list
      else {
         if (node == rear) {
            // Now, the rear is the one before
            rear = nodeBefore;
         }
         nodeBefore.next = nodeAfter;
         size--;
      }
      // Clean up the node removed (just in case)
      node.next = null;
   }

   /**
    * Gives the number of trees in this list
    *
    * @return Number of trees
    */
   public int size() {
      return size;
   }

   /**
    * Returns an Iterator that can be used to step through the trees in this list.
    * The iterator does NOT support remove.
    *
    * @return Iterator for this list
    */
   public Iterator<PartialTree> iterator() {
      return new PartialTreeListIterator(this);
   }

   private class PartialTreeListIterator implements Iterator<PartialTree> {

      private Node ptr;
      private int  rest;

      public PartialTreeListIterator(PartialTreeList target) {
         rest = target.size;
         ptr = rest > 0 ? target.rear.next : null;
      }

      public PartialTree next() throws NoSuchElementException {
         if (rest <= 0) {
            throw new NoSuchElementException();
         }
         PartialTree ret = ptr.tree;
         ptr = ptr.next;
         rest--;
         return ret;
      }

      public boolean hasNext() {
         return rest != 0;
      }

      public void remove() throws UnsupportedOperationException {
         throw new UnsupportedOperationException();
      }

   }
}
