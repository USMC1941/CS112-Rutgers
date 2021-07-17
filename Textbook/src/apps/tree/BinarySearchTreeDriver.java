package apps.tree;

import java.io.*;

import structures.tree.*;

/**
 * This is a driver for the BinarySearchTree class.
 * 
 * @author Sesh Venugopal
 *
 */
public class BinarySearchTreeDriver {
	
	/**
	 * All the actions that can be issued to the driver.
	 *
	 */
	public enum Action { insert, delete, search, max, min, pre, in, post, count, quit }     
	
	/**
	 * Reader for actions issued at terminal.
	 */
	static final BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * BST with id-based keys.
	 */
	static BinarySearchTree<IdItem> idTree = new BinarySearchTree<IdItem>();
	
	/**
	 * BST with name-based keys. 
	 */
	static BinarySearchTree<NameItem> nameTree = new BinarySearchTree<NameItem>();
	
	/**
	 * Visitor for id-based BST. 
	 */
	static Visitor<IdItem> idVisitor = new Visitor<IdItem>();
	
	/**
	 * Visitor for name-based BST.
	 */
	static Visitor<NameItem> nameVisitor = new Visitor<NameItem>();
	
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
     * Adds a new item to the id and name trees.
     * 
     * @throws IOException If there is error reading from terminal.
     */
    static void addItem()
	throws IOException {
		System.out.print("Item Id? => ");
		System.out.flush();
		int id = Integer.parseInt(stdbr.readLine());
		
		System.out.print("Item Name? => ");
		System.out.flush();
		String item = stdbr.readLine();
		
		idTree.insert(new IdItem(id,item));
		nameTree.insert(new NameItem(id,item));
	}
	
	/**
     * Removes an item from the id and name trees.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void removeItem()
	throws IOException {
		System.out.print("Based on id (1) or item (2)? => ");
		System.out.flush();
		int iditem = Integer.parseInt(stdbr.readLine());
		
		if (iditem == 1) {
			System.out.print("Item Id? => ");
			System.out.flush();                               
			int sid = Integer.parseInt(stdbr.readLine());
			IdItem find = new IdItem(sid,null);
			IdNameItem delitem = (IdNameItem)idTree.search(find);
			idTree.delete(find);
			
			// casting doesn't change the object type; a new has to be done
			NameItem newitem = new NameItem(delitem.id, delitem.name);
			nameTree.delete(newitem);
		}
		else {
			System.out.print("Item name? => ");
			System.out.flush();
			String sname = stdbr.readLine();
			NameItem find = new NameItem(0,sname);
			IdNameItem delitem = (IdNameItem)nameTree.search(find);
			nameTree.delete(find);
			
			// casting doesn't change the object type; a new has to be done
			IdItem newitem = new IdItem(delitem.id, delitem.name);
			idTree.delete(newitem);
		}
	}
	
	/**
     * Searches for an item in the id or name tree.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void searchItem()
	throws IOException {
		System.out.print("Based on id (1) or name (2)? => ");
		System.out.flush();
		int iditem = Integer.parseInt(stdbr.readLine());
		
		if (iditem == 1) {
			System.out.print("Item Id? => ");
			System.out.flush();
			int id = Integer.parseInt(stdbr.readLine());
			IdItem newitem = new IdItem(id,null);
			IdNameItem find = (IdNameItem)idTree.search(newitem);
			System.out.println("id = " + find.id + 
					", name = " + find.name);
		}
		else {
			System.out.print("Item Name? => ");
			System.out.flush();
			String item = stdbr.readLine();
			NameItem newitem = new NameItem(0,item);
			IdNameItem find = (IdNameItem)nameTree.search(newitem);
			System.out.println("id = " + find.id + 
					", name = " + find.name);
		}
	}
	
	/**
     * Performs a preorder traversal of the id or name tree.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void preOrder()
	throws IOException {
		System.out.print("Based on id (1) or name (2)? => ");
		System.out.flush();
		int iditem = Integer.parseInt(stdbr.readLine());
		if (iditem == 1)
			idTree.preOrder(idVisitor);
		else
			nameTree.preOrder(nameVisitor);
	}
	
	/**
     * Performs an inorder traversal of the id or name tree.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void inOrder()
	throws IOException {
		System.out.print("Based on id (1) or name (2)? => ");
		System.out.flush();
		int iditem = Integer.parseInt(stdbr.readLine());
		if (iditem == 1)
			idTree.inOrder(idVisitor);
		else
			nameTree.inOrder(nameVisitor);
	}
	
	/**
     * Performs a postorder traversal of the id or name tree.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void postOrder()
	throws IOException {
		System.out.print("Based on id (1) or name (2)? => ");
		System.out.flush();
		int iditem = Integer.parseInt(stdbr.readLine());
		if (iditem == 1)
			idTree.postOrder(idVisitor);
		else
			nameTree.postOrder(nameVisitor);
	}
	
	/**
     * Finds the max-key item in the id or name tree.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void max()
	throws IOException {
		System.out.print("Based on id (1) or name (2)? => ");
		System.out.flush();
		int iditem = Integer.parseInt(stdbr.readLine());
		if (iditem == 1)
			System.out.println("Max = " + idTree.maxKey());
		else
			System.out.println("Max = " + nameTree.maxKey());
	}
	
	
	/**
     * Finds the min-key item in the id or name tree.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void min()
	throws IOException {
		System.out.print("Based on id (1) or name (2)? => ");
		System.out.flush();
		int iditem = Integer.parseInt(stdbr.readLine());
		if (iditem == 1)
			System.out.println("Min = " + idTree.minKey());
		else
			System.out.println("Min = " + nameTree.minKey());
	}
	
	/**
     * Finds the number of items in the id or name tree.
     * 
     * @throws IOException If there is error reading from terminal.
     */
	static void count()
	throws IOException {
		System.out.println(idTree.size());	
	}
	
	/**
	 * Entry point into the driver.
	 * 
	 * @param args No arguments required.
	 * @throws IOException If there is an error in reading from terminal.
	 */
	public static void main(String[] args)
	throws IOException {
		Action act;
		while ((act = getAction()) != Action.quit) {
			switch(act) {
			case insert : addItem();
			break;
			case delete   : removeItem();
			break;
			case search : searchItem();
			break;
			case max : max();
			break;
			case min   : min();
			break;
			case pre: preOrder();
			break;
			case in: inOrder();
			break;
			case post   : postOrder();
			break;
			case count: count();
			break;
			default         : break;
			}
		}
	}
}
