package com.serilazi;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 2L;

	private String name;
	private int age;
	private transient String address;

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	

}