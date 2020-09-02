package poly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polytest {
   static BufferedReader br1, br2;
   static Polynomial p1, p2;

   public static final int ADD      = 1;
   public static final int MULTIPLY = 2;
   public static final int EVALUATE = 3;
   public static final int QUIT     = 4;

   public static int getChoice() throws IOException {
      System.out.println();
      System.out.println(ADD + ". ADD polynomial");
      System.out.println(MULTIPLY + ". MULTIPLY polynomial");
      System.out.println(EVALUATE + ". EVALUATE polynomial");
      System.out.println(QUIT + ". QUIT");
      System.out.print("\tEnter choice # => ");
      return (Integer.parseInt(br1.readLine()));
   }

   public static void add() throws IOException {
      System.out.print("Enter the file containing the polynomial to add => ");
      br2 = new BufferedReader(new FileReader(br1.readLine()));
      p2 = new Polynomial(br2);
      System.out.println("\n" + p2 + "\n");
      System.out.println("Sum: " + p1.add(p2) + "\n");
   }

   public static void multiply() throws IOException {
      System.out.print("Enter the file containing the polynomial to multiply  => ");
      br2 = new BufferedReader(new FileReader(br1.readLine()));
      p2 = new Polynomial(br2);
      System.out.println("\n" + p2 + "\n");
      System.out.println("Product: " + p1.multiply(p2) + "\n");
   }

   public static void evaluate() throws IOException {
      System.out.print("Enter the evaluation point x  => ");
      float x = Float.parseFloat(br1.readLine());
      System.out.println("Value at " + x + ": " + p1.evaluate(x) + "\n");
   }

   public static void main(String[] args) throws IOException {
      br1 = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter the name of the polynomial file => ");
      br2 = new BufferedReader(new FileReader(br1.readLine()));

      p1 = new Polynomial(br2);
      System.out.println("\n" + p1 + "\n");

      int choice = getChoice();
      while (choice != QUIT) {
         if (choice < 1 || choice > QUIT) {
            System.out.println("\tIncorrect choice " + choice);
         }
         else {
            switch (choice) {
               case ADD:
                  add();
                  break;
               case MULTIPLY:
                  multiply();
                  break;
               case EVALUATE:
                  evaluate();
                  break;
               default:
                  break;
            }
         }
         choice = getChoice();
      }

   }
}
