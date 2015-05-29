package test;

public class Person {
	private String name;
	private int age;
	
	public Person(String name) {
		this.setName(name);
	}
	
	public Person(String name, int  age) {
		this.name = name;
		this.setAge(age);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
