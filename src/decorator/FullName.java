package decorator;
/**
 * Example Exam Questions: slides14 decorator.
 * @author Jason
 *
 */
public class FullName extends NameDecorator {
	
	String surname;
	
	public FullName(NameInterface nif) {
		super(nif);
	}
	
	public FullName(NameInterface nif, String surname) {
		super(nif);
		this.surname = surname;
	}
	
	public String showname() {
		return this.surname + " " + super.showname();
	}
}
