package bookexamples;

import java.util.Scanner;
import java.io.*;
import structures.tree.*;

/**
 * This is an example that shows how the Heap class can be used for sorting. See
 * section "Sorting with the Heap Class" in the text.
 * 
 * @author Sesh Venugopal
 *
 */
public class HeapSort {

	/**
	 * @param args A single argument - name of file that contains integers to be sorted
	 */
	public static void main(String[] args) 
	throws IOException {
		Scanner sc = new Scanner(new File(args[0]));
		int n = sc.nextInt();
		Heap<Integer> sortHeap = new Heap<Integer>(n);
		for (int i=0; i < n; i++) {
			int val = sc.nextInt();
			sortHeap.add(val);
		}
		System.out.println("\t");
		while (!sortHeap.isEmpty()) {
			System.out.print(sortHeap.deleteMax() + "  ");
		}
		System.out.println();
	}
}
