package decorator;

public class FullName extends Name {
	String surname;

	public FullName(String firstname, String surname) {
		this.name = firstname;
		this.surname = surname;
	}
	
	// decorator design pattern:
	

	String showname() {
		return super.showname() + " " + surname;
	}

	public static void main(String[] args) {

	}
}
