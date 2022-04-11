/**
 * This class contains a Transportation Node, with an int representing location, a next pointer
 * representing horizontal movement, and a down pointer representing a slower mode of transport
 *
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class TNode {
    int location;
    TNode next;
    TNode down;

    public TNode() {
        location = 0;
        next = null;
        down = null;
    }

    public TNode(int l) {
        location = l;
        next = null;
        down = null;
    }

    public TNode(int l, TNode n, TNode d) {
        location = l;
        next = n;
        down = d;
    }
}
