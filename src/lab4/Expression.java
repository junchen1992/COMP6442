package lab4;
public abstract class Expression {
	public abstract String show(); // this should show the expression as a string (which can be parsed back into a expression).
    public abstract double evaluate();  // this should evaluate the expression
    
    static public Expression parse(String str) {
    	// code that will parse the string creating the expression for that string
    	
    	// parse the input token sequence into an expression tree:
    	
    	
        return null; // this is just a place holder so you can get show and evaluate working first
    }
    
    static public Expression parse(Tokenizer tok) {
    	String current = tok.current();
    	if(current.equals("(")) {
    		current = tok.next();
    		//parse(tok);
    	}
    	
    		Expression exp1 = new Number(current);
    		//System.out.println("exp1.show:" + exp1.show());
    		String next = tok.next();
    		//System.out.println(next);
    		Expression exp2 = new Number(tok.next());
    		//System.out.println("exp2.show:" + exp2.show());
    		switch(next) {
    		case "+":
    			return new Addition(exp1, exp2);
    		case "-":
    			return new Subtraction(exp1, exp2);
    		default:
    				return null;
    		}
    	
  
    }
}
