package com.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListCrudOperation {

	public static void main(String[] args) {
		List<Person> li = new ArrayList<>();
		li.add(new Person(24, "Shailendra", "Yes"));

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age name and resign");
		int age = sc.nextInt();
		String name = sc.next();
		String resign = sc.next();
		System.out.println(age + " " + name + " " + resign);
		li.add(new Person(age, name, resign));

		System.out.println("do you wanted to see whole list type Y");

		String yesorno = sc.next();
		System.out.println("do you want to change name please enter age and name");
		age = sc.nextInt();
		name = sc.next();
		if (yesorno.equalsIgnoreCase("Y")) {
			for (Person p : li) {
				if (p.getAge() == age) {
					p.setName(name);
				}

			}
		}
		System.out.println(li);

		Iterator<Person> person = li.iterator();
		while (person.hasNext()) {
			Person p = person.next();
			System.out.println(p.getName());
		}
	}

}
