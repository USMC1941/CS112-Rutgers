package structures.tree;

/**
 * This class implements a low-level binary tree structure that can be
 * accessed and manipulated via its nodes and its links. The structure
 * is represented in a recursive fashion, i.e. an instance of this class
 * is really a node object that is the root of a binary tree.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> Type of objects stored in this tree.
 */
public class BinaryTree<T> {
	
	/**
	 * Data stored in a node.
	 */
	protected T data;
	
	/**
	 * Left child of this node.
	 */
	public BinaryTree<T> left;
	
	/**
	 * Right child of this node.
	 */
	public BinaryTree<T> right;
	
	/**
	 * Parent of this node.
	 */
	public BinaryTree<T> parent;
	
	/**
	 * Initializes this binary tree to empty.
	 */
	public BinaryTree() {
		data = null;
		left = null;
		right = null;
		parent = null;
	}
	
	/**
	 * Makes the root node of this binary tree.
	 * 
	 * @param data Data to be stored at this root node.
	 * @throws TreeViolationException If there is already a root node.
	 */
	public void makeRoot(T data) {
		if (this.data != null) {
			throw new TreeViolationException();
		}
		this.data = data;
	}
	
	/**
	 * Sets the data at this node to given data.
	 * 
	 * @param data Data to be written into this node, replacing existing data.
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Returns the data at this node.
	 * 
	 * @return Data at this node.
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Attaches given tree (root node of tree) as the left child of this node.
	 * 
	 * @param tree Tree (root node) to be attached.
	 * @throws TreeViolationException If this node already has a left child.
	 */
	public void attachLeft(BinaryTree<T> tree) { 
		if (left != null) {
			throw new TreeViolationException();
		}
		if (tree != null) {
			tree.parent = this;
			left = tree;
		}
	}
	
	/**
	 * Attaches given tree (root node of tree) as the right child of this node.
	 * 
	 * @param tree Tree (root node) to be attached.
	 * @throws TreeViolationException If this node already has a right child.
	 */
	public void attachRight(BinaryTree<T> tree) {
		if (right != null) {
			throw new TreeViolationException();
		}
		if (tree != null) {
			tree.parent = this;
			right = tree;
		}
	}
	
	/**
	 * Detaches and returns the left child of this node.
	 * 
	 * @return Left child of this node.
	 */
	public BinaryTree<T> detachLeft() {
		BinaryTree<T> retleft = left;
		left = null;
		return retleft;
	}
	
	/**
	 * Detaches and returns the right child of this node.
	 * 
	 * @return Right child of this node.
	 */
	public BinaryTree<T> detachRight() {
		BinaryTree<T> retright = right;
		right = null;
		return retright;
	}
	
	/**
	 * Tells whether this tree is empty or not.
	 * 
	 * @return True if this is tree is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return data == null;
	}
	
	/**
	 * Empties this tree by removing all nodes including root. To start over,
	 * the makeRoot method must be called.
	 */
	public void clear() {
		left = null;
		right = null;
		data = null;
		parent = null;
	}
	
	/**
	 * Returns the root of the tree that contains this node.
	 * 
	 * @return Root of the tree.
	 */
	public BinaryTree<T> root() {
		if (parent == null) { // this itself is the root
			return this;
		}
		BinaryTree<T> nextParent = parent;
		while (nextParent.parent != null) {
			nextParent = nextParent.parent;
		}
		return nextParent;
	}
}


