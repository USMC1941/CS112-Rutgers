package apps.tree;

import structures.tree.BinaryTree;
import structures.linear.Queue;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class implements a Huffman tree.
 *
 * @author Sesh Venugopal
 *
 */
public class Huffman {
	
	/**
	 * All the symbols that are to be coded.
	 */
	char[] symbols;	   
	
	/**
	 * Probabilities of occurrence of the symbols.
	 */
	float[] probs;     
	
	/**
	 * Leaf nodes in huffman tree at which symbols are stored. 
	 */
	ArrayList<BinaryTree<Float>> locations;  
	
	/**
	 * Huffman codes for the symbols.
	 */
	String[] codes;    
	
	/**
	 * Queue of leaf nodes.
	 */
	Queue<BinaryTree<Float>> leaves;
	
	/**
	 * Queue of subtrees.
	 */
	Queue<BinaryTree<Float>> trees;
	
	/**
	 * Root of Huffman tree.
	 */
	BinaryTree<Float> huffman;
	
	/**
	 * Builds a Huffman tree out of a given set of symbols and their probabilities
	 * of occurrence.
	 * 
	 * @param symbols Symbols to be coded.
	 * @param probs Probabilities of occurrence of symbols.
	 */
	public Huffman(char[] symbols, float[] probs) {
		this.symbols = symbols;
		this.probs = probs;
		locations = new ArrayList<BinaryTree<Float>>(symbols.length);
		
		// if there are no symbols, build empty tree
		if (symbols.length == 0) {
			huffman = null;
			return;
		}
		
		// if there is only one symbol, create a tree with root
		// and left child, and return
		if (symbols.length == 1) {
			BinaryTree<Float> leaf = new BinaryTree<Float>();
			leaf.makeRoot(0f);
			locations.add(leaf);
			huffman = new BinaryTree<Float>();
			huffman.makeRoot(probs[0]);
			huffman.attachLeft(leaf);
			return;
		}
		
		leaves = new Queue<BinaryTree<Float>>();
		trees = new Queue<BinaryTree<Float>>();
		
		// build the queue of leaf nodes
		buildLeaves();
		
		// extract first two leaf nodes
		BinaryTree<Float> first = leaves.dequeue();
		BinaryTree<Float> second = leaves.dequeue();
		
		// build new tree and add to queue trees
		buildTree(first, second);
		
		// now the rest of the huffman tree construction
		buildAll();
		
		// and now for the final tree
		huffman = trees.dequeue();
		
		// finally, read off and store the codes
		processCodes();
	}
	
	/**
	 * Builds leaf nodes for all symbols. In each leaf node is the index of
	 * the corresponding symbol in the locations array. The locations entry at
	 * this index is also made to point to this leaf node. All leaves are enqueued
	 * in the leaf nodes queue.
	 * 
	 */
	void buildLeaves() {
		for (int i=0; i < symbols.length; i++) {
			BinaryTree<Float> leaf = new BinaryTree<Float>();
			leaf.makeRoot((float)i);
			locations.add(leaf);
			leaves.enqueue(leaf);
		}
	}
	
	/**
	 * Selects the minimum probability tree (node) out of the trees at the front of
	 * the leaves and trees queues, respectively,and removes the selected tree from its queue.
	 * 
	 * @return Minimum probability tree.
	 */
	BinaryTree<Float> selectMin() {
		BinaryTree<Float> first = leaves.first();
		BinaryTree<Float> second = trees.first();
		
		float prob1 = getProb(first);
		float prob2 = getProb(second);
		if (prob1 < prob2) {
			leaves.dequeue();
			return first;
		} else {
			trees.dequeue();
			return second;
		}
	}
	
