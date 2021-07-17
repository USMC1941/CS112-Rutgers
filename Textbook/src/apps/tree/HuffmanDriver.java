package apps.tree;

import java.io.*;
import java.util.*;

/**
 * A driver for the Huffman tree.
 * 
 * @author Sesh Venugopal
 *
 */
public class HuffmanDriver {
	
	/**
	 * Symbols to be coded.
	 */
	static char symbols[];
	
	/**
	 * Probabilities of occurrence of the symbols.
	 */
	static float probs[];
	
	/**
	 * Reader to read user input.
	 */
	static BufferedReader stdbr = new BufferedReader(
			new InputStreamReader(System.in));
	
	/**
	 * Reads all symbols and their probabilities from an input file.
	 * 
	 * @param symbolsFile File that has symbols and probabilities.
	 * @throws IOException If there is error in reading symbols file.
	 */
	static void readSymbols(String symbolsFile)
	throws IOException {
		Scanner sc = new Scanner(new File(symbolsFile));
		int numSymbols = sc.nextInt();
		symbols = new char[numSymbols];
		probs = new float[numSymbols];
		for (int i=0; i < numSymbols; i++) {
			symbols[i] = sc.next().charAt(0);
			probs[i] = sc.nextFloat();
		}
	}
	
	/**
	 * Entry point into the driver.
	 * 
	 * @param args Symbols file is accepted as argument.
	 * @throws IOException If there is error in input.
	 */
	public static void main(String[] args)
	throws IOException {
		readSymbols(args[0]);
		Huffman huff = new Huffman(symbols, probs);
		System.out.println("Symbol   Code");
		System.out.println();
		for (int i=0; i < symbols.length; i++) {
			System.out.println("   " + symbols[i] + "      " + 
					huff.getCode(symbols[i]));
		}
		
		System.out.print("Would you like to decode? (y/n) => ");
		System.out.flush();
		char c = stdbr.readLine().charAt(0);
		while (c == 'y' || c == 'Y') {
			System.out.print("Message to be decoded => ");
			System.out.flush();
			String msg = stdbr.readLine();
			System.out.println("Decoded message => " + huff.decode(msg));
			System.out.print("Would you like to decode? (y/n) => ");
			System.out.flush();
			c = stdbr.readLine().charAt(0);        
		}
	}
}

