package apps.sort;

/**
 * This class implements quicksort on a generic array of entries that can
 * be compared for relative ordering. It is a utility class that has only
 * static methods, and cannot be instantiated.
 * 
 * @author Sesh Venugopal
 *
 */
public class Quicksort {
	
	/**
	 * Prevents instantiation.
	 */
	private Quicksort() { } 
	
	/**
	 * Called by client to sort a list.
	 * 
	 * @param <T> Type of entries in list.
	 * @param list Array of entries.
	 */
	public static <T extends Comparable<T>> void sort(T[] list) {
		// sort for subarrays of length > 10
		quick(list, 0, list.length-1);
		
		// cleanup with insertion sort
		insertSort(list);
	}
	
	/**
	 * Recursive quicksort, helper to the sort method.
	 * 
	 * @param <T> Type of entries in list.
	 * @param list Subarray of entries.
	 * @param lo Index of first entry of subarray.
	 * @param hi Index of last entry of subarray.
	 */
	static <T extends Comparable<T>> void quick(T[] list, int lo, int hi) {
		if ((hi - lo) > 10) {
			int splitPoint = split(list, lo, hi);
			quick(list, lo, splitPoint-1);
			quick(list, splitPoint+1, hi);
		}
	}
	
	/**
	 * Splits a subarray of entries.
	 * 
	 * @param <T> Type of entries in subarray.
	 * @param list Subarray of entries.
	 * @param lo Index of first entry of subarray.
	 * @param hi Index of last entry of subarray.
	 */
	static <T extends Comparable<T>> int split(T[] list, int lo, int hi) {
		// find median index
		int median = getMedian(list, lo, hi);
		
		// swap median and lo values
		T temp = list[lo];
		list[lo] = list[median];
		list[median] = temp;
		
		T pivot = list[lo];
		
		// scan through the array
		int left = lo+1;
		int right = hi;
		
		while (left <= right) {
			while (left <= hi && left <= right) {
				if (list[left].compareTo(pivot) >= 0) break;
				left++;
			}
			while (right > lo && left <= right) {
				if (list[right].compareTo(pivot) < 0) break;
				right--;
			}
			if (left < right) {
				temp = list[left];
				list[left] = list[right];
				list[right] = temp;
				left++;
				right--;
			}
		}
		
		// move the pivot to the splitpoint
		temp = list[right];
		list[right] = list[lo];
		list[lo] = temp;
		
		return right;
	}
	
	/**
	 * Gets the median value of a subarray of entries.
	 * 
	 * @param <T> Type of entries in subarray.
	 * @param list Subarray of entries.
	 * @param lo Index of first entry of subarray.
	 * @param hi Index of last entry of subarray.
	 */
	static <T extends Comparable<T>> int getMedian(T[] list, int lo, int hi) {
		int mid = (lo+hi)/2;
		
		T low = list[lo];
		T high = list[hi];
		T middle = list[mid];
		
		if (low.compareTo(middle) < 0) {
			if (middle.compareTo(high) < 0) {
				return mid;
			} else if (low.compareTo(high) < 0) {
				return hi;
			} else {
				return lo;
			}
		} else {
			if (low.compareTo(high) < 0) {
				return lo;
			} else if (middle.compareTo(high) < 0) {
				return hi;
			} else { 
				return mid;
			}
		}
	}
	
	/**
	 * Insertion sort to clean up subarrays of size <= 10
	 * 
	 * @param <T> Type of entries in list.
	 * @param list Array of entries.
	 */
	static <T extends Comparable<T>> void insertSort(T[]list) {
		for (int i=0; i < list.length; i++) {
			int j = i-1;
			T insertVal = list[i];
			while (j >= 0) {
				if (insertVal.compareTo(list[j]) >= 0) break;
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = insertVal;
		}
	}
}
