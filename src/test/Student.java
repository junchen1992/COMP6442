package test;

public class Student extends Person {

	public Student(String name) {
		super(name);
	}

	public Student(String name, int age) {
		super(name, age);
	}

	public void show() {
		System.out.println("Hello " + this.getName());
	}

	public static void main(String[] args) {
		Student stu1 = new Student("Jason");
		if (stu1 instanceof Person) {
			System.out.println(stu1.getName() + " is a person");
		}
		stu1.show();
	}

}
