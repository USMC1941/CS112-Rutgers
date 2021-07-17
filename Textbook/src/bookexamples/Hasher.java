package bookexamples;

import java.util.HashMap;

/**
 * An example that shows how to use the HashMap class. See section
 * "The java.util.HashMap Class" in the text.
 * 
 * @author Sesh Venugopal
 */
public class Hasher {

	/**
	 * @param args No arguments needed.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> phoneBook = new HashMap<String,String>(101);
		phoneBook.put("nancy","247-7257");
		phoneBook.put("bill","647-9096");
		phoneBook.put("samir","545-8192");
		String phone = phoneBook.get("nellie");
		System.out.println("samir's phone = " + phone);
		phone = phoneBook.put("samir","545-0092");
		System.out.println("samir's old phone = " + phone);
		phone = phoneBook.get("samir");
		System.out.println("samir's new phone = " + phone);
		
	}

}
