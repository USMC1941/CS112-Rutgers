package tree;

public class BSTNode<T> {

    /** Node's key */
    T key;

    /** Node's left child */
    BSTNode<T> left;

    /** Node's right child */
    BSTNode<T> right;

    public BSTNode(T key, BSTNode<T> left, BSTNode<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        // ternary statement    cond ? :
        return "["
                + key
                + ","
                + (left != null ? left.key : "null")
                + ", "
                + (right != null ? right.key : "null")
                + "]";
    }
}
