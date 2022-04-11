/**
 * Implementation of Weighted Union Find
 *
 * @author Ana Paula Centeno
 */
public class WeightedQuickUnionFind {

    /**
     * used by weighted union-find, see quick-union slides
     */
    private int[] parent;

    /**
     * used by weighted union-find.
     */
    private int[] size;

    /**
     * Constructor
     * @param n initializes parent and size arrays to size n
     */
    public WeightedQuickUnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Returns the root of the tree containing i, see quick-union slides
     * @param i the element
     * @return the root of the tree containing i
     */
    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    /**
     * Unify two sets: the set containing element p with the set containing element q
     * using the weighted quick-union algorithm. Update the size array accordingly.
     *
     * If the two elements already belong to the same set, nothing should be changed.
     *
     * @param p: element p
     * @param q: element q
     */
    public void union(int p, int q) {

        int root1 = find(p);
        int root2 = find(q);
        if (root1 == root2) {
            return;
        }

        // this block will set root1 as the root of the smaller tree
        if (size[root1] >= size[root2]) {
            int temp = root1;
            root1 = root2;
            root2 = temp;
        }

        // Assuming root1 has the root of the smaller tree
        parent[root1] = root2; // link root of smaller tree to root of larger tree
        size[root2] += size[root1];
    }
}
