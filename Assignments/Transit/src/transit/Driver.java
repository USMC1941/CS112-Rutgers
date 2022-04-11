import java.util.ArrayList;

/**
 * This class is designed to test each method in the Transit file interactively
 *
 * @author Ishaan Ivaturi
 */
public class Driver {
    public static void main(String[] args) {
        String[] methods = {
            "makeList", "removeStation", "addStop", "bestPath", "duplicate", "addScooter"
        };
        String[] options = {
            "Test a new input file", "Test another method on the same file", "Quit"
        };
        int controlChoice = 0;
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
                        testRemoveStation(inputFile);
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

    private static TNode testMakeList(String filename) {
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
        TNode trainZero = Transit.makeList(input[0], input[1], input[2]);
        printList(trainZero);
        StdOut.println();
        return trainZero;
    }

    private static void printList(TNode trainZero) {
        // Traverse the starts of the layers, then the layers within
        for (TNode vertPtr = trainZero; vertPtr != null; vertPtr = vertPtr.down) {
            for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.next) {
                // Output the location, then prepare for the arrow to the next
                StdOut.print(horizPtr.location);
                if (horizPtr.next == null) {
                    break;
                }
                // Spacing is determined by the numbers in the walking layer
                for (int i = horizPtr.location + 1; i < horizPtr.next.location; i++) {
                    StdOut.print("--");
                    int numLen = String.valueOf(i).length();
                    for (int j = 0; j < numLen; j++) {
                        StdOut.print("-");
                    }
                }
                StdOut.print("->");
            }
            // Prepare for vertical lines
            if (vertPtr.down == null) break;
            StdOut.println();
            TNode downPtr = vertPtr.down;
            // Reset horizPtr, and output a | under each number
            for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.next) {
                // Only print vertical line if down pointer matches
                while (downPtr.location < horizPtr.location) {
                    downPtr = downPtr.next;
                }
                if (downPtr.location == horizPtr.location && horizPtr.down == downPtr) {
                    StdOut.print("|");
                } else {
                    StdOut.print(" ");
                }
                int numLen = String.valueOf(horizPtr.location).length();
                for (int j = 0; j < numLen - 1; j++) {
                    StdOut.print(" ");
                }
                if (horizPtr.next == null) {
                    break;
                }
                for (int i = horizPtr.location + 1; i <= horizPtr.next.location; i++) {
                    StdOut.print("  ");
                    if (i != horizPtr.next.location) {
                        numLen = String.valueOf(i).length();
                        for (int j = 0; j < numLen; j++) {
                            StdOut.print(" ");
                        }
                    }
                }
            }
            StdOut.println();
        }
        StdOut.println();
    }

    private static void testRemoveStation(String filename) {
        // Use testMakeList to both print out and obtain original list
        StdOut.print("\nOriginal List:");
        TNode trainZero = testMakeList(filename);

        // Call student removeStation method for specified station and output
        StdOut.print("Enter a station to remove => ");
        Transit.removeTrainStation(trainZero, Integer.parseInt(StdIn.readLine()));
        StdOut.println("\nFinal list:");
        printList(trainZero);
        StdOut.println();
    }

    private static void testAddStop(String filename) {
        StdOut.print("\nOriginal List:");
        TNode trainZero = testMakeList(filename);

        // Call student addStop method on specified number, and display list
        StdOut.print("Enter a bus stop to add => ");
        Transit.addBusStop(trainZero, Integer.parseInt(StdIn.readLine()));
        StdOut.println("\nFinal list:");
        printList(trainZero);
        StdOut.println();
    }

    private static void testBestPath(String filename) {
        StdOut.print("\nLayered Linked List:");
        TNode trainZero = testMakeList(filename);

        // Print best path from student bestPath method
        StdOut.print("Enter a destination => ");
        int destination = Integer.parseInt(StdIn.readLine());
        StdOut.println("\nBest path:");
        ArrayList<TNode> bestPath = Transit.bestPath(trainZero, destination);
        printBestPath(trainZero, bestPath);
        StdOut.println("\nValues of nodes in your best path:");
        StdOut.print("{ ");
        for (TNode t : bestPath) {
            StdOut.print(t.location + " ");
        }
        StdOut.println("}\n");
    }

    private static void printBestPath(TNode trainZero, ArrayList<TNode> path) {
        for (TNode vertPtr = trainZero; vertPtr != null; vertPtr = vertPtr.down) {
            for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.next) {
                // ONLY print the number if this node is in the path, otherwise spaces
                if (path.contains(horizPtr)) {
                    StdOut.print(horizPtr.location);
                } else {
                    int numLen = String.valueOf(horizPtr.location).length();
                    for (int i = 0; i < numLen; i++) {
                        StdOut.print(" ");
                    }
                }
                if (horizPtr.next == null) {
                    break;
                }
                // ONLY print the edge if both ends are in the path, otherwise spaces
                String separator =
                        (path.contains(horizPtr) && path.contains(horizPtr.next)) ? ">" : " ";
                for (int i = horizPtr.location + 1; i < horizPtr.next.location; i++) {
                    StdOut.print(separator + separator);
                    int numLen = String.valueOf(i).length();
                    for (int j = 0; j < numLen; j++) {
                        StdOut.print(separator);
                    }
                }
                StdOut.print(separator + separator);
            }
            if (vertPtr.down == null) {
                break;
            }
            StdOut.println();
            for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.next) {
                // ONLY print the vertical edge if both ends are in the path, otherwise space
                StdOut.print((path.contains(horizPtr) && path.contains(horizPtr.down)) ? "V" : " ");
                int numLen = String.valueOf(horizPtr.location).length();
                for (int j = 0; j < numLen - 1; j++) {
                    StdOut.print(" ");
                }
                if (horizPtr.next == null) {
                    break;
                }
                for (int i = horizPtr.location + 1; i <= horizPtr.next.location; i++) {
                    StdOut.print("  ");
                    if (i != horizPtr.next.location) {
                        numLen = String.valueOf(i).length();
                        for (int j = 0; j < numLen; j++) {
                            StdOut.print(" ");
                        }
                    }
                }
            }
            StdOut.println();
        }
        StdOut.println();
    }

    private static void testDuplicate(String filename) {
        StdOut.print("\nOriginal list:");
        TNode trainZero = testMakeList(filename);
        // Call student duplicate method then print list
        StdOut.println("Duplicate:");
        printList(Transit.duplicate(trainZero));
        StdOut.println();
    }

    private static void testAddScooter(String filename) {
        StdOut.print("\nOriginal list:");
        TNode trainZero = testMakeList(filename);
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
        Transit.addScooter(trainZero, scooterStops);
        StdOut.println("\nFinal list:");
        printList(trainZero);
        StdOut.println();
    }
}
