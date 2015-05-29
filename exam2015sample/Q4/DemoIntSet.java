package Q4;
/**
 * BinaryTreeDemo - some code to demo the use of the binary sorted tree.
 * @author Eric McCreath - GPLv2
 */


public class DemoIntSet {

	
	public static void main(String[] args) {
		IntSet set = EmptyIntSet.constructEmptyIntSet();
		System.out.println("set : " + set.show() +  "  size : " + set.size());
		
		System.out.println("insert 7, 3, 8, 9, 11, 5, 6: ");
		set = set.insert(7);
		set = set.insert(3);
		set = set.insert(8);
		set = set.insert(9);
		set = set.insert(11);
		set = set.insert(5);
		set = set.insert(6);
		System.out.println("set : " + set.show() +  "  size : " + set.size());

		System.out.println("remove 7 : ");
		set = set.remove(7);
		System.out.println("set : " + set.show() +  "  size : " + set.size());

		System.out.println("remove 5 : ");
		set = set.remove(5);
		System.out.println("set : " + set.show() +  "  size : " + set.size());
		
		System.out.println("remove 21 : ");
		set = set.remove(21);
		System.out.println("set : " + set.show() +  "  size : " + set.size());

		System.out.println("remove 8 : ");
		set = set.remove(8);
		System.out.println("set : " + set.show() +  "  size : " + set.size());

		
		
	}

}
