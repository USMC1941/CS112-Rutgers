package tree;

public class BSTNode <T> {

	T key;            /* Node's key */
	BSTNode<T> left;  /* Node's left child */
	BSTNode<T> right; /* Node's right child */
	
	public BSTNode (T key, BSTNode<T> left, BSTNode<T> right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	
	public String toString () {
		// ternary statement    cond ? : 
		return "[" + key + "," +
				(left != null ? left.key : "null") + ", " +
				(right != null ? right.key : "null") + "]";
				
	}
}
