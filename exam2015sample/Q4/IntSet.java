package Q4;
/**
 * Intset - this implements an integer set using a 
 *          binary search tree.
 * 
 * @author Eric McCreath - GPLv2
 */

public abstract class IntSet {

	public abstract IntSet insert(int d); // add an element to the tree, this returns the new/modified tree

	public abstract int size(); // the number of element in the tree

	public abstract String show(); // show the elements of the set

	public abstract boolean isEmpty(); // check if the set is empty

	public abstract IntSet remove(int d); // remove an element from the set, this returns the modified set.  
	                                      // Note if the element d is not is in the set then the same set is just returned. 
	
	public abstract boolean elementOf(int d); // check if the element is in the set
	
	public abstract Integer biggest(); // return the biggest integer is the set (or null if there is non)
	
}
