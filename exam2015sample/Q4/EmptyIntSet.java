package Q4;
/**
 * 
 * EmptyIntSet - the is the empty tree.  Note it has no fields so all empty trees are the same.  
 * Note I have added a static factory method that just return the same object.  
 * This saves on creating many objects which are all just the same.
 * 
 * @author Eric McCreath - GPLv2
 */

public class EmptyIntSet extends IntSet {

	static private EmptyIntSet emptytree = new EmptyIntSet();
	
	public static EmptyIntSet constructEmptyIntSet() {
		return emptytree;
	}
	
	public int size() {
		return 0;
	}

	public IntSet insert(int data) {
		return new NonEmptyIntSet(data);
	}

	@Override
	public String show() {
		return "{}";
	}

	@Override
	public IntSet remove(int data) {
		// place your answer here
		return emptytree;
		//return null;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}
	
	@Override
	public boolean elementOf(int d) {
		return false;
	}

	@Override
	public Integer biggest() {
		return null;
	}

}
