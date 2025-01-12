package com.streamapi.streamApi2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "David", "Eve");

		// 1. `Comparator.naturalOrder()`: Sorts in natural order
		List<String> naturalOrder = names.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println("Natural Order: " + naturalOrder);

		// 2. `Comparator.reverseOrder()`: Sorts in reverse order
		List<String> reverseOrder = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Reverse Order: " + reverseOrder);

		// 3. `Comparator.comparing()`: Compares using a key extractor
		List<String> sortedByLength = names.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		System.out.println("Sorted by Length: " + sortedByLength);

		// 4. `Comparator.comparingInt()`, `comparingLong()`, `comparingDouble()`: For
		// primitive types
		List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
		List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.comparingInt(Integer::intValue))
				.collect(Collectors.toList());
		System.out.println("Sorted Numbers (Natural Order): " + sortedNumbers);

		// 5. `Comparator.nullsFirst()`, `nullsLast()`: Handles nulls
		List<String> namesWithNulls = Arrays.asList("Charlie", null, "Alice", "Bob", null, "Eve");

		// Handling nulls first
		List<String> nullsFirst = namesWithNulls.stream().sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
				.collect(Collectors.toList());
		System.out.println("Nulls First: " + nullsFirst);

		// Handling nulls last
		List<String> nullsLast = namesWithNulls.stream().sorted(Comparator.nullsLast(Comparator.naturalOrder()))
				.collect(Collectors.toList());
		System.out.println("Nulls Last: " + nullsLast);
	}

	public static void compareAndThen(String[] args) {
		List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 30),
				new Person("Alice", 35), new Person("Bob", 20));

		// Sorting by name (ascending) and then by age (descending)
		List<Person> sortedPeople = people.stream().sorted(Comparator.comparing(Person::getName) // First, sort by name
				.thenComparing(Comparator.comparingInt(Person::getAge).reversed())) // Then, sort by age in descending
																					// order
				.collect(Collectors.toList());

		System.out.println(sortedPeople);
	}
}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return name + " (" + age + ")";
	}
}
