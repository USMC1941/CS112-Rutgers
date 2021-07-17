package bookexamples;

import structures.linear.OrderedList;
import structures.linear.Merger;
import java.util.Scanner;
import java.io.*;

/**
 * This is a sample implementation of consolidating two ordered lists. See
 * section "List Consolidation Using OrderedList" in the text for a discussion.
 * 
 * @author Sesh Venugopal
 *
 */
public class Consolidate {

	/**
	 * Prints an ordered list to standard output.
	 * 
	 * @param <T> The type parameter for objects in the ordered list
	 * @param ol The ordered list
	 */
	static <T extends Comparable<T>> void printList(OrderedList<T> ol) {
		T item = ol.first();
		if (item == null) return;
		System.out.print(item);
		while ((item = ol.next()) != null) {
			System.out.print(" - " + item);
		}
		System.out.println();
	}
	
	/**
	 * @param args Arguments to the program. These are the the names of files that 
	 * 				contain the lists to be merged, in this order: your insert list,
	 * 				your roommate's insert list, your delete list, your roommate's
	 * 				delete list
	 * 			
	 */
	public static void main(String[] args) 
	throws IOException {
		
		Scanner sc = new Scanner(new File(args[0]));
		OrderedList<String> YInsList = new OrderedList<String>();
		while (sc.hasNext()) {
			YInsList.add(sc.next());
		}
		sc = new Scanner(new File(args[1]));
		OrderedList<String> RmInsList = new OrderedList<String>();
		while (sc.hasNext()) {
			RmInsList.add(sc.next());
		}
		sc = new Scanner(new File(args[2]));
		OrderedList<String> YDelList = new OrderedList<String>();
		while (sc.hasNext()) {
			YDelList.add(sc.next());
		}
		sc = new Scanner(new File(args[3]));
		OrderedList<String> RmDelList = new OrderedList<String>();
		while (sc.hasNext()) {
			RmDelList.add(sc.next());
		}
		
		OrderedList<String> MergedInsList = Merger.union(YInsList, RmInsList);
		OrderedList<String> MergedDelList = Merger.union(YDelList, RmDelList);
		OrderedList<String> FinalList = Merger.difference(MergedInsList, MergedDelList);
		printList(FinalList);
	}
}
