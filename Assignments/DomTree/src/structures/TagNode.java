package structures;

/**
 * This class encapsulates a tag node with fields for tag/text, first child and sibling.
 *
 * @author Sesh Venugopal
 */
public class TagNode {
    /**
     * Tag or text. If tag, only the tag name is stored, but NOT the '<' or '>'. For example, if the
     * tag is "<em>", then only "em" is stored.
     */
    String tag;

    /** First child of this node */
    TagNode firstChild;

    /** Sibling of this node */
    TagNode sibling;

    /**
     * Initializes this tag node with tag/txt, first child, and sibling
     *
     * @param tag Tag or text
     * @param firstChild First child
     * @param sibling Sibling
     */
    public TagNode(String tag, TagNode firstChild, TagNode sibling) {
        this.tag = tag;
        this.firstChild = firstChild;
        this.sibling = sibling;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        if (firstChild != null) {
            return "<" + tag + ">";
        } else {
            return tag;
        }
    }
}
