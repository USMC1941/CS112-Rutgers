package warehouse;

public class Sector {
    private Product[] products;
    private int currentSize;

    public Sector() {
        products = new Product[6];
        currentSize = 0;
    }

    /**
     * Add an item to the end of the sector, index 0 is ignored
     */
    public void add(Product prod) {
        products[currentSize + 1] = prod;
        currentSize++;
    }

    /**
     * Set some index, valid indices are from 1 to currentSize inclusive
     */
    public void set(int index, Product prod) {
        products[index] = prod;
    }

    /**
     * Delete the last element currently stored
     */
    public void deleteLast() {
        products[currentSize] = null;
        currentSize--;
    }

    /**
     * Get the product at some index
     */
    public Product get(int index) {
        return products[index];
    }

    /**
     * Get the current size
     */
    public int getSize() {
        return currentSize;
    }

    /**
     * Swap the items at 2 indices
     */
    public void swap(int index1, int index2) {
        Product temp = products[index1];
        products[index1] = products[index2];
        products[index2] = temp;
    }

    /**
     * Apply the swim algorithm from class on some index
     */
    public void swim(int index) {
        while (index > 1 && products[index].getPopularity() < products[index / 2].getPopularity()) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    /**
     * Apply the sink algorithm from class on some index
     */
    public void sink(int index) {
        while (index * 2 <= currentSize) {
            int smallestChild;
            if (index * 2 + 1 > currentSize
                    || products[index * 2].getPopularity() < products[index * 2 + 1].getPopularity()) {
                smallestChild = index * 2;
            } else {
                smallestChild = index * 2 + 1;
            }
            if (products[index].getPopularity() > products[smallestChild].getPopularity()) {
                swap(index, smallestChild);
                index = smallestChild;
            } else {
                break;
            }
        }
    }

    public String toString() {
        String sectorString = "{";
        sectorString += "null";
        for (int i = 1; i <= currentSize; i++) {
            sectorString += "; " + products[i].toString();
        }
        return sectorString + "}";
    }
}
