package decorator;

public class Name implements NameInterface {

	String name;

	public Name() {

	}

	public Name(String name) {
		this.name = name;
	}

	@Override
	public String showname() {
		return this.name;
	}

}
