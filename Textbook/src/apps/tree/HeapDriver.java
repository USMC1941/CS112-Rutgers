package apps.tree;

import structures.tree.Heap;

import java.io.*;

/**
 * This is a driver for the Heap class.
 * 
 * @author Sesh Venugopal
 *
 */
public class HeapDriver {
	
	/**
	 * All the actions that can be issued to the driver.
	 *
	 */
	public enum Action { add, remove, display, size, clear, quit }
	
	/**
	 * Reader to read actions from terminal.
	 */
	static final BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * Heap that is populated with HeapItem<String> instances 
	 */
	static Heap<HeapItem<String>> myHeap = new Heap<HeapItem<String>>();
	
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
			System.out.print("Choose one of the following actions:  ");
			for (Action act : Action.values()) {
				System.out.print(act+ "   ");
			}
			System.out.print("\n\tEnter action => ");
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
	 * Adds an item to the heap.
	 * 
	 * @throws IOException If there is an error reading from terminal.
	 */
	static void addItem()
	throws IOException {
		System.out.print("Item Name? => ");
		System.out.flush();
		String item = stdbr.readLine();
		
		System.out.print("Item Priority? => ");
		System.out.flush();                               
		int sid = Integer.parseInt(stdbr.readLine());
		
		myHeap.add(new HeapItem<String>(item,sid));
	}
	
	/**
	 * Removed the item at the top of the heap.
	 * 
	 * @throws IOException If there is an error reading from terminal.
	 */
	static void removeItem()
	throws IOException {
		HeapItem<String> delItem = myHeap.deleteMax();
		System.out.println("Deleted " + delItem);
	}
	
	/**
	 * Displays all items in the heap.
	 * 
	 * @throws IOException If there is an error reading from terminal.
	 */
	static void displayAllItems() {
		System.out.println();
		HeapItem<String> obj = myHeap.first();
		while (obj != null) {
			System.out.println(obj);
			obj = myHeap.next();
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)
	throws IOException {
		Action act;
		while ((act = getAction()) != Action.quit) {
			switch(act) {
			case add: addItem(); break;
			case remove: removeItem(); break;
			case display: displayAllItems(); break;
			case size: System.out.println("Size = " + myHeap.size()); break;
			case clear: myHeap.clear(); break;
			default: break;
			}
		}
	}
}
