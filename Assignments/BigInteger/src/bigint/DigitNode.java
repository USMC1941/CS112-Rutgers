package bigint;

/**
 * This class encapsulates a linked list for a digit of a big integer.
 *
 * @author Sesh Venugopal (RU NB CS 112)
 *
 */
public class DigitNode {
   /**
    * The digit
    */
   int digit;

   /**
    * Pointer to next digit in the linked list
    */
   DigitNode next;

   /**
    * Initializes this digit node with a digit and next pointer
    *
    * @param digit Digit
    * @param next Next pointer
    */
   DigitNode(int digit, DigitNode next) {
      this.digit = digit;
      this.next = next;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString() {
      return digit + "";
   }
}
