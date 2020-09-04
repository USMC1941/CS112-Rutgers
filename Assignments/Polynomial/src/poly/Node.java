package poly;

/**
 * This class implements a linked list node that contains a Term instance.
 *
 * @author runb-cs112
 *
 */
public class Node {

   /**
    * Term instance.
    */
   Term term;

   /**
    * Next node in linked list.
    */
   Node next;

   /**
    * Initializes this node with a term with given coefficient and degree,
    * pointing to the given next node.
    *
    * @param coeff Coefficient of term
    * @param degree Degree of term
    * @param next Next node
    */
   public Node(float coeff, int degree, Node next) {
      term = new Term(coeff, degree);
      this.next = next;
   }
}
