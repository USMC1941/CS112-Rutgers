package apps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import structures.Tree;

public class DOM {

    static Scanner stdin = new Scanner(System.in);

    static char getOption() {
        System.out.print("\tChoose action: ");
        System.out.print("(p)rint HTML, ");
        System.out.print("(r)eplace tag, ");
        System.out.print("(b)oldface row, ");
        System.out.print("(d)elete tag, ");
        System.out.print("(a)dd tag, or ");
        System.out.print("(q)uit? => ");
        char response = stdin.next().toLowerCase().charAt(0);
        while (response != 'p'
                && response != 'r'
                && response != 'b'
                && response != 'd'
                && response != 'a'
                && response != 'q') {
            System.out.print("\tYou must enter one of p, r, b, d, a, or q => ");
            response = stdin.next().toLowerCase().charAt(0);
        }
        return response;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter HTML file name => ");
        String htmlFile = stdin.next();
        Tree tree = new Tree(new Scanner(new File(htmlFile)));
        tree.build();
        char option;
        while ((option = getOption()) != 'q') {
            if (option == 'p') {
                System.out.print(tree.getHTML());
            } else if (option == 'r') {
                System.out.print("\tEnter old tag => ");
                String oldTag = stdin.next();
                System.out.print("\tEnter new tag => ");
                String newTag = stdin.next();
                tree.replaceTag(oldTag, newTag);
            } else if (option == 'b') {
                System.out.print("\tEnter row number (1..n) => ");
                int row;
                while (true) {
                    try {
                        row = Integer.parseInt(stdin.next());
                        if (row > 0) {
                            break;
                        } else {
                            throw new NumberFormatException();
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("\tYou must enter a positive integer => ");
                    }
                }
                try {
                    tree.boldRow(row);
                } catch (IllegalArgumentException iae) {
                    System.out.println("\tTable does not have row " + row);
                }
            } else if (option == 'd') {
                System.out.print("\tEnter tag to remove => ");
                tree.removeTag(stdin.next().trim());
            } else if (option == 'a') {
                System.out.print("\tEnter text to tag => ");
                String text = stdin.next().trim();
                System.out.print("\tEnter tag => ");
                String tag = stdin.next().trim();
                tree.addTag(text, tag);
            }
        }
    }
}
