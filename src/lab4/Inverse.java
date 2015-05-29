package lab4;

public class Inverse extends Expression {
	
	private Expression x;
	
	public Inverse(Expression x) {
		this.x = x;
	}
	
	@Override
	public String show() {
		return "- " + x.show();
	}

	@Override
	public double evaluate() {
		return -1 * x.evaluate();
	}

}
