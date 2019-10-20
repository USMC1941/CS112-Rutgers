package apps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import structures.Trie;

public class TrieApp {

	static Scanner stdin = new Scanner(System.in);
	static Trie trie = new Trie();
	
	public static void main(String[] args) 
	throws IOException {
		
		System.out.print("(u)ser input, or (f)ile: ");
		char inp = stdin.next().toLowerCase().charAt(0);
		if (inp == 'u') {
			getWordsFromUser();
		} else {
			getWordsFromFile();
		}
		completionList();
		
	}

	private static void completionList() {
		System.out.print("\ncompletion list for (enter prefix, or 'quit'): ");
		String prefix = stdin.next();
		while (!"quit".equalsIgnoreCase(prefix)) {
			ArrayList<String> matches = trie.completionList(prefix);
			System.out.println(matches);
			System.out.print("\ncompletion list for: ");
			prefix = stdin.next();
		}
	}
	
	private static void getWordsFromUser() {
		System.out.print("Enter word, 'quit' when done: ");
		String word = stdin.next().trim().toLowerCase();
		while (!"quit".equals(word)) {
			trie.insertWord(word);
			trie.print();
			System.out.print("\nEnter word: ");
			word = stdin.next().trim().toLowerCase();
		}
	}
	
	private static void getWordsFromFile() 
	throws IOException {
		System.out.print("Enter words file name => ");
		String wordsFile = stdin.next();
		Scanner sc = new Scanner(new File(wordsFile));
		// words appear one per line in input file
		// first line has number of words
		int numWords = sc.nextInt();
		String[] ret = new String[numWords];
		for (int i=0; i < ret.length; i++) {
			trie.insertWord(sc.next().trim());
		}
		sc.close();
		trie.print();
	}
	
	
}
