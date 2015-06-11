package tree;

import java.util.ArrayList;

/**
 * NonEmptyBinaryTree - this is a binary search tree that is either an inner node
 * of the tree or a leaf node.  Leaf nodes will have 2 empty nodes attached to 
 * the right and the left subtrees.  Note that the insert and remove operation return 
 * the changed tree and they will generally modify existing trees. 
 * 
 * 
 * @author Eric McCreath - GPLv2
 */


public class NonEmptyBinaryTree extends BinaryTree {

	int data;
	BinaryTree left, right;
	
	ArrayList<Integer> inorderdata = new ArrayList<Integer>();
	
	public NonEmptyBinaryTree(int data) {
		this.data = data;
		left = new EmptyBinaryTree();
		right = new EmptyBinaryTree();
	}
	
	public NonEmptyBinaryTree(int data, BinaryTree left, BinaryTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public void inorder(NonEmptyBinaryTree nbt) {
		if(!nbt.left.isEmpty()) {
			inorder((NonEmptyBinaryTree)nbt.left);
		}
		//System.out.println(nbt.data);
		inorderdata.add(nbt.data);
		if(!nbt.right.isEmpty()) {
			inorder((NonEmptyBinaryTree)nbt.right);
		}
	}
	
	@Override
	public boolean isBST() {
		for(int i = 1; i < this.inorderdata.size(); i++) {
			if(this.inorderdata.get(i) < this.inorderdata.get(i-1)) 
				return false;
		}
		return true;
	}
	
	public BinaryTree insert(int d) {
		if (data == d) {
			return this;
		} else if (d < data) {
			left = left.insert(d);
			return this;
		} else {
			right = right.insert(d);
			return this;
		}
	}
	
	public int size() {
		return 1 + left.size() + right.size();
	}

	@Override
	public int height() {
		return 1 + Math.max(left.height(), right.height());
	}

	@Override
	public String show() {
		if (left.isEmpty() && right.isEmpty()) return data + "";
		else return data + " (" + left.show() + "," + right.show() + ")";
	}

	@Override
	public BinaryTree remove(int d) {
		if (data == d) {
			if (left.isEmpty()) return right;
			else if (right.isEmpty()) return left;
			else {
				int b = left.biggest();
				left = left.remove(b);
				data = b;
				return this;
			}
		} else if (d < data) {
		    left = left.remove(d);
		    return this;
		} else {
			right = right.remove(d);
		    return this;
		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Integer biggest() {
        if (right.isEmpty()) return data;
        else return right.biggest();
	}

	@Override
	public String treeshow() {
		if (left.isEmpty() && right.isEmpty()) return " " + data + " ";
		String stl = left.treeshow();
		String str = right.treeshow();
		String stal[] = stl.split("\n");
		String star[] = str.split("\n");
		int lenl = stal[0].length();
		int lenr = star[0].length();
		StringBuffer res = new StringBuffer();
		String strdata = data + "";
		int centre = lenl;
		res.append(repeat(" ", (centre)) + strdata + repeat(" ", lenl + lenr - strdata.length() - centre) + "\n");
		int lcentre = centre(stal[0]);
		int rcentre = centre(star[0]);
		
		res.append(repeat(" ",lcentre) + "+" + repeat("-",centre-lcentre-1) + "+" + repeat("-",rcentre-1) +  "+" + repeat(" ",lenl+lenr-centre-rcentre -1) +" \n");
		res.append(repeat(" ",lcentre) + (left.isEmpty()? " " : "|") + repeat(" ",centre-lcentre-1) + " " + repeat(" ",rcentre-1) +  (right.isEmpty()? " " : "|") + repeat(" ",lenl+lenr-centre-rcentre-1) +" \n");
		
		for(int i = 0;i<Math.max(stal.length, star.length);i++) {
			res.append( (i<stal.length ? stal[i] : repeat(" ", lenl)) + (i<star.length? star[i] : repeat(" ", lenr)) + "\n");
		}
		return res.toString();
	}

	protected int centre(String string) {
		int i = 0;
		while (i < string.length() && string.charAt(i) == ' ') i++;
		return i;
	}

	protected String repeat(String string, int n) {
		String res = "";
		for (int i = 0; i<n;i++) res += string;
		return res;
	}

	@Override
	public boolean elementOf(int d) {
		if (data == d) return true;
		else if (d < data) return left.elementOf(d);
		else return right.elementOf(d);
	}

	@Override
	public int balanceFactor() {
		return left.height() - right.height();
	}
	
	public boolean avlBalanced() {
		return -1 <= balanceFactor() && balanceFactor() <= 1 && left.avlBalanced() && right.avlBalanced();
	}

	

	
	
	
	
	
}
