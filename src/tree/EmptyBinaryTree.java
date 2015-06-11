package tree;
/**
 * 
 * EmptyBinaryTree - the is the empty tree.  Note it has no fields so all empty trees are the same.  
 * Note I have added a static factory method that just return the same object.  
 * This saves on creating many objects which are all just the same.
 * 
 * @author Eric McCreath - GPLv2
 */

public class EmptyBinaryTree extends BinaryTree {

	static private EmptyBinaryTree emptytree = new EmptyBinaryTree();
	
	public static EmptyBinaryTree constructEmptyBinaryTree() {
		return emptytree;
	}
	
	public int size() {
		return 0;
	}

	public BinaryTree insert(int data) {
		return new NonEmptyBinaryTree(data);
	}

	@Override
	public int height() {
		return -1;
	}

	@Override
	public String show() {
		return "";
	}

	@Override
	public BinaryTree remove(int data) {
		return this;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public Integer biggest() {
		return null;
	}

	@Override
	public String treeshow() {

		return " ";
	}

	@Override
	public boolean elementOf(int d) {
		return false;
	}

	@Override
	public int balanceFactor() {
		return 0;
	}

	@Override
	public boolean avlBalanced() {
		return true;
	}
	
	public boolean isBST() {
		return true;
	}

	@Override
	public void inorder(NonEmptyBinaryTree nbt) {
		// TODO Auto-generated method stub
		
	}
}
