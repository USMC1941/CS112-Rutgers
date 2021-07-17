package bookexamples;

import structures.linear.OrderedList;
import structures.linear.Merger;
import java.util.Scanner;
import java.io.*;

/**
 * This application exercise the Merge class discussed in section
 * "Merger: A Utility Class" of the text.
 * 
 * @author Sesh Venugopal
 *
 */
public class Merging {

	/**
	 * Prints an ordered list.
	 * 
	 * @param <T> The type parameter for the objects in the ordered list
	 * @param ol The ordered list
	 */
	static <T extends Comparable<T>> void print(OrderedList<T> ol) {
		T item = ol.first();
		if (item == null) return;
		System.out.print(item);
		while ((item = ol.next()) != null) {
			System.out.print(" - " + item);
		}
		System.out.println();
	}
	
	/**
	 * @param args Arguments for the application. There are two arguments, which
	 * 				are the names of the files that contain ordered lists 
	 */
	public static void main(String[] args) 
	throws IOException {
		
		Scanner sc = new Scanner(new File(args[0]));
		OrderedList<Integer> ol1 = new OrderedList<Integer>();
		while (sc.hasNext()) {
			ol1.add(sc.nextInt());
		}
		System.out.print("\nList1: ");
		print(ol1);
		System.out.println();
		
		sc = new Scanner(new File(args[1]));
		OrderedList<Integer> ol2 = new OrderedList<Integer>();
		while (sc.hasNext()) {
			ol2.add(sc.nextInt());
		}
		System.out.print("\nList2: ");
		print(ol2);
		System.out.println();
		
		System.out.print("\nUnion        : ");
		print(Merger.union(ol1, ol2)); 
		System.out.println();
		
		System.out.print("\nDifference   : ");
		print(Merger.difference(ol1, ol2));
		System.out.println();
		
		System.out.print("\nIntersection : ");
		print(Merger.intersection(ol1, ol2));
		System.out.println();
	}
}
