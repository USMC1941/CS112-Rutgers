package solitaire;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements a simplified version of Bruce Schneier's Solitaire Encryption algorithm.
 *
 * @author RU NB CS112
 */
public class Solitaire {

   /**
    * Circular linked list that is the deck of cards for encryption
    */
   CardNode deckRear;

   /**
    * Utility method that prints a circular linked list, given its rear pointer
    *
    * @param rear Rear pointer
    */
   private static void printList(CardNode rear) {
      if (rear == null) {
         return;
      }
      System.out.print(rear.next.cardValue);
      CardNode ptr = rear.next;
      do {
         ptr = ptr.next;
         System.out.print("," + ptr.cardValue);
      }
      while (ptr != rear);
      System.out.println("\n");
   }

   /**
    * Makes a shuffled deck of cards for encryption. The deck is stored in a circular
    * linked list, whose last node is pointed to by the field deckRear
    */
   public void makeDeck() {
      // COMPLETE THIS METHOD
   }

   /**
    * Makes a circular linked list deck out of values read from scanner.
    */
   public void makeDeck(Scanner scanner) throws IOException {
      CardNode cn = null;
      if (scanner.hasNextInt()) {
         cn = new CardNode();
         cn.cardValue = scanner.nextInt();
         cn.next = cn;
         deckRear = cn;
      }
      while (scanner.hasNextInt()) {
         cn = new CardNode();
         cn.cardValue = scanner.nextInt();
         cn.next = deckRear.next;
         deckRear.next = cn;
         deckRear = cn;
      }
   }

   /**
    * Implements Step 1 - Joker A - on the deck.
    */
   void jokerA() {
      // COMPLETE THIS METHOD
   }

   /**
    * Implements Step 2 - Joker B - on the deck.
    */
   void jokerB() {
      // COMPLETE THIS METHOD
   }

   /**
    * Implements Step 3 - Triple Cut - on the deck.
    */
   void tripleCut() {
      // COMPLETE THIS METHOD
   }

   /**
    * Implements Step 4 - Count Cut - on the deck.
    */
   void countCut() {
      // COMPLETE THIS METHOD
   }

   /**
    * Gets a key. Calls the four steps - Joker A, Joker B, Triple Cut, Count Cut, then
    * counts down based on the value of the first card and extracts the next card value
    * as key. But if that value is 27 or 28, repeats the whole process (Joker A through Count Cut)
    * on the latest (current) deck, until a value less than or equal to 26 is found, which is then returned.
    *
    * @return Key between 1 and 26
    */
   int getKey() {
      // COMPLETE THIS METHOD
      // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
      return 0;
   }

   /**
    * Encrypts a message, ignores all characters except upper case letters
    *
    * @param message Message to be encrypted
    * @return Encrypted message, a sequence of upper case letters only
    */
   public String encrypt(String message) {
      // COMPLETE THIS METHOD
      // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
      return null;
   }

   /**
    * Decrypts a message, which consists of upper case letters only
    *
    * @param message Message to be decrypted
    * @return Decrypted message, a sequence of upper case letters only
    */
   public String decrypt(String message) {
      // COMPLETE THIS METHOD
      // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
      return null;
   }
}
