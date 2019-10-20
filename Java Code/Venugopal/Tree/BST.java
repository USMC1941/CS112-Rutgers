package Tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// 1. BST does not allow duplicates
// 2. BST requires T objects to implement compareTo
public class BST<T extends Comparable<T>> {
	BSTNode<T> root;
	int        size;

	public BST() {
		root = null;
		size = 0;
	}

	public T search(T key) {
		BSTNode<T> ptr = root;
		while (ptr != null) {
			int c = key.compareTo(ptr.data);
			if (c == 0) {
				return ptr.data;
			}
			/*
			if (c < 0) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
			*/
			// above if-else can be written using the "ternary"
			// operator like this
			ptr = c < 0 ? ptr.left : ptr.right;
		}
		return null;
	}

	// duplicates not allowed
	public void insert(T data) throws IllegalArgumentException {
		BSTNode<T> ptr = root, prev = null;
		int        c   = 0;
		while (ptr != null) {
			c = data.compareTo(ptr.data);
			if (c == 0) {
				throw new IllegalArgumentException("duplicate key, not inserted");
			}
			prev = ptr;
			ptr = c < 0 ? ptr.left : ptr.right;
		}

		// prev is at the node to which new node must be attached
		BSTNode<T> tmp = new BSTNode<T>(data);
		if (prev == null) { // tree was empty
			root = tmp;
			size++;
			return;
		}
		if (c < 0) {
			prev.left = tmp;
		}
		else {
			prev.right = tmp;
		}
		size++;
	}

	public T delete(T key) throws NoSuchElementException {
		// search and locate
		BSTNode<T> x = root, p = null;   // x tracks, p is lagging parent
		int        c;
		while (x != null) {
			c = key.compareTo(x.data);
			if (c == 0) {
				break;
			}
			p = x;
			x = c < 0 ? x.left : x.right;
		}
		if (x == null) {
			throw new NoSuchElementException();
		}

		T hold = null;  // to return

		// case 3
		if (x.right != null && x.left != null) {
			// find y, inorder predecessor of x
			BSTNode<T> y = x.left;  // left turn first
			p = x;
			while (y.right != null) {  // keep turning right until dead end
				p = y;
				y = y.right;
			}
			hold = x.data;   // for returning later
			x.data = y.data; // write y's data into x
			x = y;   // so that we can slide down, and delete x in case 1 or case 2
		}
		/*
		if(x.right == null){
			if(p.right==x){
				p.right = x.left
			}
			else{
				p.left = x.left;
			}
		}
		else{
			if(p.right == x){
				p.right = x.right;
			}
			else{
				p.left = x.right;
			}
		}
		*/

		// what if x is the root?
		if (p == null) {  // no parent
			root = x.left == null ? x.right : x.left;  // works for both case 1 and case 2
			size--;
			return hold;
		}

		if (p.right == x) {
			p.right = x.right == null ? x.left : x.right;
		}
		else {
			p.left = x.right == null ? x.left : x.right;
		}

		size--;
		return hold;

	}

	private void inorder(BSTNode<T> root, ArrayList<T> list) {
		if (root == null) {
			return;
		}

		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}

	public ArrayList<T> sort() {
		ArrayList<T> list = new ArrayList<T>(size);
		inorder(this.root, list);
		return list;
	}
}
