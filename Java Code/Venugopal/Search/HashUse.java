package Search;

import java.util.HashMap;

class Person {
	String firstName, lastName;
	String email;
	
	public Person(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Person)) {
			return false;
		}
		Person other = (Person)o;
		return email.equals(other.email);
	}
	
	public String toString() {
		return "(" + firstName + " " + lastName + " : " + email + ")";
	}	
	
	// if you use Person as key, then define hashCode on basis of email (key)
	public int hashCode() {
		return email.hashCode();
	}
}

class Point {
	int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	public boolean equals(Point p) {
		BAD BAD IDEA
	}
	*/
	
	public boolean equals(Object o) {
		
		if (o == null || !(o instanceof Point)) {
			return false;
		}
		Point other = (Point)o;
		return x == other.x && y == other.y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	// implement a hashCode method, that overrides the Object class'
	// hashCode method - the trick is to use the String class' hashCode
	// on a string representation of this object
	public int hashCode() {
		return (""+x+y).hashCode();
	}
	
}

public class HashUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// demo with email as key and Person object as value
		HashMap<String,Person> people = new HashMap<String,Person>(500,2.5f);
		String email = "sesh.venugopal@rutgers.edu";
		Person person = new Person("Sesh", "Venugopal", email);
		people.put(email,person);
		// the HashMap put method will call the String class' hashCode method
		// on the email object
		
		// get a value associated with a key
		Person value = people.get(email);   // the returned object will have 
											// the first and last names as well
		System.out.println(value);
		
		// demo with Point object as both key and value
		HashMap<Point,Point> points = new HashMap<Point,Point>(100,0.75f);
		Point[] pointset = {
				new Point(2,3), new Point(2,5), 
				new Point(4,5), new Point(1,6)
		};
		
		for (Point p: pointset) {
			points.put(p, p); 
			/* the HashMap put method calls the key object's 
			 * hashCode method, so, it ends up calling the 
			 * point object's hashCode method
			 */
		}
		
		// now get a value associated with a key
		Point pt = points.get(new Point(4,5));
		System.out.println(pt == null? "point not found" : pt);
		
		
	}

}
