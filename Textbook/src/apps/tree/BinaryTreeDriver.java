package apps.tree;

import structures.tree.*;
import java.io.*;
import java.util.*;

/**
 * This is a driver for the BinaryTree class.
 * 
 * @author Sesh Venugopal
 *
 */
public class BinaryTreeDriver {
	
	/**
	 * All the actions that can be issued to the driver.
	 *
	 */
	public enum Action { create, makeroot, attach, detach, move, display, readfile, showdata, quit }     
	
	/**
	 * Reader to read actions from terminal.
	 */
	static final BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * Binary tree that can hold String data - this is the main tree.
	 */
	static BinaryTree<String> myTree = new BinaryTree<String>();
	
	/**
	 * Binary tree that can hold String data - used as temporary variable to
	 * create nodes to attach to main tree, myTree.
	 */
	static BinaryTree<String> newTree;
	
	/**
	 * Gets the next action issued at the terminal.
	 * 
	 * @return Action issued at terminal. If three incorrect attempts are made,
	 * returns quit.
	 * @throws IOException If there is an error in reading the action.
	 */
	static Action getAction()
	throws IOException {
		int tries=3;
		while (tries > 0) {
			System.out.println();
			System.out.println("Choose one of the following actions:  ");
			for (Action act : Action.values()) {
				System.out.println(act);
			}
			System.out.print("  Enter action => ");
			System.out.flush();
			
			String choice = stdbr.readLine();
			for (Action act : Action.values()) {
				if (choice.trim().equals(act.name())) {
					return act;
				}
			}
			System.out.println("  Incorrect input, try again");
			tries--;
		}
		return Action.quit;
	}
	
	/**
	 * Sets root data for the myTree instance.
	 * 
	 * @throws IOException If there is an error in reading the data.
	 * @throws TreeViolationException If the root already has data.
	 */
	static void firstCreate()
	throws IOException {
		System.out.print("Data for root? => ");
		System.out.flush();
		String item = stdbr.readLine();
		myTree.makeRoot(item);
	}
	
	/**
	 * Creates a new tree, newTree, and sets root data for it.
	 * 
	 * @throws IOException If there is an error in reading the data.
	 * @throws TreeViolationException If the root already has data.
	 */
	static void create()
	throws IOException {
		System.out.print("Data? => ");
		System.out.flush();
		String item = stdbr.readLine();
		newTree = new BinaryTree<String>();
		newTree.makeRoot(item);
	}
	
	/**
	 * Attaches newTree to myTree.
	 * 
	 * @throws IOException If there is an error in reading from terminal.
	 * @throws TreeViolationException If myTree already has a child on the side where
	 *                                attachment is attempted.
	 */
	static void attach()
	throws IOException {
		System.out.print("Left (0) or Right (1)? ==> ");
		System.out.flush();
		int index = Integer.parseInt(stdbr.readLine());
		
		if (index == 0)
			myTree.attachLeft(newTree);
		else
			myTree.attachRight(newTree);
	}
	
	/**
	 * Detaches from myTree.
	 * 
	 * @throws IOException If there is an error in reading from the terminal.
	 */
	static void detach()
	throws IOException {
		System.out.print("Left (0) or Right (1)? ==> ");
		System.out.flush();
		int index = Integer.parseInt(stdbr.readLine());
		
		if (index == 0) 
			newTree = myTree.detachLeft();
		else
			newTree = myTree.detachRight();
	}
	
	/**
	 * Moves from myTree node to left, child, root, or parent
	 * 
	 * @throws IOException If there is an error in reading from the terminal.
	 */
	static void move()
	throws IOException {
		System.out.print("Which direction? 0/1/2/3 for " +
		"Root/leftchild/rightchild/parent => ");
		System.out.flush();
		int index = Integer.parseInt(stdbr.readLine());
		switch (index) {
		case 0 : myTree = myTree.root();
		break;
		case 1 : myTree = myTree.left;
		break;
		case 2 : myTree = myTree.right;
		break;
		case 3 : myTree = myTree.parent;
		break;
		default : break;
		}         
	}
	
	/**
	 * Performs a preorder traversal of a given binary tree, and prints data
	 * stored at each node.
	 * 
	 * @param root Root of the binary tree that is to be traversed.
	 */
	static void preorder(BinaryTree<String> root) {
		if (root != null) {
			System.out.println(root.getData());
			preorder(root.left);
			preorder(root.right);
		}
	}      
	
