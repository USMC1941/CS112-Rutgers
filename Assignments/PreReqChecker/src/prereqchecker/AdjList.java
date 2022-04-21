package prereqchecker;

import java.util.*;

/**
 * Steps to implement this class main method:
 * <p>
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0].
 * Read from AdjListInputFile with the format:
 * <ol>
 *     <li>a (int): number of courses in the graph</li>
 *     <li>a lines, each with 1 course ID</li>
 *     <li>b (int): number of edges in the graph</li>
 *     <li>b lines, each with a source ID</li>
 * </ol>
 * <p>
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1].
 * Output to AdjListOutputFile with the format:
 * <ol>
 *     <li>
 *         c lines, each starting with a different course ID, then
 *         listing all of that course's prerequisites (space separated)
 *     </li>
 * </ol>
 */
public class AdjList {

    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println(
                    "Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }

        // WRITE YOUR CODE HERE
    }
}
