package Q4;
/**
 * NonEmptyIntSet - this is a binary search tree that is either an inner node
 * of the tree or a leaf node.  Leaf nodes will have 2 empty nodes attached to 
 * the right and the left subtrees.  Note that the insert and remove operation return 
 * the changed tree and they will not modify existing trees. 
 * 
 * @author Eric McCreath - GPLv2
 */


public class NonEmptyIntSet extends IntSet {

	final int data;
	final IntSet left, right;
	
	public NonEmptyIntSet(int data) {
		this.data = data;
		left = new EmptyIntSet();
		right = new EmptyIntSet();
	}
	
	public NonEmptyIntSet(int data, IntSet left, IntSet right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public IntSet insert(int d) {
		if (data == d) {
			return this;
		} else if (d < data) {
			return new NonEmptyIntSet(data,left.insert(d),right);
		} else {
			return new NonEmptyIntSet(data,left,right.insert(d));
		}
	}
	
	public int size() {
		return 1 + left.size() + right.size();
	}

	
	@Override
	public String show() {
		String leftstr = left.show();
		String rightstr = right.show();
		leftstr = leftstr.substring(1, leftstr.length()-1);  // strip the {}
		rightstr = rightstr.substring(1, rightstr.length()-1);
		return "{" + leftstr + (leftstr.equals("") ?"":",") + data +(rightstr.equals("") ?"":",") + rightstr+ "}";
	}

	@Override
	public IntSet remove(int d) {
		// place your answer here
		if(data == d) {
			if(left.isEmpty()) return right;
			else if(right.isEmpty()) return left;
			else {
				int lmax = left.biggest();
				return new NonEmptyIntSet(lmax, left.remove(lmax), right);
			}
			/*if(!left.isEmpty()) {
				int lmax = left.biggest();
				return new NonEmptyIntSet(lmax, left.remove(lmax), right);
			} else {
				return right;
			}*/
		} else if(d < data) {
			return new NonEmptyIntSet(data, left.remove(d), right);
		} else {
			return new NonEmptyIntSet(data, left, right.remove(d));
		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}


	@Override
	public boolean elementOf(int d) {
		if (data == d) return true;
		else if (d < data) return left.elementOf(d);
		else return right.elementOf(d);
	}

	@Override
	public Integer biggest() {
		if (right.isEmpty()) return data;
		else return right.biggest();
	}	
}
