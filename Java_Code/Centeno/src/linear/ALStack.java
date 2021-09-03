package linear;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/** Stack using ArrayList */
public class ALStack<T> {

    ArrayList<T> items;

    public ALStack() {
        items = new ArrayList<>();
    }

    public ALStack(int initialCapacity) {
        items = new ArrayList<>(initialCapacity);
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public static void main(String[] args) {}
}
