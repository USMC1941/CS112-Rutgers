package bigint;

import java.io.IOException;
import java.util.Scanner;

public class BigTest {

   static Scanner sc;

   public static void parse() throws IOException {
      System.out.print("\tEnter integer => ");
      String integer = sc.nextLine();
      try {
         BigInteger bigInteger = BigInteger.parse(integer);
         System.out.println("\t\tValue = " + bigInteger);
      }
      catch (IllegalArgumentException e) {
         System.out.println("\t\tIncorrect Format");
      }
   }

   public static void add() throws IOException {
      System.out.print("\tEnter first integer => ");
      String     integer         = sc.nextLine();
      BigInteger firstBigInteger = BigInteger.parse(integer);

      System.out.print("\tEnter second integer => ");
      integer = sc.nextLine();
      BigInteger secondBigInteger = BigInteger.parse(integer);

      BigInteger result = BigInteger.add(firstBigInteger, secondBigInteger);
      System.out.println("\t\tSum: " + result);
   }

   public static void multiply() throws IOException {
      System.out.print("\tEnter first integer => ");
      String     integer         = sc.nextLine();
      BigInteger firstBigInteger = BigInteger.parse(integer);

      System.out.print("\tEnter second integer => ");
      integer = sc.nextLine();
      BigInteger secondBigInteger = BigInteger.parse(integer);

      BigInteger result = BigInteger.multiply(firstBigInteger, secondBigInteger);
      System.out.println("\t\tProduct: " + result);

   }

   public static void main(String[] args) throws IOException {
      sc = new Scanner(System.in);

      char choice;
      while ((choice = getChoice()) != 'q') {
         switch (choice) {
            case 'p':
               parse();
               break;
            case 'a':
               add();
               break;
            case 'm':
               multiply();
               break;
            default:
               System.out.println("Incorrect choice");
         }
      }
   }

   private static char getChoice() {
      System.out.print("\n(p)arse, (a)dd, (m)ultiply, or (q)uit? => ");
      String in = sc.nextLine();
      char   choice;
      if (in == null || in.length() == 0) {
         choice = ' ';
      }
      else {
         choice = in.toLowerCase()
                    .charAt(0);
      }
      return choice;
   }
}
