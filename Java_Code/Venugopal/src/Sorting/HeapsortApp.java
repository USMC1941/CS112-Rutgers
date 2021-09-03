package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapsortApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter list of integers, comma separated: ");
        String liststr = sc.next();
        sc.close();
        String[] items = liststr.split(",");
        Integer[] list = new Integer[items.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(items[i]);
        }
        System.out.print("Before: ");
        System.out.println(Arrays.toString(list));

        Heapsort.sort(list);

        System.out.print(" After: ");
        System.out.println(Arrays.toString(list));
    }
}
