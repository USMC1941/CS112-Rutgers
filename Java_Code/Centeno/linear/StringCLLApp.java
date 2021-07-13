package linear;

public class StringCLLApp {

	public static void main(String[] args) {
		StringCLL list = new StringCLL();
		list.addToFront("apple");
		list.addToFront("pear");
		list.addToFront("orange");
		list.traverse();
		list.deleteFront();
		list.traverse();
	}
}
