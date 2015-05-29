package decorator;
/**
 * Example Exam Questions: slides14 decorator.
 * @author Jason
 *
 */
public class FullName extends Name {
	String surname;
	
	Name name;

	/*public FullName(String firstname, String surname) {
		this.name = firstname;
		this.surname = surname;
	}*/
	
	// decorator design pattern:
	public FullName(String surname, Name name) {
		this.surname = surname;
		this.name = name;
	}

	/*String showname() {
		return super.showname() + " " + surname;
	}*/
	
	String showname() {
		return name.showname() + " " + surname;
	}

	public static void main(String[] args) { 
		Name name = new FullName("Chen", new Name("Jun"));
		System.out.println(name.showname());
	}
}
