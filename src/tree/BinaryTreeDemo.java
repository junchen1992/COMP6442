package tree;

/**
 * BinaryTreeDemo - some code to demo the use of the binary sorted tree.
 * @author Eric McCreath - GPLv2
 */


public class BinaryTreeDemo {

	
	public static void main(String[] args) {
		BinaryTree bt = new NonEmptyBinaryTree(5, new NonEmptyBinaryTree(3), new NonEmptyBinaryTree(13,new NonEmptyBinaryTree(8), new NonEmptyBinaryTree(14)) );
		System.out.println("size : " + bt.size());
		
		System.out.println(bt.treeshow());
		System.out.println("insert 7 : ");
		bt = bt.insert(7);
		System.out.println(bt.treeshow());
		System.out.println("insert 9 : ");
		bt = bt.insert(9);
		System.out.println(bt.treeshow());
		System.out.println("remove 13 : ");
		bt = bt.remove(13);
		System.out.println(bt.treeshow());
		
		bt.inorder((NonEmptyBinaryTree) bt);
		
	}

}
