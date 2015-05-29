/**
 * This file demos the in-lecture example of the Decorator Design Pattern.
 * ref: http://chenjumin.iteye.com/blog/582951
 */
package decorator;

/**
 * @author Jason
 *
 */
public class DecoratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseComponentInterface bci = new BaseComponent1();
		
		ConcreteDecorator1 cd1 = new ConcreteDecorator1(bci);
		cd1.show();
		
		ConcreteDecorator2 cd2 = new ConcreteDecorator2(bci);
		cd2.show();
	}

}
