package tree;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *  GeneralTree - some example code of a general multiway tree
 * 
 * @author Eric McCreath GPLv2
 *
 */

public class GTree {
	String data;
	ArrayList<GTree> children;

	public GTree(String data) {
		this.data = data;
		children = new ArrayList<GTree>();
	}

	public GTree(String data, GTree trees[]) {
		this.data = data;
		children = new ArrayList<GTree>();
		for (GTree t : trees)
			children.add(t);
	}

	public void dft() {
		System.out.print(data + " ");
		for (GTree t : children) {
			t.dft();
			// System.out.print("(" +data + ") ");
		}
		// System.out.print("{" +data + "} ");
	}

	public void bft() {
		LinkedList<GTree> queue = new LinkedList<GTree>();
		queue.add(this);
		while (queue.size() > 0) {
			GTree t = queue.removeFirst();
			System.out.print(t.data + " ");
			for (GTree c : t.children) {
				queue.add(c);
			}
		}
	}

	public int size() {
		int sum = 1;
		for (GTree c : children) sum += c.size();
		return sum;
	}
	
	public int height() {
		int max = 0;
		for (GTree c : children) max = Math.max(max, c.height() + 1);
		return max;
	}
	
	public static void main(String[] args) {

		GTree tree = new GTree("A",
				new GTree[] {
						new GTree("B", new GTree[] { new GTree("C") }),
						new GTree("D"),
						new GTree("E", new GTree[] { new GTree("F"),
								new GTree("G") }) });
		System.out.println("size : " + tree.size());
		System.out.println("height : " + tree.height());
		System.out.print("dft : ");
		tree.dft();
		System.out.println();
		System.out.print("bft : ");
		tree.bft();
		System.out.println();
		
	}
}
