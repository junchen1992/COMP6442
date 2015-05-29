/**
 * 
 */
package decorator;

/**
 * @author Jason
 *
 */
public abstract class Decorator implements BaseComponentInterface {
	private BaseComponentInterface bci;
	
	public Decorator(BaseComponentInterface bci) {
		this.bci = bci;
	}
	
	@Override
	public void show() {
		bci.show();
	}
}
