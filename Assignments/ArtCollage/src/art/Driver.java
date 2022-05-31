package art;

/**
 * This class is used to test the Collage class methods.
 *
 * @author Ana Paula Centeno
 */
public class Driver {

    public static void main(String[] args) {
        Collage collage;
        String[] methods = {
                "one-argument constructor",
                "three-argument constructor",
                "showOriginalPicture",
                "showCollagePicture",
                "makeCollage",
                "replaceTile",
                "colorizeTile",
                "grayscaleTile"
        };
        String[] options = { "Test new image file", "Test new method on the same image file", "Quit" };
        int repeatChoice;
        do {
            System.out.print("Enter an image file => ");
            String imageFilename = StdIn.readString();
            collage = null;
            do {
                System.out.println(
                        "\n\nWhich method would you like to test? Methods 3-8 rely on the constructor previously chosen.");
                for (int i = 0; i < 8; i++) {
                    System.out.printf("%d. %s\n", i + 1, methods[i]);
                }
                System.out.print("\n\nEnter a number => ");
                int choice = StdIn.readInt();
                switch (choice) {
                    case 1:
                        collage = new Collage(imageFilename);
                        break;
                    case 2:
                        collage = executeThreeArgsConstructor(imageFilename);
                        break;
                    case 3:
                        executeShowOriginalPicture(collage);
                        break;
                    case 4:
                        executeShowCollagePicture(collage);
                        break;
                    case 5:
                        executeMakeCollage(collage);
                        break;
                    case 6:
                        executeReplaceTile(collage);
                        break;
                    case 7:
                        executeColorizeTile(collage);
                        break;
                    case 8:
                        executeGrayscaleTile(collage);
                        break;
                    default:
                        System.err.println("Not a valid method to test!");
                }
                System.out.println("\nWhat would you like to do now?");
                for (int i = 0; i < 3; i++) {
                    System.out.printf("%d. %s\n", i + 1, options[i]);
                }
                System.out.print("Enter a number => ");
                repeatChoice = StdIn.readInt();
            } while (repeatChoice == 2);
        } while (repeatChoice == 1);
        if (collage != null) {
            collage.closeWindow();
        }
    }

    private static void executeGrayscaleTile(Collage c) {
        System.out.print("\n\nIn which column is the tile would you like to gray? Enter a number => ");
        int col = StdIn.readInt();
        if (col >= c.getCollageDimension()) {
            System.err.println("Aborting, the column entered is greater than " + c.getCollageDimension());
            return;
        }

        System.out.print("\nIn which row is the tile would you like to gray? Enter a number => ");
        int row = StdIn.readInt();
        if (row >= c.getCollageDimension()) {
            System.err.println("\n\nAborting, the row entered is greater than " + c.getCollageDimension());
            return;
        }

        c.grayscaleTile(col, row);
    }

    private static void executeColorizeTile(Collage c) {
        System.out.print("\n\nEnter the color component [red|green|blue] => ");
        String component = StdIn.readString();

        System.out.print("\nIn which column is the tile would you like to colorize? Enter a number => ");
        int col = StdIn.readInt();
        if (col >= c.getCollageDimension()) {
            System.err.println("\n\nAborting, the column entered is greater than " + c.getCollageDimension());
            return;
        }

        System.out.print("\nIn which row is the tile would you like to colorize? Enter a number => ");
        int row = StdIn.readInt();
        if (row >= c.getCollageDimension()) {
            System.err.println("Aborting, the row entered is greater than " + c.getCollageDimension());
            return;
        }

        c.colorizeTile(component, col, row);
    }

    private static void executeReplaceTile(Collage c) {
        System.out.print("\n\nEnter a new image file => ");
        String image = StdIn.readString();

        System.out.print("\nIn which column is the tile would you like to replace? Enter a number => ");
        int col = StdIn.readInt();
        if (col >= c.getCollageDimension()) {
            System.err.println("\n\nAborting, the column entered is greater than " + c.getCollageDimension());
            return;
        }

        System.out.print("\nIn which row is the tile would you like to replace? Enter a number => ");
        int row = StdIn.readInt();
        if (row >= c.getCollageDimension()) {
            System.err.println("\n\nAborting, the row entered is greater than " + c.getCollageDimension());
            return;
        }

        c.replaceTile(image, col, row);
    }

    private static void executeMakeCollage(Collage c) {
        if (c == null) {
            System.err.println("\n\nAborting, you have not called a constructor yet.");
        } else {
            c.makeCollage();
        }
    }

    private static Collage executeThreeArgsConstructor(String filename) {
        System.out.print("\nEnter tile dimension => ");
        int td = StdIn.readInt();
        System.out.print("\nEnter collage dimension => ");
        int cd = StdIn.readInt();
        return new Collage(filename, td, cd);
    }

    private static void executeShowOriginalPicture(Collage c) {
        if (c == null) {
            System.err.println("\n\nAborting, you have not called a constructor yet.");
        } else {
            c.showOriginalPicture();
        }
    }

    private static void executeShowCollagePicture(Collage c) {
        if (c == null) {
            System.err.println("\n\nAborting, you have not called a constructor yet.");
        } else {
            c.showCollagePicture();
        }
    }
}
