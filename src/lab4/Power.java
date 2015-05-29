package lab4;

public class Power extends Expression {

	private Expression x ;
	private Expression y;
	
	public Power(Expression x, Expression y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String show() {
		return "( " + x.show() + " ** " + y.show() + " )";
	}

	@Override
	public double evaluate() {
		return Math.pow(x.evaluate(), y.evaluate());
	}

}
