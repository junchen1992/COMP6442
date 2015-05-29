package lab4;

public class Addition extends Expression {
	
	private Expression x ;
	private Expression y;
	
	public Addition(Expression x, Expression y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String show() {
		return "( " + x.show() + " + " + y.show() + " )";
	}

	@Override
	public double evaluate() {
		return x.evaluate() + y.evaluate();
	}

}
