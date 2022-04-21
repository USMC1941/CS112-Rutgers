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
 * ValidPreReqInputFile name is passed through the command line as args[1].
 * Read from ValidPreReqInputFile with the format:
 * <ol>
 *     <li>1 line containing the proposed advanced course</li>
 *     <li>1 line containing the proposed prereq to the advanced course</li>
 * </ol>
 * <p>
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2].
 * Output to ValidPreReqOutputFile with the format:
 * <ol>
 *     <li>1 line, containing either the word "YES" or "NO"</li>
 * </ol>
 */
public class ValidPrereq {

    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println(
                    "Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }

        // WRITE YOUR CODE HERE

    }
}
