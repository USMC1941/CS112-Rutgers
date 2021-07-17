package linear;

public class RecursiveBinarySearch {

	public static int binarySearch(int[] A, int target, int l, int r) {
		if (l > r) {
			// base case, item not found
			return -1;
		}
		int m = (l + r) / 2;
		if (target == A[m]) {
			return m;
		}
		else {
			if (target < A[m]) {
				return binarySearch(A, target, l, m - 1);
			}
			else {
				return binarySearch(A, target, m + 1, r);
			}
		}
	}

	public static int binarySearch(int[] A, int target) {
		return binarySearch(A, target, 0, A.length - 1);
	}

	public static void main(String[] args) {
		int[] array = {3, 10, 20, 53, 70, 99};
		System.out.println(binarySearch(array, 99));
		System.out.println(binarySearch(array, 77));
	}
}
