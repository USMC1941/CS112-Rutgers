package structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements a MIN-heap data structure.
 */
public class MinHeap<T extends Comparable<T>> implements Iterable<T> {
    
	private ArrayList<T> items;
	
	/**
     * Constructs a new, empty heap with an initial capacity of 10
     */
    public MinHeap() {
    	this(10);
    }

    /**
     * Copy constructor: initializes the items in this min heap by copying
     * all the items in the other heap
     * 
     * @param other Other min heap from which items are copied to this
     */
    public MinHeap(MinHeap<T> other) {
    	items = new ArrayList<T>(other.size());
    	for (T item: other.items) {
    		items.add(item);
    	}
    }
    
    /**
     * Constructs a new, empty heap with the specified initial capacity.
     *
     * @param cap Initial capacity of the heap.
     */
    public MinHeap(int cap) {
    	items = new ArrayList<T>(cap);
    }

    public void siftUp(int k) {  // sift up starting at k
    	while (k > 0) {
    		int p = (k-1)/2;
    		int c = items.get(k).compareTo(items.get(p));
    		if (c < 0) {
    			T temp = items.get(k);
    			items.set(k, items.get(p));
    			items.set(p, temp);
    			k = p;
    		} else {
    			break;
    		}
    	}
    }

    public void siftDown(int k) {  //sift down starting at k
        while (2*k+1 < items.size()) {  // not a leaf, there is at least a left child
                int minIndex = 2*k+1;   // set minIndex to left child index
                int rightChild = minIndex + 1;
                if (rightChild < items.size()) { // there is a right child
                        int c = items.get(rightChild).compareTo(items.get(minIndex));
                        if (c < 0) { minIndex = rightChild; }
                }
                int c = items.get(minIndex).compareTo(items.get(k));
                if (c < 0) { // max child greater than k, switch
                        T temp = items.get(minIndex);
                        items.set(minIndex, items.get(k));
                        items.set(k, temp);
                        k = minIndex;  // for next iteration
                } else {
                        break;
                }
        }
    }

    
    /**
     * Inserts an item into the heap.
     * 
     * @param item Item to insert.
     */
    public void insert(T item) {
    	items.add(item);
    	siftUp(items.size()-1);
    }

    /**
     * Removes and returns the min item in the heap.
     * 
     * @return Item (min) at top of heap.
     * @throws NoSuchElementException If the heap is empty.
     */
    public T deleteMin() 
    throws NoSuchElementException {
	
    	if (items.isEmpty()) {
    		throw new NoSuchElementException();
    	}

    	// special case
    	if (items.size() == 1) {
    		return items.remove(0);
    	}
    	
    	T minItem = items.get(0);
    	items.set(0, items.remove(items.size()-1));
    	siftDown(0);
    	return minItem;
    }

    /**
     * Merges another heap into this one (i.e., all items in the other heap
     * are added to this one).
     * 
     * @param hp Heap whose elements will be merged into this heap.
     */
    public void merge(MinHeap<T> hp) {
    	// first merge the argument heap's entries into this
    	for (int i=0; i < hp.items.size(); i++) {
    		items.add(hp.items.get(i));
    	}

    	// then do a bottom-up build heap, starting from "last" non-leaf node
    	int start = items.size()/2-1;
    	for (int k=start; k >= 0; k--) {
    		siftDown(k);
    	}
    }
	    
    
    /**
     * Returns (but does not remove) the min item in the heap.
     * 
     * @return Item at top of heap.
     * @throws NoSuchElementExcepton If heap is empty.
     */
    public T getMin() 
    throws NoSuchElementException {
    	if (items.isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	return items.get(0);
    }

    /**
     * Returns the number of items currently stored in the heap.
     * 
     * @return Size of heap.
     */
    public int size() {
    	return items.size();
    }

    /**
     * Tells if the heap is empty. 
     * 
     * @return <tt>true</tt> if no items are in heap, <tt>false</tt> otherwise.
     */
    public boolean isEmpty() {
    	return items.isEmpty();
    }
    
    public Iterator<T> iterator() {
    	return items.iterator();
    }
    
    public String toString() {
    	String ret = "";
    	for (T item: items) {
    		ret += "  " + item;
    	}
    	return ret;
    }
}
