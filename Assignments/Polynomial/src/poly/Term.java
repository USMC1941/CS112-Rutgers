package poly;

/**
 * This class implements a term of a polynomial.
 *
 * @author runb-cs112
 *
 */
public class Term {
   /**
    * Coefficient of term.
    */
   public float coeff;

   /**
    * Degree of term.
    */
   public int degree;

   /**
    * Initializes an instance with given coefficient and degree.
    *
    * @param coeff Coefficient
    * @param degree Degree
    */
   public Term(float coeff, int degree) {
      this.coeff = coeff;
      this.degree = degree;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
      return other instanceof Term && coeff == ((Term) other).coeff && degree == ((Term) other).degree;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString() {
      if (degree == 0) {
         return coeff + "";
      }
      else if (degree == 1) {
         return coeff + "x";
      }
      else {
         return coeff + "x^" + degree;
      }
   }
}
