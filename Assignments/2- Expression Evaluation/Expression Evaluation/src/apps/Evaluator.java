package apps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Evaluator {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("\nEnter the expression, or hit return to quit => ");
			String line = sc.nextLine();
			if (line.length() == 0) {
				break;
			}
			Expression expr = new Expression(line);
			expr.buildSymbols();

			System.out.print("Enter symbol values file name, or hit return if no symbols => ");
			line = sc.nextLine();
			if (line.length() != 0) {
				Scanner scfile = new Scanner(new File(line));
				expr.loadSymbolValues(scfile);
				//expr.printScalars();
				//expr.printArrays();
			}
			System.out.println("Value of expression = " + expr.evaluate());
		}
		sc.close();
	}
}
