package Sorting;

import java.util.Scanner;

public class QuicksortApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter list of integers, comma separated: ");
		String    liststr = sc.next();
		String[]  items   = liststr.split(",");
		Integer[] list    = new Integer[items.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(items[i]);
		}
		System.out.print("Enter insertion sort threshold: ");
		int ist = sc.nextInt();
		System.out.print("Before: ");
		print(list);
		Quicksort.sort(list, ist);
		System.out.print(" After: ");
		print(list);
	}

	private static void print(Integer[] list) {
		System.out.print("[");
		if (list.length > 0) {
			System.out.print(list[0]);
		}
		for (int i = 1; i < list.length; i++) {
			System.out.print("," + list[i]);
		}
		System.out.println("]");
	}

}
