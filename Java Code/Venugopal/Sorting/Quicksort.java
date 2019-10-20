package Sorting;

public class Quicksort {

	// prevent object creation
	private Quicksort() {
	}

	private static <T extends Comparable<T>> int split(T[] list, int lo, int hi) {
		T   pivot = list[lo];
		int left  = lo + 1;
		int right = hi;
		while (true) {
			while (left <= right) {
				if (list[left].compareTo(pivot) < 0) {
					left++;
				}
				else {
					break;
				}
			}
			while (right > left) {
				if (list[right].compareTo(pivot) < 0) {
					break;
				}
				else {
					right--;
				}
			}
			if (left >= right) {
				break;
			}

			// swap left with right
			T temp = list[left];
			list[left] = list[right];
			list[right] = temp;
			// update left and right
			left++;
			right--;
		}
		// swap pivot with list[right]
		list[lo] = list[left - 1];
		list[left - 1] = pivot;
		return left - 1;
	}

	private static <T extends Comparable<T>> void sort(T[] list, int lo, int hi, int ist) {
		// insertion sort if subarray size is less than threhsold
		if ((hi - lo + 1) < ist) {
			insertionSort(list, lo, hi);
			return;
		}
		// pick pivot as median of first, middle, last
		int mid = lo + (hi - lo) / 2;
		int clm = list[lo].compareTo(list[mid]);
		int clh = list[lo].compareTo(list[hi]);
		int cmh = list[mid].compareTo(list[hi]);
		int mdn = -1;
		if (clm > 0) {
			if (clh > 0) {
				if (cmh > 0) {
					mdn = mid;
				}
				else {
					mdn = hi;
				}
			}
			else {
				mdn = lo;
			}
		}
		else {
			if (cmh > 0) {
				if (clh > 0) {
					mdn = lo;
				}
				else {
					mdn = hi;
				}
			}
			else {
				mdn = mid;
			}
		}
		// switch median with first, before calling split
		if (mdn != lo) {
			T temp = list[lo];
			list[lo] = list[mdn];
			list[mdn] = temp;
		}
		// call split
		int sp = split(list, lo, hi);
		// recursive on left and right sub-arrays, 
		// do smaller sub-array first
		if ((sp - lo) < 2) {
			sort(list, sp + 1, hi, ist);
			return;
		}
		if ((hi - sp) < 2) {
			sort(list, lo, sp - 1, ist);
			return;
		}
		// pick smaller first
		if ((sp - lo) < (hi - sp)) {
			sort(list, lo, sp - 1, ist);
			sort(list, sp + 1, hi, ist);
		}
		else {
			sort(list, sp + 1, hi, ist);
			sort(list, lo, sp - 1, ist);
		}
	}

	public static <T extends Comparable<T>> void sort(T[] list, int insertionSortThreshold) {
		if (list.length <= 1) {
			return;
		}
		sort(list, 0, list.length - 1, insertionSortThreshold);
	}

	private static <T extends Comparable<T>> void insertionSort(T[] list, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			int index;
			for (index = i; index > lo; index--) {
				if (list[i].compareTo(list[index - 1]) > 0) {
					break;
				}
			}
			// we have the index position for insert
			T temp = list[i];
			for (int j = i; j > index; j--) {
				list[j] = list[j - 1];
			}
			list[index] = temp;
		}
	}
}
