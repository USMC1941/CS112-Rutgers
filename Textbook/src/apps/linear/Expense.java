package apps.linear;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * This class encapsulates an expense consisting of a date (yyyy/mm/dd), 
 * an amount spent, and an item on which the amount was spent.
 * 
 * @author Sesh Venugopal
 *
 */
public class Expense {
	
	/**
	 * Date of expense, yyyy/mmm/dd.
	 */
	public Calendar date;
	
	/**
	 * Amount of expense, in dollars and cents.
	 */
	public float amount;
	
	/**
	 * Item of expense.
	 */
	public String item;
	
	/**
	 * Formatter to represent date of expense, as the string yyyy/mm/dd
	 */
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	/**
	 * Initializes this expense with given date, amount, and item.
	 * 
	 * @param expDate Expense date.
	 * @param expAmount Expense amount.
	 * @param expItem Expense item.
	 */
	public Expense(Calendar expDate, float expAmount, String expItem) {
		date = expDate;
		amount = expAmount;
		item = expItem;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Expense)) {
			Expense another = (Expense)other;
			return (item.equals(another.item) && 
					date.equals(another.date) &&
					amount == another.amount);
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("%s\t%.2f\t%s", sdf.format(date.getTime()), amount, item);
	}
	
	/**
	 * Returns the date of this expense as a string, of the form "yyyy/mm/dd".
	 * 
	 * @return String form of expense date.
	 */
	public String getDate() {
		return sdf.format(date.getTime());
	}
	
	/**
	 * Utility method to construct a Calendar instance out of year, month, and date.
	 * 
	 * @param year Year.
	 * @param month Month, between 0 and 11.
	 * @param date Date, between 1 and 28,29,30 or 31.
	 * @return Calendar instance.
	 */
	public static Calendar getCalendar(int year, int month, int date) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, date, 0, 0, 0);
		return cal;
	}
	
	/**
	 * Utility method to construct a Calendar instance out of a date string 
	 * of the form "yyyy/mm/dd".
	 * 
	 * @param date Date string.
	 * @return Calendar instance.
	 */
	public static Calendar getCalendar(String date) {
		Scanner sc = new Scanner(date).useDelimiter("/");
		return getCalendar(sc.nextInt(), sc.nextInt()-1, sc.nextInt());
	}
	
	/**
	 * Utility method to get the string representation of any Calendar instance,
	 * using the format "yyyy/mm/dd".
	 * 
	 * @param date Calendar date.
	 * @return String representation.
	 */
	public static String getDate(Calendar date) {
		return sdf.format(date.getTime());
	}
}
