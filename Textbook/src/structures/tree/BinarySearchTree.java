package structures.tree;

import structures.linear.OrderViolationException;
import java.util.NoSuchElementException;

/**
 * This class implements a simple (not balanced) generic binary search tree. Duplicate keys
 * are not permitted.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of data stored in the nodes of the tree, must implement
 * 				Comparable<T> with the compareTo method.
 */
public class BinarySearchTree<T extends Comparable<T>> {
	
	/**
	 * Binary tree component which maintains the tree structure.
	 */
	BinaryTree<T> tree;
	
	/**
	 * Number of entries in this BST.
	 */
	int size;
	
	/**
	 * Initializes this BST instance to empty.
	 */
	public BinarySearchTree() {
		tree = new BinaryTree<T>();
		size = 0;
	}
	
	/**
	 * Tells whether this BST is empty or not.
	 * 
	 * @return True if this BST is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return tree.isEmpty();
	}
	
	/**
	 * Implements a recursive binary search on a binary (search) tree given its
	 * root, looking for a given key.  
	 * 
	 * @param root Root of binary (search) tree to be searched.
	 * @param key Key that is searched for.
	 * @return The binary (search) tree node whose data matches the key, null if no match
	 * 			is found for the key in the tree.
	 */
	protected BinaryTree<T> recursiveSearch(BinaryTree<T> root, T key) {
		if (root == null) {
			return null;
		}
		int c = key.compareTo(root.data);
		if (c == 0) {
			return root;
		}
		if (c < 0) {
			return recursiveSearch(root.left, key);
		} else {
			return recursiveSearch(root.right, key);
		}
	}
	
	/**
	 * Searches this BST for a given key.
	 * 
	 * @param key Key that is searched for.
	 * @return Data entry in this BST that matches the given key, null if no match is
	 * 			found for the key in this BST.
	 */
	public T search(T key) {
		if (tree.isEmpty()) { 
			return null;
		}
		return recursiveSearch(tree, key).data;
	}
	
	/**
	 * Inserts a given item into this BST.
	 * 
	 * @param item Item to be inserted.
	 * @throws OrderViolationException If there is already a key in this BST that matches
	 * 								this item, i.e. inserting would result in duplicate keys.
	 */
	public void insert(T item) {
		
		if (tree.isEmpty()) { // insert here
			tree.makeRoot(item);
			size++;
			return;
		}
		
		// do an iterative descent
		BinaryTree<T> root = tree;
		boolean done=false;
		BinaryTree<T> newNode = null;
		while (!done) {
			int c = item.compareTo(root.data);
			if (c == 0) { // duplicate found, cannot be inserted
				throw new OrderViolationException();
			}
			if (c < 0) { // insert in left subtree
				if (root.left == null) { // insert here as left child
					newNode = new BinaryTree<T>();
					root.left = newNode;
					done=true;
				} else { // go further down left subtree
					root = root.left;
				}
			} else { // insert in right subtree
				if (root.right == null) { // insert here as right child 
					newNode = new BinaryTree<T>();
					root.right = newNode;
					done=true;
				} else { // go further down right subtree
					root = root.right;
				}
			}
		}
		// set fields of new node
		newNode.data = item;
		newNode.parent = root;
		size++;
	}
	
