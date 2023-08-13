package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonComparator{
	private int age;
	private String name;
	private String resign;

	PersonComparator() {
	}

	public PersonComparator(int age, String name, String resign) {
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
		return "PersonComparator [age=" + age + ", name=" + name + ", resign=" + resign + "]";
	}


	public static void main(String... args) {
		List<PersonComparator> li = new ArrayList<>();

		li.add(new PersonComparator(26, "raj", "no"));
		li.add(new PersonComparator(24, "shailendra", "yes"));
		li.add(new PersonComparator(25, "Bhushan", "yes"));

		Collections.sort(li, new PersonNameComparaTor());

		System.out.println("PersonNameComparaTor" + li.toString());
		
		Collections.sort(li,new PersonAgeComparaTor());
		System.out.println("PersonAgeComparaTor "+li.toString());
	}

}
