package structures;

/**
 * This class encapsulates the set of 3 indexes that point to a substring 
 * stored in an array of strings. The array of strings is the collection of
 * words that are indexed by the trie. Each node of the trie will have an
 * instance of Indexes.
 * 
 * Example: consider the words "have", "hit", "see", "data" stored in an
 * array in that order. Then, the substring "ave" in "have" will be indexed
 * by the triplet (0,1,3) ["have" is at position 0 in the array, 1 is the index
 * of character 'a' in "have" and 3 is the index of character 'e' in "have"]. 
 * Similarly, substring "ee" in the word "see" will be indexed by the triplet
 * (2,1,2). 
 * 
 * Substrings may be single characters, as in the first "a" in "data", 
 * which will be indexed by the triplet (3,1,1), or the second "a" in "data", 
 * which will be indexes by the triplet (3,3,3)
 * 
 * 
 * @author Sesh Venugopal
 *
 */
class Indexes {
	
	/**
	 * Index into the word collection array.
	 */
	int wordIndex;
	
	/**
	 * Start index of substring in word.
	 */
	short startIndex;
	
	/**
	 * End index of substring in word.
	 */
	short endIndex;
	
	/**
	 * Initializes this instance with all indexes.
	 * 
	 * @param wordIndex Index of word in array of words
	 * @param startIndex Starting index of substring
	 * @param endIndex Ending index of substring
	 */
	public Indexes(int wordIndex, short startIndex, short endIndex) {
		this.wordIndex = wordIndex;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + wordIndex + "," + startIndex + "," + endIndex + ")";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Indexes)) {
			return false;
		}
		Indexes oi = (Indexes)o;
		return wordIndex == oi.wordIndex &&
				startIndex == oi.startIndex &&
				endIndex == oi.endIndex;
	}
}

/**
 * This class encapsulates a compressed trie node with fields for the following:
 * - an Indexes instance, pointing to the substring that is held at that node
 * - the first child node
 * - the sibling node
 * 
 * @author Sesh Venugopal
 *
 */
public class TrieNode {

	/**
	 * Substring held at this node (could be a single character)
	 */
	Indexes substr;
	
	/**
	 * First child of this node
	 */
	TrieNode firstChild;
	
	/**
	 * Sibling of this node
	 */
	TrieNode sibling;
	
	/**
	 * Initializes this trie node with substring, first child, and sibling
	 * 
	 * @param substr Substring held at this node
	 * @param firstChild First child of this node
	 * @param sibling Sibling of this node
	 */
	public TrieNode(Indexes substr, TrieNode firstChild, TrieNode sibling) {
		this.substr = substr;
		this.firstChild = firstChild;
		this.sibling = sibling;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return substr.toString();
	}
	
}
