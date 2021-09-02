package structures;

import java.util.*;

/**
 * This class implements an HTML DOM Tree. Each node of the tree is a {@link TagNode}, with fields
 * for tag/text, first child and sibling.
 */
public class Tree {

    /** Root node */
    TagNode root = null;

    /** Scanner used to read input HTML file when building the tree */
    Scanner sc;

    /**
     * Initializes this tree object with scanner for input HTML file
     *
     * @param sc Scanner for input HTML file
     */
    public Tree(Scanner sc) {
        this.sc = sc;
        root = null;
    }

    /**
     * Builds the DOM tree from input HTML file. The root of the tree is stored in the root field.
     */
    public void build() {
        /** COMPLETE THIS METHOD * */
    }

    /**
     * Replaces all occurrences of an old tag in the DOM tree with a new tag
     *
     * @param oldTag Old tag
     * @param newTag Replacement tag
     */
    public void replaceTag(String oldTag, String newTag) {
        /** COMPLETE THIS METHOD * */
    }

    /**
     * Boldface every column of the given row of the table in the DOM tree. The boldface (b) tag
     * appears directly under the td tag of every column of this row.
     *
     * @param row Row to bold, first row is numbered 1 (not 0).
     */
    public void boldRow(int row) {
        /** COMPLETE THIS METHOD * */
    }

    /**
     * Remove all occurrences of a tag from the DOM tree. If the tag is p, em, or b, all occurrences
     * of the tag are removed. If the tag is ol or ul, then All occurrences of such a tag are
     * removed from the tree, and, in addition, all the li tags immediately under the removed tag
     * are converted to p tags.
     *
     * @param tag Tag to be removed, can be p, em, b, ol, or ul
     */
    public void removeTag(String tag) {
        /** COMPLETE THIS METHOD * */
    }

    /**
     * Adds a tag around all occurrences of a word in the DOM tree.
     *
     * @param word Word around which tag is to be added
     * @param tag Tag to be added
     */
    public void addTag(String word, String tag) {
        /** COMPLETE THIS METHOD * */
    }

    /**
     * Gets the HTML represented by this DOM tree. The returned string includes new lines, so that
     * when it is printed, it will be identical to the input file from which the DOM tree was built.
     *
     * @return HTML string, including new lines.
     */
    public String getHTML() {
        StringBuilder sb = new StringBuilder();
        getHTML(root, sb);
        return sb.toString();
    }

    private void getHTML(TagNode root, StringBuilder sb) {
        for (TagNode ptr = root; ptr != null; ptr = ptr.sibling) {
            if (ptr.firstChild == null) {
                sb.append(ptr.tag);
                sb.append("\n");
            } else {
                sb.append("<");
                sb.append(ptr.tag);
                sb.append(">\n");
                getHTML(ptr.firstChild, sb);
                sb.append("</");
                sb.append(ptr.tag);
                sb.append(">\n");
            }
        }
    }
}
