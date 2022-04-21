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
 * EligibleInputFile name is passed through the command line as args[1].
 * Read from EligibleInputFile with the format:
 * <ol>
 *     <li>c (int): Number of courses</li>
 *     <li>c lines, each with 1 course ID</li>
 * </ol>
 * <p>
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2].
 * Output to EligibleOutputFile with the format:
 * <ol>
 *     <li>Some number of lines, each with one course ID</li>
 * </ol>
 */
public class Eligible {

    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println(
                    "Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
            return;
        }

        // WRITE YOUR CODE HERE
    }
}
