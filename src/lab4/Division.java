package lab4;

public class Division extends Expression {

	private Expression x ;
	private Expression y;
	
	public Division(Expression x, Expression y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String show() {
		return "( " + x.show() + " / " + y.show() + " )";
	}

	@Override
	public double evaluate() {
		return x.evaluate() / y.evaluate();
	}

}
