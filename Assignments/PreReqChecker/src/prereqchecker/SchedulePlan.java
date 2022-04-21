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
 * SchedulePlanInputFile name is passed through the command line as args[1].
 * Read from SchedulePlanInputFile with the format:
 * <ol>
 *     <li>One line containing a course ID</li>
 *     <li>c (int): number of courses</li>
 *     <li>c lines, each with one course ID</li>
 * </ol>
 * <p>
 * Step 3:
 * SchedulePlanOutputFile name is passed through the command line as args[2].
 * Output to SchedulePlanOutputFile with the format:
 * <ol>
 *     <li>One line containing an int c, the number of semesters required to take the course</li>
 *     <li>c lines, each with space separated course ID's</li>
 * </ol>
 */
public class SchedulePlan {

    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println(
                    "Execute: java -cp bin prereqchecker.SchedulePlan <adjacency list INput file> <schedule plan INput file> <schedule plan OUTput file>");
            return;
        }

        // WRITE YOUR CODE HERE
    }
}