	/**
	 * Performs an inorder traversal of a given binary tree, and prints data
	 * stored at each node.
	 * 
	 * @param root Root of the binary tree that is to be traversed.
	 */
	static void inorder(BinaryTree<String> root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.getData());
			inorder(root.right);
		}
	}      
	
	
	/**
	 * Performs a non-recursive inorder traversal of a given binary tree. 
	 * When a node is
	 * visited, calls the visit method of the Visitor instance, to take 
	 * client-specific action at that node.
	 * 
	 * @param tree Root of the binary tree that is to be traversed
	 * @param visitor Visitor whose visit method that will be called
	 */
	static void inorder(BinaryTree<String> tree, Visitor<String> visitor) {	
		
		class StackNode {
			BinaryTree<String> node;
			int milestone;
			StackNode(BinaryTree<String> node, int milestone) {
				this.node = node;
				this.milestone = milestone;
			}
		}	

		if (tree == null || tree.isEmpty()) {
			return;
		}
		
		Stack<StackNode> S = new Stack<StackNode>();
		S.push(new StackNode(tree,0));
		while (!S.isEmpty()) {
			StackNode snode = S.pop();
			switch(snode.milestone) {
			case 0: // birth
				snode.milestone = 1;
				S.push(snode);
				if (snode.node.left != null) { // stack left child
					S.push(new StackNode(snode.node.left,0));
				}
				break;
			case 1: // midlife
				snode.milestone = 2;
				S.push(snode);
				visitor.visit(snode.node);
				if (snode.node.right != null) { // stack right child
					S.push(new StackNode(snode.node.right,0));
				}
				break;
			case 2: // done
				break;
			default: break;				
			}
		}
	}  
	
	/**
	 * Performs a postorder traversal of a given binary tree, and prints data
	 * stored at each node.
	 * 
	 * @param root Root of the binary tree that is to be traversed.
	 */
	static void postorder(BinaryTree<String> root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.getData());
		}
	}      
	
	/**
	 * Recursively builds a binary tree from signature
	 * 
	 * @param pre Preorder traversal array.
	 * @param i Current index into preorder traversal.
	 * @param in Inorder traversal array.
	 * @param lo Current start of inorder traversal array.
	 * @param hi Current end of inorder traversal array.
	 * @return Binary tree constructed.
	 */
	static BinaryTree<String> buildTree(String[] pre, int i, String[] in, int lo, int hi) {
		if (i >= pre.length || lo > hi) {
			return null;
		}
		
		BinaryTree<String> myTree = new BinaryTree<String>();
		myTree.makeRoot(pre[i]);
		
		// search for pre[i] in in[lo..hi]
		int j;
		for (j=lo; j <= hi; j++)
			if (pre[i].equals(in[j]))
				break;
		if (j > hi) {
			System.out.println("Error!");
			System.exit(1);
		}
		
		BinaryTree<String> leftSub = buildTree(pre, i+1, in, lo, j-1);
		BinaryTree<String> rightSub = buildTree(pre, i+j-lo+1, in, j+1,hi);
		myTree.attachLeft(leftSub);
		myTree.attachRight(rightSub);
		return myTree;
	}
	
	/**
	 * Reads signature from file and builds a binary tree..
	 * 
	 * @throws IOException If there is an error in reading from file.
	 */
	static void readfile()
	throws IOException {
		System.out.print("File name? => ");
		System.out.flush();
		String file = stdbr.readLine();
		
		Scanner sc = new Scanner(new File(file));
		int numNodes = sc.nextInt();
		String[] preorder = new String[numNodes];
		String[] inorder = new String[numNodes];
		for (int i=0; i < numNodes; i++)
			preorder[i] = sc.next();
		for (int i=0; i < numNodes; i++)
			inorder[i] = sc.next();      
		
		myTree = buildTree(preorder, 0, inorder, 0, numNodes-1);
	}
	
	/**
	 * Displays myTree using a given traversal.
	 * 
	 * @throws IOException If there is an error in reading from terminal.
	 */
	static void display()
	throws IOException {
		System.out.print("Pre(0)/In(1)/Post(2)? => ");
		System.out.flush();
		int index = Integer.parseInt(stdbr.readLine());
		BinaryTree<String> dispTree = myTree.root();
		if (index == 0) preorder(dispTree);
		else if (index == 1) inorder(dispTree);
		else postorder(dispTree);
	}
	
	
	/**
	 * Entry point into the driver.
	 * 
	 * @param args No arguments required.
	 * @throws IOException If there is an input error. 
	 * @throws TreeViolationException If there is a violation of tree structure.
	 */
	public static void main(String[] args)
	throws IOException, TreeViolationException {
		
		Action act;
		while ((act = getAction()) != Action.quit) {
			switch(act) {
			case create : create();
			break;
			case makeroot   : firstCreate();
			break;
			case attach : attach();
			break;
			case detach : detach();
			break;
			case move   : move();
			break;
			case display: display();
			break;
			case readfile: readfile();
			break;
			case showdata   : System.out.println(myTree.getData());
			break;
			default         : break;
			}
		}
	}
}


