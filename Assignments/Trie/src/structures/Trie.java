package structures;

import java.util.ArrayList;

/**
 * This class implements a compressed trie. Each node of the tree is a
 * CompressedTrieNode, with fields for indexes, first child and sibling.
 *
 * @author Sesh Venugopal
 */
public class Trie {

   /** Words indexed by this trie. */
   ArrayList<String> words;

   /** Root node of this trie. */
   TrieNode root;

   /**
    * Initializes a compressed trie with words to be indexed, and root node set to
    * null fields.
    */
   public Trie() {
      root = new TrieNode(null, null, null);
      words = new ArrayList<>();
   }

   private static void print(TrieNode root, int indent, ArrayList<String> words) {
      if (root == null) {
         return;
      }
      for (int i = 0; i < indent - 1; i++) {
         System.out.print("    ");
      }

      if (root.substr != null) {
         System.out.println("      " + words.get(root.substr.wordIndex));
      }

      for (int i = 0; i < indent - 1; i++) {
         System.out.print("    ");
      }
      System.out.print(" ---");
      System.out.println("(" + root.substr + ")");

      for (TrieNode ptr = root.firstChild; ptr != null; ptr = ptr.sibling) {
         for (int i = 0; i < indent - 1; i++) {
            System.out.print("    ");
         }
         System.out.println("     |");
         print(ptr, indent + 1, words);
      }
   }

   /**
    * Inserts a word into this trie. Converts to lower case before adding. The word
    * is first added to the words array list, then inserted into the trie.
    *
    * @param word Word to be inserted.
    */
   public void insertWord(String word) {
      /** COMPLETE THIS METHOD * */
   }

   /**
    * Given a string prefix, returns its "completion list", i.e. all the words in
    * the trie that start with this prefix. For instance, if the tree had the words
    * bear, bull, stock, and bell, the completion list for prefix "b" would be
    * bear, bull, and bell; for prefix "be" would be bear and bell; and for prefix
    * "bell" would be bell. (The last example shows that a prefix can be an entire
    * word.) The order of returned words DOES NOT MATTER. So, if the list contains
    * bear and bell, the returned list can be either [bear,bell] or [bell,bear]
    *
    * @param prefix Prefix to be completed with words in trie
    * @return List of all words in tree that start with the prefix, order of words
    *         in list does not matter. If there is no word in the tree that has
    *         this prefix, null is returned.
    */
   public ArrayList<String> completionList(String prefix) {
      /** COMPLETE THIS METHOD * */

      /** FOLLOWING LINE IS A PLACEHOLDER FOR COMPILATION * */
      /** REPLACE WITH YOUR IMPLEMENTATION * */
      return null;
   }

   public void print() {
      print(root, 1, words);
   }
}
