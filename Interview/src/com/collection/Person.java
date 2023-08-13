package com.collection;

public class Person {
	private int age;
	private String name;
	private String resign;

	public Person(int age, String name, String resign) {
		super();
		this.age = age;
		this.name = name;
		this.resign = resign;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResign() {
		return resign;
	}

	public void setResign(String resign) {
		this.resign = resign;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", resign=" + resign + "]";
	}

}
