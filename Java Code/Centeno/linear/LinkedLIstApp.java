package linear;

import java.util.NoSuchElementException;

public class LinkedLIstApp {

	public static void main(String[] args) {
	
		LinkedList<String> llS = new LinkedList<String>();
		llS.addToFront("red delicious");
		llS.addToFront("gala");
		llS.addToFront("macintosh");
		llS.traverse();
		System.out.println("Just deleted " + llS.deleteFront());
		llS.traverse();
		System.out.println("Just deleted " + llS.deleteFront());
		llS.traverse();
		System.out.println("Just deleted " + llS.deleteFront());
		llS.traverse();
		
		try {
			System.out.println("Just deleted " + llS.deleteFront());
		} catch (NoSuchElementException e) {
			System.out.println("Well, the list is empty");
		}

		llS.traverse();
	}

}