	/**
	 * Attaches a given tree node to the parent of another node which is deleted
	 * after this method. The attachment to the parent node will be on the side at
	 * which the to-be-deleted node is.
	 * 
	 * @param deleteNode Node whose parent will receive new node as right or left child,
	 * 					depending on whether this node is its parent's right or left child. 
	 * @param attach The node to be attached to parent of deleteNode.
	 */
	protected void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach) {
		
		// deleteNode has only one subtree, attach
		BinaryTree<T> parent = deleteNode.parent;
		deleteNode.clear();  // clear the fields
		if (parent == null) {
			return;
		}
		if (deleteNode == parent.left) {
			// left child of parent, attach as left subtree
			parent.detachLeft();
			parent.attachLeft(attach);
			return;
		}
		// attach as right subtree
		parent.detachRight();
		parent.attachRight(attach);
	}
	
	/**
	 * Returns the node that is the inorder predecessor of a given node, with the
	 * precondition that the given node has a non-null left child.
	 * 
	 * @param node Node whose inorder predecessor is to be found.
	 * @return Inorder predecessor of given node.
	 */
	protected BinaryTree<T> findPredecessor(BinaryTree<T> node) {
		if (node.left == null) {
			return null;
		}
		BinaryTree<T> pred = node.left; // turn left once
		while (pred.right != null) { // keep turning right
			pred = pred.right;
		}
		return pred;
	}
	
	/**
	 * Deletes from this BST the item that matches the given key,and returns the item.
	 * 
	 * @param key Key of to-be-deleted item.
	 * @return The deleted item.
	 * @throws NoSuchElementException If there is no item in this BST that matches the given key.
	 */
	public T delete(T key) {
		if (tree.isEmpty()) { // can't delete from an empty tree
			throw new NoSuchElementException();
		}
		
		// find node containing key 
		BinaryTree<T> deleteNode = recursiveSearch(tree, key);
		if (deleteNode == null) { // data not found, can't delete
			throw new NoSuchElementException();
		}
		
		BinaryTree<T> hold;
		
		// case c: deleteNode has exactly two subtrees
		if (deleteNode.right != null && deleteNode.left != null) {
			hold = findPredecessor(deleteNode);
			deleteNode.data = hold.data;
			deleteNode = hold; // fall through to case a or b
		}
		
		// case a: deleteNode is a leaf
		if (deleteNode.left == null && deleteNode.right == null) {
			deleteHere(deleteNode, null);
			size--;
			return deleteNode.data;
		}		
		
		// case b: deleteNode has exactly one subtree
		if (deleteNode.right != null) {
			hold = deleteNode.right;
			deleteNode.right = null;
		} else {
			hold = deleteNode.left;
			deleteNode.left = null;
		}
		
		deleteHere(deleteNode,hold);
		if (tree == deleteNode) { // root deleted
			tree = hold;
		}
		size--;
		return deleteNode.data;
	}
	
	/**
	 * Finds the minimum-valued key item in this BST.
	 * 
	 * @return Item in this BST that has the minimum of all key values.
	 * @throws NoSuchElementException If this BST is empty.
	 */
	public T minKey() {
		if (tree.data == null) { // tree empty, can't find min value
			throw new NoSuchElementException();
		}
		
		BinaryTree<T> root = tree;
		T min=root.data;
		root = root.left;  // turn left once
		while (root != null) {  // keep going left to leftmost node
			min = root.data;
			root = root.left;
		}
		return min;
	}
	
	/**
	 * Finds the maximum-valued key item in this BST.
	 * 
	 * @return Item in this BST that has the maximum of all key values.
	 * @throws NoSuchElementException If this BST is empty.
	 */
	public T maxKey() {
		if (tree.getData() == null) { // tree empty, can't find max value
			throw new NoSuchElementException();
		}
		
		BinaryTree<T> root=tree;
		T max=root.data;
		root = root.right;  // turn right once
		while (root != null) { // keep going to rightmost node
			max = root.data;
			root = root.right;
		}
		return max;
	}
	
	/**
	 * Returns the number of items in this BST.
	 * 
	 * @return Number of items in this BST.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Implements a recursive preorder traversal on a binary (search) tree given
	 * its root, calling the given visitor's visit method when a node is visited.
	 * 
	 * @param root Root of binary (search) tree on which preorder traversal is performed.
	 * @param visitor Visitor instance in which client-specific visit action is defined.
	 */
	protected void recursivePreOrder(BinaryTree<T> root, Visitor<T> visitor) {
		if (root != null) {
			visitor.visit(root);
			recursivePreOrder(root.left, visitor);
			recursivePreOrder(root.right, visitor);
		}
	}
	
	/**
	 * Implements a preorder traversal on this BST,
	 * calling the given visitor's visit method when a node is visited.
	 * 
	 * @param visitor Visitor instance in which client-specific visit action is defined.
	 */
	public void preOrder(Visitor<T> visitor) {
		if (tree.isEmpty()) {
			return;
		}
		recursivePreOrder(tree, visitor);
	}
	
	/**
	 * Implements a recursive inorder traversal on a binary (search) tree given
	 * its root, calling the given visitor's visit method when a node is visited.
	 * 
	 * @param root Root of binary (search) tree on which inorder traversal is performed.
	 * @param visitor Visitor instance in which client-specific visit action is defined.
	 */
	protected void recursiveInOrder(BinaryTree<T> root, Visitor<T> visitor) {
		if (root != null) {
			recursiveInOrder(root.left, visitor);
			visitor.visit(root);
			recursiveInOrder(root.right, visitor);
		}
	}
	
	/**
	 * Implements an inorder traversal on this BST,
	 * calling the given visitor's visit method when a node is visited.
	 * 
	 * @param visitor Visitor instance in which client-specific visit action is defined.
	 */
	public void inOrder(Visitor<T> visitor) {
		if (tree.isEmpty()) {	
			return;
		}
		recursiveInOrder(tree, visitor);
	}
	
	/**
	 * Implements a recursive postorder traversal on a binary (search) tree given
	 * its root, calling the given visitor's visit method when a node is visited.
	 * 
	 * @param root Root of binary (search) tree on which postorder traversal is performed.
	 * @param visitor Visitor instance in which client-specific visit action is defined.
	 */
	protected void recursivePostOrder(BinaryTree<T> root, Visitor<T> visitor) {
		if (root != null) {
			recursivePostOrder(root.left, visitor);
			recursivePostOrder(root.right, visitor);
			visitor.visit(root);
		}
	}
	
	/**
	 * Implements a postorder traversal on this BST,
	 * calling the given visitor's visit method when a node is visited.
	 * 
	 * @param visitor Visitor instance in which client-specific visit action is defined.
	 */
	public void postOrder(Visitor<T> visitor) {
		if (tree.isEmpty()) {
			return;
		}
		recursivePostOrder(tree, visitor);
	}
}
