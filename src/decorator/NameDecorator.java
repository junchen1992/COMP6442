package decorator;

public abstract class NameDecorator implements NameInterface {
	private NameInterface nif;

	public NameDecorator(NameInterface nif) {
		this.nif = nif;
	}

	@Override
	public String showname() {
		return nif.showname();
	}
}
