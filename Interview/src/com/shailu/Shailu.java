package com.shailu;

import java.util.ArrayList;
import java.util.*;

interface ArrowFunc {
	int getData(int a,int b);
}

public class Shailu {
	public int comapreData(Student s, Student s1) {
		return s.getName().compareTo(s1.getName());

	}

//	public int comapreageData(Student s, Student s1) {
//		return s.getAge().compareTo(s1.getAge());
//
//	}

	public static void main(String[] args) {
		List<Student> al = new ArrayList<>();
		al.add(new Student(12, "Princu"));
		al.add(new Student(15, "Akash"));
		Shailu shailu = new Shailu();
		Collections.sort(al, shailu::comapreData);
		al.stream().map(x -> x.getName()).forEach(System.out::println);
//		Collections.sort(al, shailu::comapreageData);
		al.stream().map(x -> x.getAge()).forEach(System.out::println);
		ArrowFunc lambda = (a,b) -> a+b;
		 System.out.println(lambda.getData(1,2));

	}

}

class Student {

	private int age;
	private String name;

	public Student(int age, String name) {
		this.name = name;
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}
