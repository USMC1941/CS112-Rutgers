package apps.linear;

import java.util.Calendar;
import structures.linear.List;

/**
 * This class implements an unordered list of expenses. Each item
 * in the list is an Expense instance.
 * 
 * @author Sesh Venugopal
 *
 */
public class ExpenseList {
	
	/**
	 * List component, instantiated with Expense type, to store
	 * expenses.
	 */
	List<Expense> expenses;
	
	/**
	 * Initializes this expense list to empty.
	 */
	public ExpenseList() {
		expenses = new List<Expense>();
	}
	
	/**
	 * Adds a given expense to the end of this list.
	 * 
	 * @param exp Expense to be added.
	 */
	public void add(Expense exp) {
		expenses.add(exp);
	}
	
	/**
	 * Returns the number of expenses in this list.
	 * 
	 * @return Number of expenses.
	 */
	public int size() {
		return expenses.size();
	}
	
	/**
	 * Tells whether this list is empty or not.
	 * 
	 * @return True if this list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return expenses.isEmpty();
	}
	
	/**
	 * Tells whether this list contains a given expense or not.
	 * 
	 * @param exp Expense that is sought in this list.
	 * @return True if this list contains the given expense, false otherwise.
	 */
	public boolean contains(Expense exp) {
		return expenses.contains(exp);
	}
	
	/**
	 * Empties this list by removing all expenses. 
	 */
	public void clear() {
		expenses.clear();
	}
	
	/**
	 * Removes a given expense from this list.
	 * 
	 * @param exp Expense to be removed.
	 * @throws NoSuchElementException If the given expense does not exist in this list.
	 */
	public void remove(Expense exp) { 
		expenses.remove(exp);
	}
	
	/**
	 * Returns the first expense in this list.
	 * 
	 * @return First expense in this list, null if list is empty.
	 */
	public Expense first() {	
		return expenses.first();
	}
	
	/**
	 * Returns the next expense in this list, relative to a previous call
	 * to first( ) or next( ). <br>
	 * To iterate over all expenses in this list, there
	 * must be a call to first( ), followed by successive calls to next( ).
	 * 
	 * @return Next expense in this list. Null if list is empty, or end of list was
	 *         reached. 
	 */
	public Expense next() {	
		return expenses.next();
	}
	
	/**
	 * Returns the maximum of all expense amounts in this list.
	 * 
	 * @return Maximum expense amount.
	 */
	public float maxExpense() {
		float max=0;
		
		// step through all elements of the expense list
		Expense exp = expenses.first();
		while (exp != null) {
			float amt = exp.amount;
			// update max is needed
			if (amt > max) {
				max = amt;
			}
			exp = expenses.next();
		}
		return max;
	}
	
	/**
	 * Returns the minimum of all expense amounts in this list.
	 * 
	 * @return Minimum expense amount.
	 */
	public float minExpense() {
		float min=Float.MAX_VALUE;
		
		// step through all elements of the expense list
		Expense exp = expenses.first();
		while (exp != null) {
			float amt = exp.amount;
			// update min is needed
			if (amt < min) {
				min = amt;
			}
			exp = expenses.next();
		}
		return min;
	}
	
	/**
	 * Returns the average of all expense amounts in this list.
	 * 
	 * @return Average expense amount.
	 */
	public float avgExpense() {
		float sum=0;
		
		// step through all elements of the expense list
		Expense exp = expenses.first();
		while (exp != null) {
			// add amount to total
			sum += exp.amount;
			exp = expenses.next();
		}
		return sum/expenses.size();
	}
	
	/**
	 * Returns the total amount spent on a given expense item in the list.
	 * 
	 * @param expItem Expense item.
	 * @return Total amount spent on the given expense item.
	 */
	public float amountSpentOn(String expItem) {
		float sum=0;
		
		// step through all elements of the expense list
		Expense exp = expenses.first();
		while (exp != null) {
			// add amount only for specified item
			if (expItem.equals(exp.item)) {
				sum += exp.amount;
			}
			exp = expenses.next();
		}
		return sum;
	}
	
	/**
	 * Returns the total amount spent during a certain time period.
	 * 
	 * @param from Start date of time period.
	 * @param to End date of time period.
	 * @return Total amount spent during the given time period. 
	 */
	public float amountSpentDuring(Calendar from, Calendar to) {
		float sum=0;
				
		// step through all elements of the expense list
		Expense exp = expenses.first();
		while (exp != null) {
			// add amount only for specified date interval
			if (!(exp.date.before(from) || exp.date.after(to))) {
				sum += exp.amount;
			}
			exp = expenses.next();
		}
		return sum;
	}
	
	/**
	 * Returns the expense object in this list that matches the given expense.
	 * 
	 * @param getExp Expense to be matched.
	 * @return Matching expense object.
	 */
	public Expense get(Expense getExp) {
		// search through expense list
		Expense exp = expenses.first();
		while (exp != null) {
			if (exp.equals(getExp)) {
				return exp;
			}
			exp = expenses.next();
		}
		return null;
	}
}


