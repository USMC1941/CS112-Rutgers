package Linear;

public class IntNode {
    int data;
    IntNode next;

    public IntNode(int data, IntNode next) {
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return data + "";
    }
}
