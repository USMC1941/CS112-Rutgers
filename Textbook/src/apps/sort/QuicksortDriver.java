package apps.sort;

import java.io.*;
import java.util.*;

/**
 * This is a driver for the Quicksort class.
 * 
 * @author Sesh Venugopal
 *
 */
class QuicksortDriver {
	
	/**
	 * Buffered reader to read from standard input.
	 */
	static BufferedReader stdbr = new BufferedReader(
				new InputStreamReader(System.in));
	
	/**
	 * The list to be sorted.
	 */
	static Integer[] list;

	/**
	 * Entry point for the driver.
	 * 
	 * @param args No arguments needed
	 * @throws IOException If there is an error in I/O
	 */
	public static void main(String[] args)
	throws IOException {
		System.out.print("Enter name of file containing integers to be sorted => ");
		Scanner sc = new Scanner(new File(stdbr.readLine()));
		ArrayList<Integer> alist = new ArrayList<Integer>();
		while (sc.hasNextInt()) {
			alist.add(new Integer(sc.nextInt()));
		}
		
		list = new Integer[alist.size()];
		list = alist.toArray(list);
		Quicksort.sort(list);

		for (int i=0; i < list.length; i++) {				
			System.out.println(list[i]);
		}
	}
}

