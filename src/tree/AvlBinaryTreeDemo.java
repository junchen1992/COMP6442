package tree;
/**
 * AvlBinaryTreeDemo - some code to demo the use of the avl binary sorted tree.
 * 
 * @author Eric McCreath - GPLv2
 */

public class AvlBinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree bt = new AvlEmptyBinaryTree();
		System.out.println("size : " + bt.size());

		System.out.println("avlBalanced " + bt.avlBalanced() + "\n"
				+ bt.treeshow());
		System.out.println("insert 7 : ");
		bt = bt.insert(7);
		System.out.println("avlBalanced " + bt.avlBalanced() + "\n"
				+ bt.treeshow());
		System.out.println("insert 9 : ");
		bt = bt.insert(9);
		System.out.println("avlBalanced " + bt.avlBalanced() + "\n"
				+ bt.treeshow());

		System.out.println("avlBalanced " + bt.avlBalanced() + "\n"
				+ bt.treeshow());

		for (int i = 0; i < 25; i++) {
			bt = bt.insert(30 - i);
			System.out.println("avlBalanced " + bt.avlBalanced() + "\n"
					+ bt.treeshow());
		}
	}

}
