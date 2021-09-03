package hash;

import java.util.HashMap;

class Contact {
    String firstName, lastName;
    String email;

    public Contact(String first, String last, String email) {
        this.firstName = first;
        this.lastName = last;
        this.email = email;
    }

    public String toString() {
        return firstName + " " + lastName + ", " + email;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) o;
        return this.email.equals(other.email);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point other = (Point) o;
        return x == other.x && y == other.y;
    }

    public int hashCode() {
        return ("" + x + y).hashCode();
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class HashUse {

    public static void main(String[] args) {

        /* Hash table where the key is an email (string) and the value is a Contact */
        HashMap<String, Contact> friends = new HashMap<>(500, 2.0f);

        Contact tmp = new Contact("Ana Paula", "Centeno", "anapaula@cs.rutgers.edu");
        friends.put("Ana Paula", tmp); // insert into HT

        Contact tmp2 = new Contact("Sesh", "Venugopal", "venugopa@cs.rutgers.edu");
        friends.put("Sesh", tmp2);

        System.out.println(friends.get("Sesh"));

        /* Hash table where */
        HashMap<Point, Point> lines = new HashMap<>();
        Point A = new Point(3, 5);
        Point B = new Point(5, 5);
        Point C = new Point(3, 2);
        Point D = new Point(5, 0);

        lines.put(A, B);
        lines.put(C, D);
        System.out.println("Key: " + A + " Value: " + lines.get(A));
    }
}
