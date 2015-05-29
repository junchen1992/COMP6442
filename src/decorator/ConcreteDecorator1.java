/**
 * 
 */
package decorator;

/**
 * @author Jason
 *
 */
public class ConcreteDecorator1 extends Decorator {

	public ConcreteDecorator1(BaseComponentInterface bci) {
		super(bci);
	}

	public void show() {
		super.show();
		this.doStuff();
	}

	private void doStuff() {
		System.out.println("con-dec1");
	}

}
