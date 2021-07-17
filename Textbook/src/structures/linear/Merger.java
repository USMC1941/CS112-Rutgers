package structures.linear;

/**
 * This class implements "merging" operations union, intersection, and
 * difference on two ordered lists. It is a utility class with only
 * static methods, and cannot be instantiated, i.e. objects of this class
 * cannot be created because this class has no state.
 * 
 * @author Sesh Venugopal
 *
 */
public class Merger {
	
	/**
	 * Prevents instantiation.
	 *
	 */
	private Merger() { }
	
	/**
	 * Appends the items in an ordered list to the end of another.
	 * 
	 * @param <T> Type of objects stored in the lists
	 * @param LOut The list to which items are appended
	 * @param LIn The list from which items are appended - the items in this list
	 * 				are not deleted, only references are appended to the first
	 * @param pos The starting position of the second list from which items are
	 * 				appended
	 */
	private static <T extends Comparable<T>> 
	void append(OrderedList<T> LOut, OrderedList<T> LIn, int pos) {
		while (pos < LIn.size()) {
			LOut.add(LIn.get(pos++));
		}
	}
	
	/**
	 * Computes the (set) union of two ordered lists using a modification of the
	 * "two finger" merge algorithm for ordered lists. Runs in O(m+n) time
	 * in the worst case where m and n are the lengths of the lists. The
	 * input lists are not modified by this method.
	 * 
	 * @param <T> The type of objects stored in the ordered lists
	 * @param first The first ordered list
	 * @param second The second ordered list
	 * @return A new ordered list that is the union of the two input lists
	 */
	public static <T extends Comparable<T>> 
	OrderedList<T> union(OrderedList<T> first, OrderedList<T> second) {
				
		if (first.isEmpty()) {
			OrderedList<T> result = new OrderedList<T>(second.size());
			append(result, second, 0); 
			return result; 
		} 
		
		if (second.isEmpty()) { 
			OrderedList<T> result = new OrderedList<T>(first.size());
			append(result, first, 0); 
			return result; 
		} 
		
		// neither is empty, get those fingers moving
		int size1 = first.size(); 
		int size2 = second.size(); 
		OrderedList<T> result = new OrderedList<T>(); 
		int firstFinger = 0, secondFinger = 0; 
		while (firstFinger < size1 && secondFinger < size2) { 
			// get the entries pointed to by the fingers 
			T firstItem = first.get(firstFinger); 
			T secondItem = second.get(secondFinger); 
			int c = firstItem.compareTo(secondItem);
			if (c == 0) { 
				result.add(firstItem); 
				firstFinger++; secondFinger++; 
			} else if (c < 0) { 
				result.add(firstItem); 
				firstFinger++; 
			} else { 
				result.add(secondItem); 
				secondFinger++; 
			} 
		}  
		
		// tie up loose ends 
		if (firstFinger < size1) { 
			append(result, first, firstFinger); 
		}
		if (secondFinger < size2) { 
			append(result, second, secondFinger); 
		}
		return result; 
	} 
	
	/**
	 * Computes the (set) difference of two ordered lists using a modification of the
	 * "two finger" merge algorithm for ordered lists. Runs in O(m+n) time
	 * in the worst case where m and n are the lengths of the lists. The
	 * input lists are not modified by this method.
	 * 
	 * @param <T> The type of objects stored in the ordered lists
	 * @param first The first ordered list
	 * @param second The second ordered list
	 * @return A new ordered list that is the difference of the first with the second
	 */
	public static <T extends Comparable<T>> 
	OrderedList<T> difference(OrderedList<T> first, OrderedList<T> second) {
				
		if (first.isEmpty()) { 
			return null;
		} 
		
		if (second.isEmpty()) {
			OrderedList<T> result = new OrderedList<T>(first.size());
			append(result, first, 0); 
			return result; 
		} 
		
		// neither is empty, get those fingers moving
		int size1 = first.size(); 
		int size2 = second.size(); 
		OrderedList<T> result = new OrderedList<T>(); 
		int firstFinger = 0, secondFinger = 0; 
		while (firstFinger < size1 && secondFinger < size2) { 
			// get the entries pointed to by the fingers 
			T firstItem = first.get(firstFinger); 
			T secondItem = second.get(secondFinger); 
			int c = firstItem.compareTo(secondItem);
			if (c == 0) { 
				firstFinger++; secondFinger++; 
			} else if (c < 0) { 
				result.add(firstItem); 
				firstFinger++; 
			} else { 
				secondFinger++; 
			} 
		}  
		
		// tie up loose ends 
		if (firstFinger < size1) { 
			append(result, first, firstFinger);
		}
		return result; 
	}
	
	/**
	 * Computes the (set) intersection of two ordered lists using a modification of the
	 * "two finger" merge algorithm for ordered lists. Runs in O(m+n) time
	 * in the worst case where m and n are the lengths of the lists. The
	 * input lists are not modified by this method.
	 * 
	 * @param <T> The type of objects stored in the ordered lists
	 * @param first The first ordered list
	 * @param second The second ordered list
	 * @return A new ordered list that is the intersection of the two input lists
	 */
	public static <T extends Comparable<T>> 
	OrderedList<T> intersection(OrderedList<T> first, OrderedList<T> second) {
		if (first.isEmpty() || second.isEmpty()) {
			return null; 
		} 
		
		// neither is empty, get those fingers moving
		int size1 = first.size(); 
		int size2 = second.size(); 
		OrderedList<T> result = new OrderedList<T>(); 
		int firstFinger = 0, secondFinger = 0; 
		while (firstFinger < size1 && secondFinger < size2) { 
			// get the entries pointed to by the fingers 
			T firstItem = first.get(firstFinger); 
			T secondItem = second.get(secondFinger); 
			int c = firstItem.compareTo(secondItem);
			if (c == 0) { 
				result.add(firstItem); 
				firstFinger++; secondFinger++; 
			} else if (c < 0) { 
				firstFinger++; 
			} else { 
				secondFinger++; 
			} 
		}  
		
		return result; 
	}
}
