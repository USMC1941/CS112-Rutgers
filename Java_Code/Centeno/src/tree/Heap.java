package tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

    // Mode: min or max heap
    static final int MIN_HEAP = 1;
    static final int MAX_HEAP = 2;
    private int mode;

    private ArrayList<T> items;

    public Heap(int mode) {
        items = new ArrayList<>();
        this.mode = mode;
    }

    private void siftUp() {
        int k = items.size() - 1; // index of last item (just inserted)
        while (k > 0) {
            int p = (k - 1) / 2; // k's parent index
            T kid = items.get(k);
            T parent = items.get(p);
            if (mode == MAX_HEAP && kid.compareTo(parent) > 0
                    || mode == MIN_HEAP && kid.compareTo(parent) < 0) {
                // swap kid with parent
                items.set(k, parent);
                items.set(p, kid);
                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }

    public void insert(T item) {
        items.add(item);
        siftUp();
    }

    private void siftDown() {
        int k = 0; // root index
        int l = 2 * k + 1; // left child index
        while (l < items.size()) {
            int r = l + 1; // right child index
            int max = l;
            if (r < items.size()
                    && ((mode == MAX_HEAP && items.get(r).compareTo(items.get(l)) > 0)
                            || (mode == MIN_HEAP && items.get(r).compareTo(items.get(l)) < 0))) {
                max = r;
            }
            if ((mode == MAX_HEAP && items.get(max).compareTo(items.get(k)) > 0)
                    || (mode == MIN_HEAP && items.get(max).compareTo(items.get(k)) < 0)) {
                // swap
                T parent = items.get(k);
                items.set(k, items.get(max));
                items.set(max, parent);
                // move one level down
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public T delete() {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        T root = items.get(0); // get the root
        T lastItem = items.remove(items.size() - 1);
        items.set(0, lastItem); // move the last item into the root
        siftDown();
        return root;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
