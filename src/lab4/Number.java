package lab4;

public class Number extends Expression {
	private double number = 0.0;
	
	public Number(double number) {
		this.number = number;
	}
	
	public Number(String str) {
		this.number = Double.parseDouble(str);
	}

	@Override
	public String show() {
		return Double.toString(number);
	}

	@Override
	public double evaluate() {
		return number;
	}
	
}
