package bigint;

/**
 * This class encapsulates a BigInteger, i.e. a positive or negative integer with 
 * any number of digits, which overcomes the computer storage length limitation of 
 * an integer.
 *
 */
public class BigInteger {

   /**
    * True if this is a negative integer
    */
   boolean negative;

   /**
    * Number of digits in this integer
    */
   int numDigits;

   /**
    * Reference to the first node of this integer's linked list representation
    * NOTE: The linked list stores the Least Significant Digit in the FIRST node.
    * For instance, the integer 235 would be stored as:
    *    5 --> 3  --> 2
    *
    * Insignificant digits are not stored. So the integer 00235 will be stored as:
    *    5 --> 3 --> 2  (No zeros after the last 2)
    */
   DigitNode front;

   /**
    * Initializes this integer to a positive number with zero digits, in other
    * words this is the 0 (zero) valued integer.
    */
   public BigInteger() {
      negative = false;
      numDigits = 0;
      front = null;
   }

   /**
    * Parses an input integer string into a corresponding BigInteger instance.
    * A correctly formatted integer would have an optional sign as the first
    * character (no sign means positive), and at least one digit character
    * (including zero).
    * Examples of correct format, with corresponding values
    *      Format     Value
    *       +0            0
    *       -0            0
    *       +123        123
    *       1023       1023
    *       0012         12
    *       0             0
    *       -123       -123
    *       -001         -1
    *       +000          0
    *
    * Leading and trailing spaces are ignored. So "  +123  " will still parse
    * correctly, as +123, after ignoring leading and trailing spaces in the input
    * string.
    *
    * Spaces between digits are not ignored. So "12  345" will not parse as
    * an integer - the input is incorrectly formatted.
    *
    * An integer with value 0 will correspond to a null (empty) list - see the BigInteger
    * constructor
    *
    * @param integer Integer string that is to be parsed
    * @return BigInteger instance that stores the input integer.
    * @throws IllegalArgumentException If input is incorrectly formatted
    */
   public static BigInteger parse(String integer) throws IllegalArgumentException {

      // following line is a placeholder - compiler needs a return
      // modify it according to need
      return null;
   }

   /**
    * Adds the first and second big integers, and returns the result in a NEW BigInteger object.
    * DOES NOT MODIFY the input big integers.
    *
    * NOTE that either or both of the input big integers could be negative.
    * (Which means this method can effectively subtract as well.)
    *
    * @param first First big integer
    * @param second Second big integer
    * @return Result big integer
    */
   public static BigInteger add(BigInteger first, BigInteger second) {
      // following line is a placeholder - compiler needs a return
      // modify it according to need
      return null;
   }

   /**
    * Returns the BigInteger obtained by multiplying the first big integer
    * with the second big integer
    *
    * This method DOES NOT MODIFY either of the input big integers
    *
    * @param first First big integer
    * @param second Second big integer
    * @return A new BigInteger which is the product of the first and second big integers
    */
   public static BigInteger multiply(BigInteger first, BigInteger second) {
      // following line is a placeholder - compiler needs a return
      // modify it according to need
      return null;

   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString() {
      if (front == null) {
         return "0";
      }
      String retval = front.digit + "";
      for (DigitNode curr = front.next; curr != null; curr = curr.next) {
         retval = curr.digit + retval;
      }

      if (negative) {
         retval = '-' + retval;
      }
      return retval;
   }
}
