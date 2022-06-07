package huffman;

/**
 * This class represents a node of a huffman coding tree,
 * and contains a {@link CharFreq} object as its data
 *
 * @author Ishaan Ivaturi
 */
public class TreeNode {
    private CharFreq data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
        data = null;
        left = null;
        right = null;
    }

    public TreeNode(CharFreq d, TreeNode l, TreeNode r) {
        data = d;
        left = l;
        right = r;
    }

    public CharFreq getData() {
        return data;
    }

    public void setData(CharFreq data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
