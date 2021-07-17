package apps.tree;

/**
 * An abstract class that sets up the structure for concrete implementations that
 * compare ids, or names.
 * 
 * @author Sesh Venugopal
 *
 */
abstract class IdNameItem {
	
	/**
	 * Id of item 
	 */
	int id;
	
	/**
	 * Name of item. 
	 */
	String name;

	/**
	 * Initializes a new instance with given id and name.
	 * 
	 * @param id Id of item.
	 * @param name Name of item.
	 */
	IdNameItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("(" + id + "," + name + ")");
	}
}

/**
 * A concrete implementation of IdNameItem that compares ids.
 * 
 * @author Sesh Venugopal
 *
 */
class IdItem extends IdNameItem implements Comparable<IdItem> {
	
	/**
	 * Initializes a new instance with given id and name.
	 * 
	 * @param id Id of item.
	 * @param name Name of item.
	 */
	IdItem(int id, String name) {
		super(id, name);
	}

	/**
	 * Compares id of this instance against id of another.
	 * 
	 * @param other Other instance against which this is compared.
	 * @return 0 if this and other have equal ids, < 0 if this id is less than other's id, 
	 * 			> 0 if this id is greater than other's id
	 */
	public int compareTo(IdItem other) {
		return id - other.id;
	}	
}

       
/**
 * A concrete implementation of IdNameItem that compares names.
 * 
 * @author Sesh Venugopal
 *
 */
class NameItem extends IdNameItem implements Comparable<NameItem> {
	
	/**
	 * Initializes a new instance with given id and name.
	 * 
	 * @param id Id of item.
	 * @param name Name of item.
	 */
	NameItem(int id, String name) {
		super(id, name);
	}

	/**
	 * Compares name of this instance against name of another.
	 * 
	 * @param other Other instance against which this is compared.
	 * @return 0 if this and other have equal names, < 0 if this name is less than other's name, 
	 * 			> 0 if this name is greater than other's name
	 */
	public int compareTo(NameItem other) {
		return name.compareTo(other.name);
	}	
}

