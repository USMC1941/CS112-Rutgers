package apps.linear;

import java.io.*;
import java.util.Scanner;
import java.util.Calendar;

/**
 * An application that involves expenses.
 * 
 * @author Sesh Venugopal
 *
 */
public class ExpenseApp {
	
	/**
	 * A budget list of expenses.
	 */
	static ExpenseList budget;
	
	/**
	 * Buffered reader to read from standard input.
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Reads expenses from a budget file.
	 * 
	 * @param budgetFile File that contains expenses
	 * @throws IOException If there is an error in reading the file
	 */
	static void readExpenses(String budgetFile) 
	throws IOException {				
		Scanner sc = new Scanner(new File(budgetFile));
		while (sc.hasNext()) {
			budget.add(new Expense(Expense.getCalendar(sc.next()),sc.nextFloat(),sc.next()));
			
		}
		sc.close();
	}
	
	/**
	 * Prints the expense details in budget list.
	 * 
	 * @throws IOException If there is an error in printing
	 */
	static void printDetails() 
	throws IOException {
		System.out.println("Expense List: ");
		System.out.println();
		
		Expense exp = budget.first();
		while (exp != null) {
			System.out.println(exp);
			exp = budget.next();
		}
		
		System.out.println();
		System.out.println("Max expense = " + budget.maxExpense());
		System.out.println("Min expense = " + budget.minExpense());
		System.out.println("Avg expense = " + budget.avgExpense());
		System.out.println("Expense on Clothes = " +
				budget.amountSpentOn("Clothes"));
		System.out.print("Enter start date => ");
		Calendar startDate = Expense.getCalendar(br.readLine());
		System.out.print("Enter end date => ");
		Calendar endDate = Expense.getCalendar(br.readLine());
		System.out.println("Expense between " + Expense.getDate(startDate) +
							" and " + Expense.getDate(endDate) + " = " +
				budget.amountSpentDuring(startDate, endDate));
		System.out.println();
	}
	
	/**
	 * Entry point to the application.
	 * 
	 * @param args One argument is needed - the name of the budget file
	 * @throws IOException If there is any I/O error
	 */
	public static void main(String[] args)
	throws IOException {
		budget = new ExpenseList();
		readExpenses(args[0]);
		printDetails();
	}
}

