package app;

/**
 * This class holds a (name, array of integer values) pair for an array. The name is a sequence of
 * one or more letters.
 *
 * @author ru-nb-cs112
 */
public class Array {

    /** Name, sequence of letters */
    public String name;

    /** Array of integer values */
    public int[] values;

    /**
     * Initializes with name, and sets values to null.
     *
     * @param name Name of array
     */
    public Array(String name) {
        this.name = name;
        values = null;
    }

    public String toString() {
        if (values == null || values.length == 0) {
            return name + "=[ ]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("=[");
        sb.append(values[0]);
        for (int i = 1; i < values.length; i++) {
            sb.append(',');
            sb.append(values[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Array)) {
            return false;
        }
        Array as = (Array) o;
        return name.equals(as.name);
    }
}
