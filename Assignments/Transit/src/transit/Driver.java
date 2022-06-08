package transit;

/**
 * This class is designed to test each method in the Transit file interactively.
 *
 * @author Ishaan Ivaturi
 */
public class Driver {
    public static void main(String[] args) {
        String[] methods = { "makeList", "removeTrainStation", "addStop", "bestPath", "duplicate", "addScooter" };
        String[] options = { "Test a new input file", "Test another method on the same file", "Quit" };
        int controlChoice;
        do {
            StdOut.print("Enter a layered list input file => ");
            String inputFile = StdIn.readLine();
            do {
                StdOut.println("\nWhat method would you like to test?");
                for (int i = 0; i < 6; i++) {
                    StdOut.printf("%d. %s\n", i + 1, methods[i]);
                }
                StdOut.print("Enter a number => ");
                int choice = Integer.parseInt(StdIn.readLine());
                switch (choice) {
                    case 1:
                        testMakeList(inputFile);
                        break;
                    case 2:
                        testRemoveTrainStation(inputFile);
                        break;
                    case 3:
                        testAddStop(inputFile);
                        break;
                    case 4:
                        testBestPath(inputFile);
                        break;
                    case 5:
                        testDuplicate(inputFile);
                        break;
                    case 6:
                        testAddScooter(inputFile);
                        break;
                    default:
                        StdOut.println("Not a valid option!");
                }
                StdOut.println("What would you like to do now?");
                for (int i = 0; i < 3; i++) {
                    StdOut.printf("%d. %s\n", i + 1, options[i]);
                }
                StdOut.print("Enter a number => ");
                controlChoice = Integer.parseInt(StdIn.readLine());
            } while (controlChoice == 2);
        } while (controlChoice == 1);
    }

    private static Transit testMakeList(String filename) {
        StdIn.setFile(filename);
        // For each layer, readInt the size, then fill the array
        int[][] input = new int[3][];
        for (int i = 0; i < 3; i++) {
            int[] currentLayer = new int[StdIn.readInt()];
            for (int j = 0; j < currentLayer.length; j++) {
                currentLayer[j] = StdIn.readInt();
            }
            input[i] = currentLayer;
        }
        StdIn.resync();
        // Call student's makeList method with the arrays, then display it
        StdOut.println();
        Transit studentList = new Transit();
        studentList.makeList(input[0], input[1], input[2]);
        studentList.printList();
        StdOut.println();
        return studentList;
    }

    private static void testRemoveTrainStation(String filename) {
        // Use testMakeList to both print out and obtain original list
        StdOut.print("\nOriginal List:");
        Transit studentList = testMakeList(filename);

        // Call student removeStation method for specified station and output
        StdOut.print("Enter a station to remove => ");
        studentList.removeTrainStation(Integer.parseInt(StdIn.readLine()));
        StdOut.println("\nFinal list:");
        studentList.printList();
        StdOut.println();
    }

    private static void testAddStop(String filename) {
        StdOut.print("\nOriginal List:");
        Transit studentList = testMakeList(filename);

        // Call student addStop method on specified number, and display list
        StdOut.print("Enter a bus stop to add => ");
        studentList.addBusStop(Integer.parseInt(StdIn.readLine()));
        StdOut.println("\nFinal list:");
        studentList.printList();
        StdOut.println();
    }

    private static void testBestPath(String filename) {
        StdOut.print("\nLayered Linked List:");
        Transit studentList = testMakeList(filename);

        // Print best path from student bestPath method
        StdOut.print("Enter a destination => ");
        int destination = Integer.parseInt(StdIn.readLine());
        StdOut.println("\nBest path:");
        studentList.printBestPath(destination);

        StdOut.println("\nValues of nodes in your best path:");
        StdOut.print("{ ");
        for (TNode t : studentList.bestPath(destination)) {
            StdOut.print(t.getLocation() + " ");
        }
        StdOut.println("}\n");
    }

    private static void testDuplicate(String filename) {
        StdOut.print("\nOriginal list:");
        Transit studentList = testMakeList(filename);

        // Call student duplicate method then print list
        Transit duplicateList = new Transit(studentList.duplicate());
        StdOut.println("Duplicate:");
        duplicateList.printList();
        StdOut.println();
    }

    private static void testAddScooter(String filename) {
        StdOut.print("\nOriginal list:");
        Transit studentList = testMakeList(filename);

        // Read in scooter size, then read in each scooter stop
        StdOut.print("Enter a scooter layer input file => ");
        String scooterFile = StdIn.readLine();
        StdIn.setFile(scooterFile);
        int[] scooterStops = new int[StdIn.readInt()];
        for (int i = 0; i < scooterStops.length; i++) {
            scooterStops[i] = StdIn.readInt();
        }
        StdIn.resync();

        // Call student addScooter method and print out list
        studentList.addScooter(scooterStops);
        StdOut.println("\nFinal list:");
        studentList.printList();
        StdOut.println();
    }
}
