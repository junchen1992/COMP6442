/**
 * 
 */
package decorator;

/**
 * @author Jason
 *
 */
public class ConcreterDecorator3 extends Decorator {

	public ConcreterDecorator3(BaseComponentInterface bci) {
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
