package lab4;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Before Lab task:
		 /*Expression exp = new Inverse(new Addition(new Number(2.0), new Number(1.5)));
		 double value = exp.evaluate();
		 System.out.println(exp.show() + " evaluates to " + value);
		 */
		 // Here assumes that only one line of expression will be inputed by the user:
		 Scanner sc = new Scanner(System.in);
		 String input = sc.nextLine();
		 sc.close();
		 Tokenizer tok = new Tokenizer(input);
		 System.out.println(Expression.parse(tok).evaluate());		 
	}

}
