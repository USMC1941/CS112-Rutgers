package warehouse;

/**
 * This class implements a warehouse on a Hash Table like structure,
 * where each entry of the table stores a priority queue.
 * Due to your limited space, you are unable to simply rehash to get more space.
 * However, you can use your priority queue structure to delete less popular items
 * and keep the space constant.
 *
 * @author Ishaan Ivaturi
 */
public class Warehouse {
    private Sector[] sectors;

    /**
     * Initializes every sector to an empty sector
     */
    public Warehouse() {
        sectors = new Sector[10];
        for (int i = 0; i < 10; i++) {
            sectors[i] = new Sector();
        }
    }

    /**
     * Provided method, code the parts to add their behavior
     *
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void addProduct(int id, String name, int stock, int day, int demand) {
        evictIfNeeded(id);
        addToEnd(id, name, stock, day, demand);
        fixHeap(id);
    }

    /**
     * Add a new product to the end of the correct sector.
     * Requires proper use of the {@link Sector#add(Product)} method in the Sector class
     *
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    private void addToEnd(int id, String name, int stock, int day, int demand) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Fix the heap structure of the sector, assuming the item was already added.
     * Requires proper use of the {@link Sector#swim(int)} and {@link Sector#getSize()}
     * methods in the Sector class
     *
     * @param id The id of the item which was added
     */
    private void fixHeap(int id) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Delete the least popular item in the correct sector, only if its size is 5 while maintaining heap.
     * Requires proper use of the {@link Sector#swap(int, int)}, {@link Sector#deleteLast()},
     * and {@link Sector#swim(int)} methods in the Sector class.
     *
     * @param id The id of the item which is about to be added
     */
    private void evictIfNeeded(int id) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Update the stock of some item by some amount.
     * Requires proper use of the {@link Sector#getSize()} and {@link Sector#get(int)}
     * methods in the Sector class.
     * Requires proper use of the {@link Product#updateStock(int)} method in the Product class.
     *
     * @param id The id of the item to restock
     * @param amount The amount by which to update the stock
     */
    public void restockProduct(int id, int amount) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Delete some arbitrary product while maintaining the heap structure in O(logn).
     * Requires proper use of the {@link Sector#getSize()}, {@link Sector#get(int)},
     * {@link Sector#swap(int, int)}, {@link Sector#deleteLast()}, {@link Sector#swim(int)}
     * and/or {@link Sector#swim(int)} methods.
     * Requires proper use of the {@link Product#getId()} method from the Product class.
     *
     * @param id The id of the product to delete
     */
    public void deleteProduct(int id) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Simulate a purchase order for some product.
     * Requires proper use of the {@link Sector#getSize()}, {@link Sector#sink(int)},
     * {@link Sector#get(int)} methods in the Sector class.
     * Requires proper use of the {@link Product#getId()}, {@link Product#getStock()},
     * {@link Product#setLastPurchaseDay(int)}, {@link Product#updateStock(int)},
     * {@link Product#updateDemand(int)} methods.
     *
     * @param id The id of the purchased product
     * @param day The current day
     * @param amount The amount purchased
     */
    public void purchaseProduct(int id, int day, int amount) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Construct a better scheme to add a product, where empty spaces are always filled.
     *
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void betterAddProduct(int id, String name, int stock, int day, int demand) {
        // WRITE YOUR CODE HERE
    }

    /**
     * Returns the String representation of the warehouse
     */
    public String toString() {
        String warehouseString = "[\n";
        for (int i = 0; i < 10; i++) {
            warehouseString += "\t" + sectors[i].toString() + "\n";
        }
        return warehouseString + "]";
    }

    /**
     * Do not remove this method, it is used by Autolab.
     */
    public Sector[] getSectors() {
        return sectors;
    }
}
