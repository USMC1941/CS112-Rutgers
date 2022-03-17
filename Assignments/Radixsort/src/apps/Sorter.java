package apps;

import structures.Node;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sorter {

    public static void main(String[] args) throws IOException {

        Scanner sysin = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String inFile = sysin.next();

        // create new Radixsort object, using default constructor
        Radixsort rs = new Radixsort();

        // sort the items in the input file
        Scanner sc = new Scanner(new File(inFile));
        Node<String> output = rs.sort(sc);

        // print output
        System.out.println("\nSorted Result:");
        printCLL(output);
    }

    /** Prints the items in a CLL */
    public static <T> void printCLL(Node<T> rear) {
        if (rear == null) {
            return;
        }
        Node<T> ptr = rear;
        do {
            ptr = ptr.next;
            System.out.println(ptr.data);
        } while (ptr != rear);
        System.out.println();
    }
}
