package Sorting;

public class Heapsort {

    /** prevent objects being created */
    private Heapsort() {}

    public static <T extends Comparable<T>> void sort(T[] list) {
        // build heap, linear time
        for (int k = (list.length - 2) / 2; k >= 0; k--) {
            siftDown(list, k, list.length);
        }
        // sort
        for (int n = list.length; n > 1; n--) {
            // swap max and last
            T max = list[0];
            list[0] = list[n - 1];
            list[n - 1] = max;
            // sift down from 0, in sub array of length n-1
            siftDown(list, 0, n - 1);
        }
    }

    private static <T extends Comparable<T>> void siftDown(T[] list, int k, int n) {
        // not a leaf, there is at least a left child
        while (2 * k + 1 < n) {
            // set maxIndex to left child index
            int maxIndex = 2 * k + 1;
            int rightChild = maxIndex + 1;
            // there is a right child
            if (rightChild < n) {
                int c = list[rightChild].compareTo(list[maxIndex]);
                if (c > 0) {
                    maxIndex = rightChild;
                }
            }
            int c = list[maxIndex].compareTo(list[k]);
            // max child greater than k, switch
            if (c > 0) {
                T temp = list[maxIndex];
                list[maxIndex] = list[k];
                list[k] = temp;
                k = maxIndex; // for next iteration
            } else {
                break;
            }
        }
    }
}
