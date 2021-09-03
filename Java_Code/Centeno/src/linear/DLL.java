package linear;

public class DLL<T> {

    NodeDLL<T> front;
    int size;

    DLL() {
        front = null;
        size = 0;
    }

    void addToFront(T data) {
        NodeDLL<T> node = new NodeDLL<>(data, null, front);
        if (front != null) {
            front.previous = node;
        }
        front = node;
        size++;
    }

    void traverse() {
        NodeDLL<T> ptr = front;
        while (ptr != null) {
            System.out.print(ptr.data + " <-> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void addAfter(T target, T data) {
        NodeDLL<T> ptr = front;
        while (ptr != null && !ptr.data.equals(target)) {
            ptr = ptr.next;
        }
        if (ptr == null) {
            return;
        }
        NodeDLL<T> node = new NodeDLL<>(data, ptr, ptr.next);
        ptr.next = node;
        if (node.next != null) {
            node.next.previous = node;
        }
        size++;
    }

    void delete(T target) {
        NodeDLL<T> ptr = front;
        while (ptr != null && !ptr.data.equals(target)) {
            ptr = ptr.next;
        }
        if (ptr != null) {
            if (ptr.previous != null) {
                ptr.previous.next = ptr.next;
            } else {
                front = ptr.next;
            }
            if (ptr.next != null) {
                ptr.next.previous = ptr.previous;
            }
        }
    }
}
