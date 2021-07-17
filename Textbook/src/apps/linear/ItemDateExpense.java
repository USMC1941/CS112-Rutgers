package apps.linear;

import java.util.Calendar;

/**
 * This class encapsulates an expense specialized for comparisons
 * based on the expense item and date, i.e. two ItemDateExpense instances are
 * "equal" if their items and dates are the same. This is implemented by overriding
 * the equals method inherited from the Expense superclass.
 * 
 * @author Sesh Venugopal
 *
 */
public class ItemDateExpense extends Expense {
	
	/**
	 * Initializes this expense with given date, amount, and item.
	 * 
	 * @param expDate Expense date.
	 * @param expAmount Expense amount.
	 * @param expItem Expense item.
	 */
	public ItemDateExpense(Calendar expDate, float expAmount, String expItem) {
		super(expDate, expAmount, expItem);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Expense)) {
			Expense another = (Expense)other;
			return (item.equals(another.item) && date.equals(another.date)); 
		}
		return false;
	}
}

