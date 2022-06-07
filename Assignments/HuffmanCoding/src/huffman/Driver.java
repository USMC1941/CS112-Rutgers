package huffman;

import java.util.ArrayList;

/**
 * This class is designed to test each step of the huffman coding process when run
 *
 * @author Ishaan Ivaturi
 */
public class Driver {
    public static void main(String[] args) {
        String[] methods = {"makeSortedList", "makeTree", "makeEncodings", "encode", "decode"};
        String[] options = {"Test new file", "Test new method on the same file", "Quit"};
        int repeatChoice = 0;
        do {
            System.err.print("Enter an input text file name => ");
            String input = StdIn.readLine();
            System.err.println();
            do {
                System.err.println("What method would you like to test? Later methods rely on previous methods.");
                for (int i = 0; i < 5; i++) {
                    System.err.printf("%d. %s\n", i + 1, methods[i]);
                }
                System.err.print("Enter a number => ");
                int choice = StdIn.readInt();
                StdIn.readLine();
                System.err.println();
                switch (choice) {
                    case 1:
                        testSortedList(input);
                        break;
                    case 2:
                        testMakeTree(input);
                        break;
                    case 3:
                        testMakeEncodings(input);
                        break;
                    case 4:
                        testEncode(input);
                        break;
                    case 5:
                        testDecode(input);
                        break;
                    default:
                        System.err.println("Not a valid method to test!");
                }
                StdIn.resync();
                System.err.println("\nWhat would you like to do now?");
                for (int i = 0; i < 3; i++) {
                    System.err.printf("%d. %s\n", i + 1, options[i]);
                }
                System.err.print("Enter a number => ");
                repeatChoice = StdIn.readInt();
                StdIn.readLine();
                System.err.println();
            } while (repeatChoice == 2);
        } while (repeatChoice == 1);
    }

    /**
     * Call the student's sorted list method, and output all of them comma separated
     */
    private static void testSortedList(String input) {
        HuffmanCoding studentSolution = new HuffmanCoding(input);
        studentSolution.makeSortedList();
        ArrayList<CharFreq> sortedList = studentSolution.getSortedCharFreqList();
        StdOut.println("Note that the decimals are rounded to 2 decimal places.\n");
        StdOut.printf(
                "%s->%.2f",
                charToString(sortedList.get(0).getCharacter()),
                sortedList.get(0).getProbOcc());
        for (int i = 1; i < sortedList.size(); i++) {
            char c = sortedList.get(i).getCharacter();
            StdOut.printf(", %s->%.2f", charToString(c), sortedList.get(i).getProbOcc());
        }
        StdOut.println();
    }

    private static String charToString(char c) {
        // Make sure special characters don't actually print themselves out
        switch (c) {
            case '\n':
                return "\\n";
            case '\t':
                return "\\t";
            case '\r':
                return "\\r";
            default:
                return "" + c;
        }
    }

    /**
     * Call the student's list method and their tree method, printing out the tree
     */
    private static void testMakeTree(String input) {
        HuffmanCoding studentSolution = new HuffmanCoding(input);
        studentSolution.makeSortedList();
        studentSolution.makeTree();

        StdOut.println("Note that the decimals are rounded to 2 decimal places\n");
        printTree(studentSolution.getHuffmanRoot());
        StdOut.println();
    }

    private static void printTree(TreeNode root) {
        printTree(root, "", false, true);
    }

    private static void printTree(TreeNode n, String indent, boolean isRight, boolean isRoot) {
        StdOut.print(indent);

        // Print out either a right connection or a left connection
        if (!isRoot) {
            StdOut.print(isRight ? "|-1- " : "+-0- ");
        } else {
            // If we're at the root, we don't want a 1 or 0
            StdOut.print("+--- ");
        }

        if (n == null) {
            StdOut.println("null");
            return;
        }

        // If we have an associated character print it too, otherwise just the probability
        if (n.getData().getCharacter() != null) {
            StdOut.print(charToString(n.getData().getCharacter()) + "->");
        }
        StdOut.printf("%.2f ", n.getData().getProbOcc());
        StdOut.println();

        // If no more children we're done
        if (n.getLeft() == null && n.getRight() == null) {
            return;
        }

        // Add to the indent based on whether we're branching left or right
        indent += isRight ? "|    " : "     ";

        printTree(n.getRight(), indent, true, false);
        printTree(n.getLeft(), indent, false, false);
    }

    /**
     * Call student's list, tree, and encoding methods
     */
    private static void testMakeEncodings(String input) {
        HuffmanCoding studentSolution = new HuffmanCoding(input);
        studentSolution.makeSortedList();
        studentSolution.makeTree();
        studentSolution.makeEncodings();
        String[] encodings = studentSolution.getEncodings();
        boolean first = true;
        // Print out all their encodings (which are not null)
        for (int i = 0; i < 128; i++) {
            if (encodings[i] != null) {
                if (!first) {
                    StdOut.print(", ");
                }
                StdOut.printf("%s->%s", charToString((char) i), encodings[i]);
                first = false;
            }
        }
        StdOut.println();
    }

    /**
     * Take in an encoding file and call the student's encode method
     */
    private static void testEncode(String input) {
        System.err.print("File to encode into (can be new) => ");
        String encodedFile = StdIn.readLine();
        System.err.println();

        HuffmanCoding studentSolution = new HuffmanCoding(input);
        studentSolution.makeSortedList();
        studentSolution.makeTree();
        studentSolution.makeEncodings();
        studentSolution.encode(encodedFile);

        System.err.println("The input text file has been encoded into " + encodedFile);
    }

    /**
     * Encode and decode the student's file (with their decode method).
     * Can be piped to a file for large inputs
     */
    private static void testDecode(String input) {
        System.err.print("File to encode into (can be new) => ");
        String encodedFile = StdIn.readLine();
        System.err.println();

        HuffmanCoding studentSolution = new HuffmanCoding(input);
        studentSolution.makeSortedList();
        studentSolution.makeTree();
        studentSolution.makeEncodings();
        studentSolution.encode(encodedFile);

        StdIn.resync();

        System.err.println("The input text file has been encoded into " + encodedFile);

        System.err.print("File to decode into (can be new) => ");
        String decodedFile = StdIn.readLine();
        System.err.println();

        studentSolution.decode(encodedFile, decodedFile);
        System.err.println("The file has been decoded into " + decodedFile);
        System.err.println();
    }
}
