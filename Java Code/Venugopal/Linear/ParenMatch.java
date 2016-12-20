package Linear;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParenMatch {

	public static boolean parenMatch(String s) {
		Stack<Character> stk = new Stack<Character>();
		for (int i=0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[') {
				stk.push(ch);   // AUTO BOXING => primitive ch is auto converted to Character
				continue;
			}
			if (ch == ']' || ch == ')') {
				try {
					char ch2 = stk.pop();   // AUTO UNBOXING => returned Character is auto converted to primitive
					if (ch2 == '[' && ch == ']' || ch2 == '(' && ch == ')') {
						continue;
					}
					return false;   // mismatch in types of parens/brackets
				} catch (NoSuchElementException e) {
					return false;   // more closes than opens
				}
			}
		}
		return stk.isEmpty();   // more opens than closes
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter expression, 'quit' to stop: ");
		String line = sc.nextLine();
		while (!"quit".equals(line)) {
			if (parenMatch(line)) {
				System.out.println("Matched!");
			} else {
				System.out.println("Did not match");
			}
			System.out.print("Enter expression, 'quit' to stop: ");
			line = sc.nextLine();
		}
	}

}
