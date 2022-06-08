package transit;

/**
 * This class contains a Transportation Node, with an int
 * representing location, a next pointer representing horizontal
 * movement, and a down pointer representing a slower mode of
 * transport
 *
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class TNode {
    private int location;
    private TNode next;
    private TNode down;

    public TNode(int l, TNode n, TNode d) {
        location = l;
        next = n;
        down = d;
    }

    public TNode() {
        // No arguments sets location to 0
        this(0, null, null);
    }

    public TNode(int l) {
        // Int argument sets location
        this(l, null, null);
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int l) {
        location = l;
    }

    public TNode getNext() {
        return next;
    }

    public void setNext(TNode n) {
        next = n;
    }

    public TNode getDown() {
        return down;
    }

    public void setDown(TNode d) {
        down = d;
    }
}
