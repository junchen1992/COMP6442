package decorator;

public class NameDecoratorDemo {

	public static void main(String[] args) {
		NameDecorator decorator = new FullName(new Name("Jun"), "Chen");
		System.out.println(decorator.showname());
	}

}
