package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * Binary Search Tree (BST)
 * Duplicates not allowed
 * Comparable requires T objects to implement compareTo
 * 
 * Comparable is an interface that imposes a total ordering on the objects
 * of the class that implements it.
 * An interface is not a class, it defines a set of variables and methods.
 */
public class BST <T extends Comparable<T>> {
	
	BSTNode<T> root;
	int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	public void insert (T key) {
		// 1. search for the key until it fails
		BSTNode<T> ptr = root;
		BSTNode<T> p = null;
		int c = 0;
		while (ptr != null) {
			c = key.compareTo(ptr.key);
			if (c == 0) { // equal
				throw new IllegalArgumentException(key + " already in BST");
			}
			p = ptr;
			if (c < 0) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
		}
		// 2. create new node and insert it 
		BSTNode<T> node = new BSTNode(key, null, null);
		if (p == null) {
			// empty tree
			root = node;
		} else if (c < 0) {
			p.left = node;
		} else {
			p.right = node;
		}
		size++;
	}
	public void delete (T key) {
		// 1. find node to delete (call it x)
		BSTNode<T> x = root;
		BSTNode<T> p = null; // parent
		int c = 0;
		while (x != null) {
			c = key.compareTo(x.key);
			if (c == 0) {
				// found key
				break;
			}
			p = x;
			x = (c < 0) ? x.left : x.right;
		}
		// 2. x is not found
		if (x == null) {
			throw new NoSuchElementException(key + " not found");
		}
		// 3. check case 3 first
		BSTNode<T> y = null; // will hold x's inorder predecessor
		if (x.left != null && x.right != null) {
			y = x.left;
			p = x;
			while (y.right != null) {
				p = y;
				y = y.right;
			}
			// copy y's key over x
			x.key = y.key;
			
			// prepare to remove y
			x = y;
		}
		// 4. x is the root
		if (p == null) {
			root = (x.left != null) ? x.left : x.right;
			size--;
			return;
		}
		// 5. handle case 1 and 2 in the same code
		// tmp is the x's child (in case of one child)
		BSTNode<T> tmp = (x.right != null) ? x.right : x.left;
		if (x == p.left) {
			p.left = tmp;
		} else {
			p.right = tmp;
		}
		size--;
	}

	/*
	 * Static becuase it does not use the BST object's root.
	 * Every recursive call gets its own root.
	 * 
	 * Also, need to define T separately for the static method since
	 * it does NOT fall under the scope of the object 
	 */
	private static <T extends Comparable> void inorder (BSTNode<T> root, ArrayList<T> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		list.add(root.key);
		inorder(root.right, list);
	}
	/*
	 * Treesort algorithm to sort an array.
	 * 1. Insert every element from the array into a BST
	 * 2. Add back elements to array as we traverse the BST inorder
	 */
	public static <T extends Comparable<T>> void treeSort (ArrayList<T> array) {
		// create bst and insert array items
		BST<T> bst = new BST<T>();
		for (int i = 0; i < array.size(); i++) {
			bst.insert(array.get(i));
		}
		// clean up the initial array
		array.clear(); 
		// call inorder to traverse the BST and put items back into array
		inorder(bst.root, array);
	}
	public static void main (String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(
				Arrays.asList(67,35,90,56,70,14,40));
		treeSort(array);
		System.out.println(array);
	}
}
