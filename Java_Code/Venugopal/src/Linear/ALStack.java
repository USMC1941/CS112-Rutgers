package Linear;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ALStack<T> {

    ArrayList<T> items;

    public ALStack() {
        items = new ArrayList<>();
    }

    public ALStack(int initialCapacity) {
        items = new ArrayList<>(initialCapacity);
    }

    public void push(T item) {
        // adds to end => top of stack is end of array list
        items.add(item);
    }

    public T pop() throws NoSuchElementException {
        try {
            return items.remove(items.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    public T peek() throws NoSuchElementException {
        try {
            return items.get(items.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
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
}
