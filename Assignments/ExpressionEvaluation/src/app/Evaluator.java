package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Evaluator {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter the expression, or hit return to quit => ");
            String expr = sc.nextLine();
            if (expr.length() == 0) {
                break;
            }
            ArrayList<Variable> vars = new ArrayList<>();
            ArrayList<Array> arrays = new ArrayList<>();
            Expression.makeVariableLists(expr, vars, arrays);

            System.out.print("Enter variable values file name, or hit return if no variables => ");
            String fname = sc.nextLine();
            if (fname.length() != 0) {
                Scanner scfile = new Scanner(new File(fname));
                Expression.loadVariableValues(scfile, vars, arrays);
            }
            System.out.println("Value of expression = " + Expression.evaluate(expr, vars, arrays));
        }
        sc.close();
    }
}
