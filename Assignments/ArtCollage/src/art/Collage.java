package art;

import java.awt.Color;

/**
 * This class contains methods to create and perform operations on a collage of
 * images.
 *
 * @author Ana Paula Centeno
 */
public class Collage {

    /**
     * The original picture
     */
    private Picture originalPicture;

    /**
     * The collage picture is made up of tiles. Each tile consists of
     * {@code tileDimension X
     * tileDimension} pixels. The collage picture has
     * {@code collageDimension X collageDimension}
     * tiles
     */
    private Picture collagePicture;

    /**
     * The collagePicture is made up of {@code collageDimension X collageDimension}
     * tiles. Imagine a
     * collagePicture as a 2D array of tiles
     */
    private int collageDimension;

    /**
     * A tile consists of {@code tileDimension X * tileDimension} pixels Imagine a
     * tile as a 2D
     * array of pixels. A pixel has three components (red, green, and blue) that
     * define the color of
     * the pixel on the screen.
     */
    private int tileDimension;

    /**
     * One-argument Constructor
     *
     * <ol>
     * <li>Set default values of collageDimension to 4 and tileDimension to 150
     * <li>Initializes originalPicture with the filename image
     * <li>Initializes collagePicture as a Picture of
     * {@code tileDimension*collageDimension x
     *       tileDimension*collageDimension}, where each pixel is black (see
     * constructors for the
     * Picture class).
     * <li>Update collagePicture to be a scaled version of original (see scaling
     * filter on Week 9
     * slides)
     * </ol>
     *
     * @param filename The image filename
     */
    public Collage(String filename) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Three-arguments Constructor
     *
     * <ol>
     * <li>Set default values of collageDimension to cd and tileDimension to td
     * <li>Initializes originalPicture with the filename image
     * <li>Initializes collagePicture as a Picture of
     * {@code tileDimension*collageDimension x
     *       tileDimension*collageDimension}, where each pixel is black (see all
     * constructors for
     * the Picture class).
     * <li>Update collagePicture to be a scaled version of original (see scaling
     * filter on Week 9
     * slides)
     * </ol>
     *
     * @param filename The image filename.
     * @param td       The tile dimension.
     * @param cd       The collage dimension.
     */
    public Collage(String filename, int td, int cd) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Scales the {@code Picture source} into {@code Picture target} size. In other
     * words, it
     * changes the size of {@code source} to make it fit into {@code target}. Do not
     * update {@code
     * source}.
     *
     * @param source The image to be scaled.
     * @param target The scaled image output.
     */
    public static void scale(Picture source, Picture target) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {
        return collageDimension;
    }

    /**
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {
        return tileDimension;
    }

    /**
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {
        return originalPicture;
    }

    /**
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {
        return collagePicture;
    }

    /**
     * Display the original image. Assumes that original has been initialized
     */
    public void showOriginalPicture() {
        originalPicture.show();
    }

    /**
     * Display the collage image. Assumes that collage has been initialized
     */
    public void showCollagePicture() {
        collagePicture.show();
    }

    /**
     * Updates collagePicture to be a collage of tiles from original Picture.
     * collagePicture will
     * have {@code collageDimension x collageDimension} tiles, where each tile has
     * {@code
     * tileDimension X tileDimension} pixels.
     */
    public void makeCollage() {
        // WRITE YOUR CODE HERE
    }

    /**
     * Replaces the tile at collageCol,collageRow with the image from filename. Tile
     * (0,0) is the
     * upper leftmost tile.
     *
     * @param filename   image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile(String filename, int collageCol, int collageRow) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Colorizes the tile at (collageCol, collageRow) with {@code component} (see
     * Week 9 slides, the
     * code for color separation is at the book's website)
     *
     * @param component  is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile(String component, int collageCol, int collageRow) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Grayscale tile at (collageCol, collageRow)
     *
     * @param collageCol Tile column
     * @param collageRow Tile row
     */
    public void grayscaleTile(int collageCol, int collageRow) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Returns the monochrome luminance of the given color as an intensity between
     * 0.0 and 255.0
     * using the NTSC formula {@code Y = 0.299*r + 0.587*g + 0.114*b}. If the given
     * color is a shade
     * of gray (r = g = b), this method is guaranteed to return the exact grayscale
     * value (an
     * integer with no floating-point round-off error).
     *
     * @param color the color to convert
     * @return the monochrome luminance (between 0.0 and 255.0)
     */
    private static double intensity(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        if (r == g && r == b) {
            return r; // to avoid floating-point issues
        }
        return 0.299 * r + 0.587 * g + 0.114 * b;
    }

    /**
     * Returns a grayscale version of the given color as a {@code Color} object.
     *
     * @param color The {@code Color} object to convert to grayscale
     * @return A grayscale version of {@code color}
     */
    private static Color toGray(Color color) {
        int y = (int) (Math.round(intensity(color))); // round to the nearest int
        return new Color(y, y, y);
    }

    /**
     * Closes the image windows
     */
    public void closeWindow() {
        if (originalPicture != null) {
            originalPicture.closeWindow();
        }
        if (collagePicture != null) {
            collagePicture.closeWindow();
        }
    }
}
