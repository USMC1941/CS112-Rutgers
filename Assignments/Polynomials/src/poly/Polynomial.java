package poly;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * This class implements a polynomial.
 *
 * @author runb-cs112
 *
 */
public class Polynomial {

   /**
    * Pointer to the front of the linked list that stores the polynomial.
    */
   Node poly;

   /**
    * Initializes this polynomial to empty, i.e. there are no terms.
    *
    */
   public Polynomial() {
      poly = null;
   }

   /**
    * Reads a polynomial from an input stream (file or keyboard). The storage format
    * of the polynomial is:
    * <pre>
    *     <coeff> <degree>
    *     <coeff> <degree>
    *     ...
    *     <coeff> <degree>
    * </pre>
    * with the guarantee that degrees will be in descending order. For example:
    * <pre>
    *      4 5
    *     -2 3
    *      2 1
    *      3 0
    * </pre>
    * which represents the polynomial:
    * <pre>
    *      4*x^5 - 2*x^3 + 2*x + 3
    * </pre>
    *
    * @param br BufferedReader from which a polynomial is to be read
    * @throws IOException If there is any input error in reading the polynomial
    */
   public Polynomial(BufferedReader br) throws IOException {
      String          line;
      StringTokenizer tokenizer;
      float           coeff;
      int             degree;

      poly = null;

      while ((line = br.readLine()) != null) {
         tokenizer = new StringTokenizer(line);
         coeff = Float.parseFloat(tokenizer.nextToken());
         degree = Integer.parseInt(tokenizer.nextToken());
         poly = new Node(coeff, degree, poly);
      }
   }


   /**
    * Returns the polynomial obtained by adding the given polynomial p
    * to this polynomial - DOES NOT change this polynomial
    *
    * @param p Polynomial to be added
    * @return A new polynomial which is the sum of this polynomial and p.
    */
   public Polynomial add(Polynomial p) {
      /** COMPLETE THIS METHOD **/
      return null;
   }

   /**
    * Returns the polynomial obtained by multiplying the given polynomial p
    * with this polynomial - DOES NOT change this polynomial
    *
    * @param p Polynomial with which this polynomial is to be multiplied
    * @return A new polynomial which is the product of this polynomial and p.
    */
   public Polynomial multiply(Polynomial p) {
      /** COMPLETE THIS METHOD **/
      return null;
   }

   /**
    * Evaluates this polynomial at the given value of x
    *
    * @param x Value at which this polynomial is to be evaluated
    * @return Value of this polynomial at x
    */
   public float evaluate(float x) {
      /** COMPLETE THIS METHOD **/
      return 0;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString() {
      String retval;

      if (poly == null) {
         return "0";
      }
      else {
         retval = poly.term.toString();
         for (Node current = poly.next; current != null; current = current.next) {
            retval = current.term.toString() + " + " + retval;
         }
         return retval;
      }
   }
}
