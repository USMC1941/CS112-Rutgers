package linear;

public class BinarySearch {

	public static int binarySearch(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (target == A[m]) {
				return m;
			}
			else {
				if (target < A[m]) {
					// target is on the lower half of the array
					r = m - 1;
				}
				else {
					// target is on the upper half of the array
					l = m + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = {3, 10, 20, 53, 70, 99};
		System.out.println(binarySearch(array, 99));
		System.out.println(binarySearch(array, 77));
	}
}
