package Linear;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	// array input MUST be sorted
	public static <T extends Comparable<T>>
	int binarySearch(T[] arr, T target) {
		int lo=0, hi=arr.length-1;
		while (lo <= hi) {
			int mid=(lo+hi)/2;
			int c = target.compareTo(arr[mid]);
			if (c == 0) {    // target equal to arr[mid]
				return mid;
			}
            if (c < 0) {   // target less than arr[mid]
                hi = mid-1;   // go left
            } else {
                lo = mid+1;   // go right
            }
        }
		return -1;
	}
	
	// public method for recursive version
	public static <T extends Comparable<T>>
	int recursiveBinarySearch(T[] arr, T target) {
		return recursiveBinarySearch(arr, target, 0, arr.length-1);
	}
	
	// recursive version
	private static <T extends Comparable<T>>
	int recursiveBinarySearch(T[] arr, T target, int lo, int hi) {
		if (lo > hi) {    // termination condition
			return -1;
		}
		int mid=(lo+hi)/2;
		
		int c = target.compareTo(arr[mid]);
		if (c == 0) {  // termination condition
			return mid;
		}
		if (c < 0) { // recurse on left half
			return recursiveBinarySearch(arr, target, lo, mid-1);
		} else {   // recurse on right half
			return recursiveBinarySearch(arr, target, mid+1, hi);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter list of SORTED integers, comma separated: ");
		String line = sc.nextLine();
		String[] items = line.split(",");
		Integer[] arr = new Integer[items.length];
		for (int i=0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(items[i]);
		}
		System.out.print("Input array: ");
		System.out.println(Arrays.toString(arr));
		
		System.out.print("Enter target value, 'quit' to stop: ");
		line = sc.nextLine();
		while (!"quit".equals(line)) {
			int target = Integer.parseInt(line);
			int pos = binarySearch(arr, target);
			//int pos = recursiveBinarySearch(arr, target);
			if (pos == -1) {
				System.out.println("Target " + target + " is not in array.");
			} else {
				System.out.println("Target " + target + " is at index " + pos + ".");
			}
			System.out.print("Enter target value, 'quit' to stop: ");
			line = sc.nextLine();
		}
	}
}
