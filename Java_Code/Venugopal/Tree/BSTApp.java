package Tree;

//User MUST implement the Comparable interface
//which obligates it to implement the compareTo method
class User implements Comparable<User> {
	String lastName;
	String firstName;
	String id;

	public User(String lastName, String firstName, String id) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
	}

	public String toString() {
		return firstName + " " + lastName + "(" + id + ")";
	}

	public int compareTo(User u) {
		return id.compareTo(u.id); // piggyback on String compareTo
	}
}

public class BSTApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<String> bst = new BST<String>();
		bst.insert("spotlight");
		bst.insert("revenant");
		bst.insert("danish girl");
		bst.insert("mad max");
		bst.insert("martian");

		System.out.println(bst.sort());

		bst.delete("danish girl");
		bst.delete("spotlight");
		System.out.println(bst.sort());

		User[] users = new User[3];
		users[0] = new User("Leonardo", "DeCaprio", "lcaprio");
		users[1] = new User("Charlize", "Theron", "ctheron");
		users[2] = new User("Matt", "Damon", "mdamon");

		BST<User> bst2 = new BST<User>();

		bst2.insert(users[0]);
		bst2.insert(users[1]);
		bst2.insert(users[2]);
		System.out.println(bst2.sort());
	}
}
