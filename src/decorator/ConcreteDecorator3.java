/**
 * 
 */
package decorator;

/**
 * @author Jason
 *
 */
public class ConcreteDecorator3 extends Decorator {

	public ConcreteDecorator3(BaseComponentInterface bci) {
		super(bci);
	}

	public void show() {
		super.show();
		this.doStuff();
	}

	private void doStuff() {
		System.out.println("con-dec3");
	}
	
}
