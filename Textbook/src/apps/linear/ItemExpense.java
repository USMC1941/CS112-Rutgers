package apps.linear;

import java.util.Calendar;

/**
 * This class encapsulates an expense specialized for comparisons
 * based only on the expense item, i.e. two ItemExpense instances are
 * "equal" if their items are the same. This is implemented by overriding
 * the equals method inherited from the Expense superclass.
 * 
 * @author Sesh Venugopal
 *
 */
public class ItemExpense extends Expense {
	
	/**
	 * Initializes this expense with given date, amount, and item.
	 * 
	 * @param expDate Expense date.
	 * @param expAmount Expense amount.
	 * @param expItem Expense item.
	 */
	public ItemExpense(Calendar expDate, float expAmount, String expItem) {
		super(expDate, expAmount, expItem);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Expense)) {
			Expense another = (Expense)other;
			return (item.equals(another.item)); 
		}
		return false;
	}
}

