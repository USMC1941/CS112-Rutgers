/**
 * Percolation
 *
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 */
public class Percolation {
    /**
     * 2D array representing the grid.
     * Each (row, col) is a site.
     * (row, col) is true if the site is open, false if the site is closed.
     */
    private boolean[][] grid;

    /**
     * Weighted quick union-find object used to keep track of all connected/opened sites.
     */
    private WeightedQuickUnionFind wquFind;

    /**
     * The size of the grid
     */
    private int gridSize;

    /**
     * The number of sites in a grid.
     * gridSize by gridSize is the size of the grid/system.
     */
    private int gridSquared;

    /**
     * Index of a virtual top in the size and parent arrays in {@link WeightedQuickUnionFind}.
     * Connect the virtual top to every open site in the first row of the grid.
     */
    private int virtualTop;

    /**
     * Index of a virtual bottom in the size and parent arrays in {@link WeightedQuickUnionFind}.
     */
    private int virtualBottom;

    /**
     * Constructor.
     * Initializes all instance variables
     */
    public Percolation(int n) {
        gridSize = n;
        gridSquared = gridSize * gridSize;
        wquFind = new WeightedQuickUnionFind(gridSquared + 2);
        grid = new boolean[gridSize][gridSize]; // every site is initialized to closed/blocked
        virtualTop = gridSquared;
        virtualBottom = gridSquared + 1;
    }

    /**
     * Getter method for GridSize
     * @return integer representing the size of the grid.
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * Returns the grid array
     * @return grid array
     */
    public boolean[][] getGridArray() {
        return grid;
    }

    /**
     * Open the site at position (x,y) on the grid to true and add an edge
     * to any open neighbor (left, right, top, bottom) and/or top/bottom virtual sites
     * Note: diagonal sites are not neighbors
     *
     * @param row grid row
     * @param col grid column
     */
    public void openSite(int row, int col) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Check if the system percolates (any top and bottom sites are connected by open sites)
     * @return true if system percolates, false otherwise
     */
    public boolean percolationCheck() {
        // WRITE YOUR CODE HERE
        // THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
        return false;
    }

    /**
     * Iterates over the grid array opening every site.
     * Starts at [0][0] and moves row wise
     * @param probability Probability
     * @param seed The seed
     */
    public void openAllSites(double probability, long seed) {
        // Setting the same seed before generating random numbers ensure that
        // the same numbers are generated between different runs
        StdRandom.setSeed(seed); // DO NOT remove this line

        // WRITE YOUR CODE HERE, DO NOT remove the line above
    }

    /**
     * Open up a new window and display the current grid using {@link StdDraw} library.
     * The output will be colored based on the grid array. Blue for open site, black for closed site.
     */
    public void displayGrid() {
        double blockSize = 0.9 / gridSize;
        double zeroPt = 0.05 + (blockSize / 2), x = zeroPt, y = zeroPt;
        for (int i = gridSize - 1; i >= 0; i--) {
            x = zeroPt;
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j]) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    StdDraw.filledSquare(x, y, blockSize / 2);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.square(x, y, blockSize / 2);
                } else {
                    StdDraw.filledSquare(x, y, blockSize / 2);
                }
                x += blockSize;
            }
            y += blockSize;
        }
    }

    /**
     * Main method, for testing only, feel free to change it.
     */
    public static void main(String[] args) {
        double probability = 0.50;
        Percolation percolation = new Percolation(10);

        // Setting a seed before generating random numbers ensure that
        // the same numbers are generated between runs.
        // If you would like to reproduce Autolab's output, update
        // the seed variable to the value Autolab has used.
        long seed = System.currentTimeMillis();
        percolation.openAllSites(probability, seed);

        System.out.println("The system percolates: " + percolation.percolationCheck());
        percolation.displayGrid();
    }
}
