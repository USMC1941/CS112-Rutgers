package bookexamples;

/**
 * This is an example of implementing an interface. See section "Generics"
 * in the text for a discussion.
 * 
 * @author Sesh Venugopal
 *
 */
public class IntItem implements MyComparable<IntItem> {

	/**
	 * The integer value of this item.
	 */
	public final int value;
	
	/**
	 * Initializes this item to the given integer value.
	 * 
	 * @param value Integer value
	 */
	public IntItem(int value) {
		this.value = value;
	}
		
	/**
	 * Checks whether this item is less than another item.
	 * 
	 * @param other Other item
	 * @return True if this item's integer value is less than the other's, false otherwise
	 */
	public boolean lessThan(IntItem other) {
		return this.value < other.value;
	}
	
	/**
	 * Checks whether this item is greater than another item.
	 * 
	 * @param other Other item
	 * @return True if this item's integer value is greater than the other's, false otherwise
	 */
	public boolean greaterThan(IntItem other) {
		return this.value > other.value;
	}
	
	/**
	 * @param args Arguments to the application - no arguments needed
	 */
	public static void main(String[] args) {
		IntItem it1 = new IntItem(5);
		System.out.println("it1.value = " + it1.value);
		IntItem it2 = new IntItem(10);
		System.out.println("it1.equals(it2)? => " + it1.equals(it2));
		/*
		Object o = new Object();
		System.out.println("it1.equals(o)? => " + it1.equals(o));
		*/
		Integer i1 = new Integer(15);
		Integer i2 = new Integer(20);
		System.out.println("i1.compareTo(i2)? => " + i1.compareTo(i2));
	}
}
