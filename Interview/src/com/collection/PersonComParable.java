package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PersonComParable implements Comparable<PersonComParable> {
	private int age;
	private String name;
	private String resign;

	public PersonComParable(int age, String name, String resign) {
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
		return "PersonComParable [age=" + age + ", name=" + name + ", resign=" + resign + "]";
	}

//	@Override
//	public int compareTo(PersonComParable o) {
//		return this.name.compareTo(o.name);  // for reverse order we used o.name.compareTo(this.name);
//	}
	
	@Override
	public int compareTo(PersonComParable o) {
		if (age == o.age)
			return 0;
		else if (age > o.age)  // for reverse order '<' and for normal one '>'
			return 1;
		else
			return -1;
	}


	public static void main(String... args) {
		List<PersonComParable> li = new ArrayList<>();

		li.add(new PersonComParable(24, "shailendra", "yes"));
		li.add(new PersonComParable(25, "Bhushan", "yes"));
		li.add(new PersonComParable(26, "raj", "no"));

		Collections.sort(li);  // V.I.P for comparable iterface 

		System.out.println(li.toString());

	}

}
