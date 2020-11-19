package lse;

import java.io.*;
import java.util.*;

/**
 * This class builds an index of keywords. Each keyword maps to a set of documents in
 * which it occurs, with frequency of occurrence in each document. Once the index is built,
 * the documents can searched on for keywords.
 */
public class LittleSearchEngine {

   /**
    * This is a hash table of all keywords. The key is the actual keyword, and the associated value is
    * an array list of all occurrences of the keyword in documents. The array list is maintained in descending
    * order of occurrence frequencies.
    */
   HashMap<String, ArrayList<Occurrence>> keywordsIndex;

   /**
    * The hash table of all noise words - mapping is from word to itself.
    */
   HashMap<String, String> noiseWords;

   /**
    * Creates the keyWordsIndex and noiseWords hash tables.
    */
   public LittleSearchEngine() {
      keywordsIndex = new HashMap<>(1000, 2.0f);
      noiseWords = new HashMap<>(100, 2.0f);
   }

   /**
    * This method indexes all keywords found in all the input documents. When this
    * method is done, the keywordsIndex hash table will be filled with all keywords,
    * each of which is associated with an array list of Occurrence objects, arranged
    * in decreasing frequencies of occurrence.
    *
    * @param docsFile       Name of file that has a list of all the document file names, one name per line
    * @param noiseWordsFile Name of file that has a list of noise words, one noise word per line
    * @throws FileNotFoundException If there is a problem locating any of the input files on disk
    */
   public void makeIndex(String docsFile, String noiseWordsFile) throws FileNotFoundException {
      // load noise words to hash table
      Scanner sc = new Scanner(new File(noiseWordsFile));
      while (sc.hasNext()) {
         String word = sc.next();
         noiseWords.put(word, word);
      }

      // index all keywords
      sc = new Scanner(new File(docsFile));
      while (sc.hasNext()) {
         String                      docFile = sc.next();
         HashMap<String, Occurrence> kws     = loadKeyWords(docFile);
         mergeKeyWords(kws);
      }

   }

   /**
    * Scans a document, and loads all keywords found into a hash table of keyword occurrences
    * in the document. Uses the getKeyWord method to separate keywords from other words.
    *
    * @param docFile Name of the document file to be scanned and loaded
    * @return Hash table of keywords in the given document, each associated with an Occurrence object
    * @throws FileNotFoundException If the document file is not found on disk
    */
   public HashMap<String, Occurrence> loadKeyWords(String docFile) throws FileNotFoundException {
      HashMap<String, Occurrence> keywordIndexForOneDoc = new HashMap<>(1000, 2.0f);  // New HashMap
      //
      Scanner scanner = new Scanner(new File(docFile));
      while (scanner.hasNext()) {
         String oneWord = scanner.next();
         oneWord = getKeyWord(oneWord);
         if (oneWord != null) {                             // Start process only if the word is a keyword
            Occurrence oneOcc = keywordIndexForOneDoc.get(oneWord);
            if (oneOcc != null) {                           // Keyword found before
               oneOcc.frequency++;                          // Increase frequency
            }
            else {                                          // Keyword not found before
               oneOcc = new Occurrence(docFile, 1);
               keywordIndexForOneDoc.put(oneWord, oneOcc);
            }
         }
      }
      //
      return keywordIndexForOneDoc;
   }

   /**
    * Merges the keywords for a single document into the master keywordsIndex
    * hash table. For each keyword, its Occurrence in the current document
    * must be inserted in the correct place (according to descending order of
    * frequency) in the same keyword's Occurrence list in the master hash table.
    * This is done by calling the insertLastOccurrence method.
    *
    * @param kws Keywords hash table for a document
    */
   public void mergeKeyWords(HashMap<String, Occurrence> kws) {
      for (Map.Entry<String, Occurrence> entry : kws.entrySet()) {
         String     keyWord    = entry.getKey();
         Occurrence occurrence = entry.getValue();
         //
         ArrayList<Occurrence> lst = keywordsIndex.get(keyWord);
         if (lst != null) {                     // Key from document to be merged in the keywordsIndex already
            lst.add(occurrence);                // Put the occurrence in the last of the Occurrence list
            insertLastOccurrence(lst);          // Sort the updated list back into descending order
         }
         else {                                 // Key not in the keywordsIndex yet
            lst = new ArrayList<>();            // Create new list
            lst.add(occurrence);                // Add the occurrence to the list
            keywordsIndex.put(keyWord, lst);    // Put the lst into the keywordsIndex
         }
      }
   }

