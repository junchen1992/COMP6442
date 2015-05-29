package lab4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * Splits the text field into tokens.
 * 
 * @author Jun Chen u5485230
 *
 */
public class Tokenizer {
	private String text;
	
	private LinkedList<String> tokens;
	private int currentPos = 0;
	
	private static final String add = "+";
	private static final String sub = "-";
	private static final String mul = "*";
	private static final String div = "/";
	// private String inv = "-";
	// private String pow = "**";

	private Set<String> operators;
	private Set<String> digits;
	private Set<String> constants;

	public Tokenizer(String text) {
		this.text = text;		
		this.initialise();
		this.tokenize(text);
	}
	
	public void initialise() {
		this.currentPos = 0;

		this.tokens = new LinkedList<String>();
		
		this.operators = new HashSet<String>();
		this.digits = new HashSet<String>();
		this.constants = new HashSet<String>();
		
		operators.add(add);
		operators.add(sub);
		operators.add(mul);
		operators.add(div);
		
		digits.add("0");
		digits.add("1");
		digits.add("2");
		digits.add("3");
		digits.add("4");
		digits.add("5");
		digits.add("6");
		digits.add("7");
		digits.add("8");
		digits.add("9");
		
		constants.add("pi");
		constants.add("e");
	}
	
	public String current() {
		return tokens.get(currentPos);
	}
	
	public String next() {
		return tokens.get(++currentPos);
	}
	
	public boolean hasNext() {
		return this.currentPos < tokens.size() - 1;
	}
	
	public String getSourceText() {
		return this.text;
	}

	public String tokenize(String str) {
		operators.add(add);
		operators.add(sub);
		operators.add(mul);
		operators.add(div);
		
		digits.add("0");
		digits.add("1");
		digits.add("2");
		digits.add("3");
		digits.add("4");
		digits.add("5");
		digits.add("6");
		digits.add("7");
		digits.add("8");
		digits.add("9");
		
		//LinkedList<String> tokens = new LinkedList<String>();
		String tokenSequence = "";
		
		String ch;
		String number = "";
		for (int i = 0; i < str.length(); i++) {
			ch = str.substring(i, i+1);
			// System.out.println("ch = " +ch);
			if(ch.equals(" "))
				continue;
			else if(ch.equals("*")) {
				if(str.substring(i+1, i+2).equals("*")) {
					tokens.add(str.substring(i, i+2));
					i ++;
				}
				else {
					tokens.add(ch);
				}
			}
			else if(ch.equals("(") || ch.equals(")") || operators.contains(ch)) {
				tokens.add(ch);
			}
			else if(digits.contains(ch)) {
				number += ch;
				int j = i + 1;
				while(j < str.length()) {
					ch = str.substring(j, j+1);
					if(ch.equals(".") || digits.contains(ch)) {
						number += ch;
						j ++;
					}
					else
						break;
				}
				tokens.add(number);
				number = "";
				i = j - 1;
			}		
		}
		
		ListIterator<String> iter = tokens.listIterator();
		while(iter.hasNext()) {
			tokenSequence += iter.next();
		}
		tokenSequence.trim();
		
		return tokenSequence;
	}
	
	public static void main(String[] args) {
		// Test:
		String exp = "- 1 +               (5 **9.7 + 6) -7 * 2 +   3.2/ 6";
		Tokenizer tok = new Tokenizer(exp);
		System.out.println(tok.current());
		while(tok.hasNext()) {
			System.out.println(tok.next());
		}
	}

}
