package tree;

/**
 * AvlNonEmptyBinaryTree - this is a binary search tree that is either an inner node
 * of the tree or a leaf node.  Leaf nodes will have 2 empty nodes attached to 
 * the right and the left subtrees.  Note that the insert and remove operation return 
 * the changed tree and they will generally modify existing trees.   this code uses the
 * avl approach to re-balance the tree after an element has been inserted.
 * 
 * @author Eric McCreath - GPLv2
 */


public class AvlNonEmptyBinaryTree extends NonEmptyBinaryTree {

	public AvlNonEmptyBinaryTree(int data) {
		super(data, new AvlEmptyBinaryTree(), new AvlEmptyBinaryTree());
		
	}
	
	public AvlNonEmptyBinaryTree(int data, BinaryTree left, BinaryTree right) {
		super(data,left,right);
	}
	
	public BinaryTree remove(int d) {
		throw new Error();  // currently the avl remove has not be implemented
		
		
	}
	public BinaryTree insert(int d) {
		AvlNonEmptyBinaryTree res;
		if (data == d) {
			res = this;
		} else if (d < data) {
			left = left.insert(d);
			res = this;
		} else {
			right = right.insert(d);
			res = this;
		}
		if (res.balanceFactor() == -2 && res.right.balanceFactor() == 1) { 
			return rotateRL();
		} else if (res.balanceFactor() == -2 && res.right.balanceFactor() == -1) {
			return rotateRR();
		} else if (res.balanceFactor() == 2 && res.left.balanceFactor() == 1) {
			return rotateLL();
		} else if (res.balanceFactor() == 2 && res.left.balanceFactor() == -1) {
			return rotateLR();
		} 
		return res;
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
		String strdata = data + " (" + this.balanceFactor() + ")";
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

	
	private AvlNonEmptyBinaryTree rotateRL() {
		AvlNonEmptyBinaryTree r = (AvlNonEmptyBinaryTree) this.right;
		AvlNonEmptyBinaryTree rl = (AvlNonEmptyBinaryTree) ((AvlNonEmptyBinaryTree) this.right).left;
		return (new AvlNonEmptyBinaryTree(rl.data,new AvlNonEmptyBinaryTree(data,left,rl.left),new AvlNonEmptyBinaryTree(r.data,rl.right,r.right)));
	}
	private AvlNonEmptyBinaryTree rotateRR() {
		AvlNonEmptyBinaryTree r = (AvlNonEmptyBinaryTree) this.right;
		AvlNonEmptyBinaryTree rr = (AvlNonEmptyBinaryTree) ((AvlNonEmptyBinaryTree) this.right).right;
		return (new AvlNonEmptyBinaryTree(r.data,new AvlNonEmptyBinaryTree(data,left,r.left),rr));
	}
	private AvlNonEmptyBinaryTree rotateLL() {
		AvlNonEmptyBinaryTree l = (AvlNonEmptyBinaryTree) this.left;
		AvlNonEmptyBinaryTree ll = (AvlNonEmptyBinaryTree) ((AvlNonEmptyBinaryTree) this.left).left;
		return (new AvlNonEmptyBinaryTree(l.data, ll,new AvlNonEmptyBinaryTree(data,l.right,right)));
	}
	private AvlNonEmptyBinaryTree rotateLR() {
		AvlNonEmptyBinaryTree l = (AvlNonEmptyBinaryTree) this.left;
		AvlNonEmptyBinaryTree lr = (AvlNonEmptyBinaryTree) ((AvlNonEmptyBinaryTree) this.left).right;
		return (new AvlNonEmptyBinaryTree(lr.data,new AvlNonEmptyBinaryTree(l.data,l.left,lr.right),new AvlNonEmptyBinaryTree(data,lr.right,right)));
	}
}