	/**
	 * Gets the probability from the given tree node. If the node is a leaf,
	 * the index it contains is used to get the probability from the probs array,
	 * otherwise the probability value in the node is returned.
	 * 
	 * @param tree Tree node for which probability is extracted.
	 * @return Probability value.
	 */
	float getProb(BinaryTree<Float> tree) {
		if (tree.left == null && tree.right == null) { // leaf 
			float index = tree.getData();
			return probs[(int)index];
		}
		return tree.getData();
	}
	
	/**
	 * Builds a tree by creating a root and attaching the first and second
	 * given nodes as left and right children of the root, and enqueues the
	 * new root into the trees queue.
	 * 
	 * @param first To be attached as left child of new root.
	 * @param second To be attached as right child of new root.
	 */
	void buildTree(BinaryTree<Float> first, BinaryTree<Float> second) {
		float prob1 = getProb(first);
		float prob2 = getProb(second);
		
		BinaryTree<Float> both = new BinaryTree<Float>();
		both.makeRoot(prob1 + prob2);
		both.attachLeft(first);
		both.attachRight(second);
		trees.enqueue(both);
	}
	
	/**
	 * Builds the Huffman tree out of the leaves and trees queues.
	 */
	void buildAll() {
		while (!leaves.isEmpty()) {
			BinaryTree<Float> first = selectMin();
			BinaryTree<Float> second = null;
			if (!leaves.isEmpty()) {
				second = selectMin();
			} else {
				second = trees.dequeue();
			}
			buildTree(first, second);
		}
		
		while (trees.size() > 1) {
			BinaryTree<Float> first = trees.dequeue();
			BinaryTree<Float> second = trees.dequeue();
			buildTree(first, second);
		}
	}
	
	/**
	 * Gets the height of the given tree.
	 * 
	 * @param tree Tree for which height is to be found.
	 * @return Height of tree. Empty tree's height is -1.
	 */
	int treeHeight(BinaryTree<Float> tree) {
		if (tree == null) {
			return -1;
		}
		return Math.max(treeHeight(tree.left), treeHeight(tree.right)) + 1;
	}
	
	/**
	 * Computes codes for all the symbols and fills them into the codes array. 
	 */
	void processCodes() {
		int height = treeHeight(huffman);
		char[] codeString = new char[height];
		
		codes = new String[symbols.length];
		
		// use locations to access a leaf and go towards the root
		// filling in the code backwards in codeString
		for (int i=0; i < locations.size(); i++) {
			int index = height;
			BinaryTree<Float> node = locations.get(i);
			BinaryTree<Float> parent = node.parent;
			while (parent != null) {
				index--;
				if (node == parent.left) {
					codeString[index] = '0';
				} else {
					codeString[index] = '1';
				}
				node = parent;
				parent = node.parent;
			}
			// create a String from codeString and fill in codes
			codes[i] = new String(codeString, index, height-index);
		}
	}
	
	/**
	 * Returns the Huffman code for the given symbol.
	 * 
	 * @param symbol Symbol for which code is requested.
	 * @return Huffman code for symbol.
	 * @throws NoSuchElementException If given symbol does not exist in this tree.
	 */
	public String getCode(char symbol) {
		int i;
		for (i=symbols.length-1; i >= 0; i--) {
			if (symbol == symbols[i]) break;
		}
		if (i < 0) {
			throw new NoSuchElementException();
		}
		return codes[i];
	}
	
	/**
	 * Decodes into text a given binary coded string that was originally coded using the 
	 * codes generated by this Huffman tree.
	 * 
	 * @param code Binary coded string.
	 * @return Decoded text.
	 */
	public String decode(String code) {
		StringBuffer decoded = new StringBuffer();
		int i=0;
		while (i < code.length()) {
			BinaryTree<Float> node = huffman;
			while (node.left != null || node.right != null) {
				if (code.charAt(i++) == '0') {
					node = node.left;
				} else {
					node = node.right;
				}
			}
			// reached a leaf node
			float index = node.getData();
			decoded.append(symbols[(int)index]);
		}
		return decoded.toString();
	}
}



