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
 * NeedToTakeInputFile name is passed through the command line as args[1].
 * Read from NeedToTakeInputFile with the format:
 * <ol>
 *     <li>One line, containing a course ID</li>
 *     <li>c (int): Number of courses</li>
 *     <li>c lines, each with one course ID</li>
 * </ol>
 * <p>
 * Step 3:
 * NeedToTakeOutputFile name is passed through the command line as args[2].
 * Output to NeedToTakeOutputFile with the format:
 * <ol>
 *     <li>Some number of lines, each with one course ID</li>
 * </ol>
 */
public class NeedToTake {

    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println(
                    "Execute: java NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");
        }

        // WRITE YOUR CODE HERE
    }
}
