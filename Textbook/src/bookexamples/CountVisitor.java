package bookexamples;

import structures.tree.Visitor;
import structures.tree.BinaryTree;

/**
 * This example shows how to use a specialized structures.tree.Visitor to
 * count number of instances of a given key in a binary tree. See section
 * "A Visitor Class" in the "Binary Tree and General Tree" chapter of the text
 * for a discussion of the Visitor class.
 * 
 * @author Sesh Venugopal
 * 
 * @param <T> Type of objects stored in the binary tree.
 */
public class CountVisitor<T extends Comparable<T>> extends Visitor<T> {
	
	/**
	 * Count of nodes.
	 */
	private int count;
	
	/**
	 * Target key to be matched against binary tree keys.
	 */
	private T key;
	
	/**
	 * Initializes the visitor with target key.
	 * 
	 * @param key Target key
	 */
	public CountVisitor(T key) {
		count=0;
		this.key = key;
	}
	
	/* (non-Javadoc)
	 * @see structures.tree.Visitor#visit(structures.tree.BinaryTree)
	 */
	public void visit(BinaryTree<T> node) {
		if (node.getData().compareTo(key) < 0) count++;
	}
	
	/**
	 * Returns the count.
	 * 
	 * @return Count.
	 */
	public int getCount() {
		return count;
	}
}
