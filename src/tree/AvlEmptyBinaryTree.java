package tree;
/**
 * AvlEmptyBinaryTree - this is an EmptyBinaryTree for use with avl binary search trees 
 * 
 * 
 * @author Eric McCreath
 *
 */


public class AvlEmptyBinaryTree extends EmptyBinaryTree {
static private EmptyBinaryTree avlemptytree = new AvlEmptyBinaryTree();
	
	public static EmptyBinaryTree constructEmptyBinaryTree() {
		return avlemptytree;
	}
	
	public BinaryTree insert(int data) {
		return new AvlNonEmptyBinaryTree(data);
	}
}
