package bookexamples;

import structures.linear.*;

/**
 * This application exercises the List class. See section "List Class Implementation"
 * for a discussion of the List class.
 * 
 * @author Sesh Venugopal
 *
 */
public class Lister {

	/**
	 * @param args Argumengs to the application - no arguments are needed.
	 */
	public static void main(String[] args) {
		List<String> shoppingList = new List<String>();
		shoppingList.add("Carrots");
		shoppingList.add("Bread");
		shoppingList.add("Milk");
		shoppingList.add("Honey");
		String item = shoppingList.first();
		while (item != null) {
			System.out.println(item);
			item = shoppingList.next();
		}

	}

}