   /**
    * Given a word, returns it as a keyword if it passes the keyword test,
    * otherwise returns null. A keyword is any word that, after being stripped of any
    * TRAILING punctuation, consists only of alphabetic letters, and is not
    * a noise word. All words are treated in a case-INsensitive manner.
    * <p>
    * Punctuation characters are the following: '.', ',', '?', ':', ';' and '!'
    *
    * @param word Candidate word
    * @return Keyword (word without trailing punctuation, LOWER CASE)
    */
   public String getKeyWord(String word) {
      word = word.toLowerCase();

      // Trim off any punctuation at the end
      while (true) {
         if (word.length() == 0) {   // If input is only punctuation
            break;
         }
         //
         char lastChar = word.charAt(word.length() - 1);
         if (lastChar == '.' || lastChar == ',' || lastChar == '?' || lastChar == ':' || lastChar == ';' || lastChar == '!') {
            word = word.substring(0, word.length() - 1);
         }
         else {
            break;
         }
      }

      // Check if any non-alphabetical characters are in the word
      for (int i = 0; i < word.length(); i++) {
         char oneChar = word.charAt(i);
         if (!Character.isLetter(oneChar)) {
            word = null;
            break;
         }
      }

      // Checks if the word is a noise word
      if (word != null && noiseWords.containsKey(word)) {
         word = null;
      }

      // Checks if the token only contains punctuation. Ex: "!!!!!"
      if (word != null && word.length() == 0) {
         word = null;
      }
      //
      return word;
   }

   /**
    * Inserts the last occurrence in the parameter list in the correct position in the
    * same list, based on ordering occurrences on descending frequencies. The elements
    * 0..n-2 in the list are already in the correct order. Insertion of the last element
    * (the one at index n-1) is done by first finding the correct spot using binary search,
    * then inserting at that spot.
    *
    * @param occs List of Occurrences
    * @return Sequence of mid point indexes in the input list checked by the binary search process,
    * null if the size of the input list is 1. This returned array list is only used to test
    * your code - it is not used elsewhere in the program.
    */
   public ArrayList<Integer> insertLastOccurrence(ArrayList<Occurrence> occs) {
      ArrayList<Integer> listOfMidpoints = new ArrayList<>();
      //
      int frequencyToInsert = occs.get(occs.size() - 1).frequency;
      //
      int lowerBound = 0;
      int upperBound = occs.size() - 2;
      //
      int midpoint;
      int indexToInsert;
      while (true) {                                              // Perform binary search for place to insert
         midpoint = (upperBound + lowerBound) / 2;
         listOfMidpoints.add(midpoint);

         Occurrence occMidpoint = occs.get(midpoint);

         // Hit the midpoint
         if (occMidpoint.frequency == frequencyToInsert) {
            indexToInsert = midpoint;
            break;
         }
         // Searching in left
         else if (occMidpoint.frequency < frequencyToInsert) {
            upperBound = midpoint - 1;             // It's in the left of the midpoint
            if (lowerBound > upperBound) {
               // At this time, could not find while searching to left in
               // lowerBound = upperBound. Insert into current
               indexToInsert = midpoint;
               break;
            }
         }
         // Searching in right
         else {
            lowerBound = midpoint + 1;             // It's in the right of the midpoint
            if (lowerBound > upperBound) {
               // At this time, could not find while searching to the right at
               // lowerBound = upperBound. Insert into the next one to the right.
               indexToInsert = midpoint + 1;
               break;
            }
         }
      }

      // Perform insertion if need to. If the new Occurrence is in the right place already, do nothing
      if (indexToInsert != occs.size() - 1) {
         Occurrence temp = occs.get(occs.size() - 1);            // Remember the last one in the list
         occs.remove(occs.size() - 1);                           // Remove the last one from the list
         occs.add(indexToInsert, temp);                          // Insert the remembered one into correct spot
      }
      //
      return listOfMidpoints;
   }

