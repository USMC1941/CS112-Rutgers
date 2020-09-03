package app;

/**
 * This class holds a (name, integer value) pair for a simple (non-array)
 * variable. The variable name is a sequence of one or more letters.
 *
 * @author ru-nb-cs112
 *
 */
public class Variable {

   /**
    * Name, sequence of letters
    */
   public String name;

   /**
    * Integer value
    */
   public int value;

   /**
    * Initializes with name, and zero value
    *
    * @param name Variable name
    */
   public Variable(String name) {
      this.name = name;
      value = 0;
   }

   /*
    * (non-Javadoc)
    *
    * @see java.lang.Object#toString()
    */
   public String toString() {
      return name + "=" + value;
   }

   /*
    * (non-Javadoc)
    *
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object o) {
      if (!(o instanceof Variable)) {
         return false;
      }
      Variable ss = (Variable) o;
      return name.equals(ss.name);
   }
}