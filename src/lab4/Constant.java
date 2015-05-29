package lab4;

public class Constant extends Expression {
	private double constant = 0.0;
	
	private static final String pi = "pi";
	private static final String e = "e";
	
	
	public Constant(String constant) {
		switch(constant) {
			case pi : 
				this.constant = 3.14159;
				break;
			case e :
				this.constant = 2.71828;
				break;
			default :
				break;
		}
	}
	
	@Override
	public String show() {
		if(this.constant == 3.14159) 
			return "pi";
		if(this.constant == 2.71828)
			return "e";
		return null;
	}

	@Override
	public double evaluate() {
		return this.constant;
	}

}
