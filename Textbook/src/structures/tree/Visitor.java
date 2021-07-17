package structures.tree;

/**
 * This class implements a genericc visitor that can take some client-specific
 * action when a binary tree node is visited. This (default) implementation
 * of Visitor simply prints the node data.
 * 
 * @author Sesh Venugopal
 *
 */
public class Visitor<T> {
	
	/**
	 * Visits (prints) data at a binary tree node.
	 * 
	 * @param node Binary tree node
	 */
	public void visit(BinaryTree<T> node) {
		System.out.println(node.getData());
	}
}