   /**
    * Search result for "kw1 or kw2". A document is in the result set if kw1 or kw2 occurs in that
    * document. Result set is arranged in descending order of occurrence frequencies. (Note that a
    * matching document will only appear once in the result.) Ties in frequency values are broken
    * in favor of the first keyword. (That is, if kw1 is in doc1 with frequency f1, and kw2 is in doc2
    * also with the same frequency f1, then doc1 will appear before doc2 in the result.
    * The result set is limited to 5 entries. If there are no matching documents, the result is null.
    *
    * @param kw1 First keyword
    * @param kw2 Second keyword
    * @return List of NAMES of documents in which either kw1 or kw2 occurs, arranged in descending order of
    * frequencies. The result size is limited to 5 documents. If there are no matching documents,
    * the result is null.
    */
   public ArrayList<String> top5search(String kw1, String kw2) {
      kw1 = kw1.toLowerCase();
      kw2 = kw2.toLowerCase();
      //
      HashMap<String, String> docReturned = new HashMap<>();          // Prevent document show up more than once in the result
      ArrayList<String>       lstOutput   = new ArrayList<>();        // Return search result
      //
      // Get lists for kw1 and kw2
      ArrayList<Occurrence> occ1 = keywordsIndex.get(kw1);
      ArrayList<Occurrence> occ2 = keywordsIndex.get(kw2);
      //
      // Initialize starting point for loop
      // -1 means stop searching, because either keyword not found in document or reach the end of
      // the list. Otherwise, start from 0.
      int index1 = (occ1 == null) ? -1 : 0;
      int index2 = (occ2 == null) ? -1 : 0;

      // Continue if the limit (5) is not reached yet and there is still something there
      while ((lstOutput.size() < 5) && (index1 >= 0 || index2 >= 0)) {
         Occurrence first = index1 >= 0 ? occ1.get(index1) : null;
         Occurrence second;
         if ((index2 >= 0)) {
            if (occ2 != null) {
               second = occ2.get(index2);
            }
            else {
               second = null;
            }
         }
         else {
            second = null;
         }

         // Get one with highest frequency from the head of occ1 and occ2.
         // occ1 have higher priority if lists have same frequency
         Occurrence oneOcc;
         if (first == null) {                         // Only first is null
            oneOcc = second;                          // This is the next highest frequency occurrence. Get it from the list.
            index2++;                                 // Move the index to the next one.
         }
         else if (second == null) {                   // Only second is null
            oneOcc = first;
            index1++;
         }
         else {                                        // First and second are both not null
            // First takes priority (thus the = here) if first and second have equal frequencies
            if (first.frequency >= second.frequency) {
               oneOcc = first;
               index1++;
            }
            else {
               oneOcc = second;
               index2++;
            }
         }

         // If document is not already returned, return it. Otherwise, ignore it.
         if (oneOcc != null) {
            if (!docReturned.containsKey(oneOcc.document)) {
               //lstOutput.add(oneOcc.toString());         // Returns both document and frequency

               lstOutput.add(oneOcc.document);             // Returns only document

               docReturned.put(oneOcc.document, oneOcc.document);
            }
            // Otherwise, do nothing. Doc is already in the output list
         }
         //
         // Mark it -1 if the end is reached
         if (index1 >= 0 && index1 == occ1.size()) {                   // Reach the end of the list. Stop searching.
            index1 = -1;
         }
         if (occ2 != null && index2 >= 0 && index2 == occ2.size()) {   // Reach the end of the list. Stop searching.
            index2 = -1;
         }
      }
      //
      return (lstOutput.size() == 0) ? null : lstOutput;  // If there are no matching documents, the result is null
   }
}
