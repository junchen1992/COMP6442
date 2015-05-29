/**
 * 
 */
package decorator;

/**
 * @author Jason
 *
 */
public class ConcreteDecorator2 extends Decorator {

	public ConcreteDecorator2(BaseComponentInterface bci) {
		super(bci);
	}

	public void show() {
		super.show();
		this.doStuff();
	}

	private void doStuff() {
		System.out.println("con-dec2");
	}
	
}
