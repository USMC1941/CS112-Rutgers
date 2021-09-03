package Tree;

/** BSTNode only allows objects that implement compareTo */
public class BSTNode<T extends Comparable<T>> {
    T data;
    BSTNode<T> left, right;

    public BSTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
