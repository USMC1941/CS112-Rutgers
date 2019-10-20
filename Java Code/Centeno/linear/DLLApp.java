package linear;

public class DLLApp {

	public static void main(String[] args) {
		DLL<String> dll = new DLL<String>();
		dll.addToFront("blue");
		dll.addToFront("scarlet");
		dll.addToFront("yellow");
		dll.traverse();
		dll.addAfter("scarlet", "green");
		dll.traverse();
		dll.delete("green");
		dll.traverse();
		dll.delete("scarlet");
		dll.traverse();
		dll.delete("yellow");
		dll.traverse();
	}
}
