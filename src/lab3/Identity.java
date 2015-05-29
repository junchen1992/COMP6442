package lab3;


/**
 * 
 */

/**
 * @author Jason
 *
 */
public class Identity {

	static int identity(int x) {
		if (20 <= x && x <= 30) {
			x /= 2;
		}
		if (5 <= x && x <= 15) {
			x *= 2;
		}
		return x;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(identity(10));
	}

}
