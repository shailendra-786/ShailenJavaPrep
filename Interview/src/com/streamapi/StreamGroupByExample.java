package com.streamapi;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}

public class StreamGroupByExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 30, "New York"),
                new Person("Jane", 25, "London"),
                new Person("Mike", 40, "New York"),
                new Person("Mary", 35, "London"),
                new Person("Alex", 28, "Paris"),
                new Person("Alice", 32, "Paris")
        );

        // Grouping people by city
        Map<String, List<Person>> peopleByCity = people.stream()
                .collect(Collectors.groupingBy(Person::getCity));

        System.out.println("People grouped by city:");
        System.out.println(peopleByCity);

        // Grouping people by age
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("\nPeople grouped by age:");
        System.out.println(peopleByAge);

        // Grouping people by city and then by age
        Map<String, Map<Integer, List<Person>>> peopleByCityAndAge = people.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.groupingBy(Person::getAge)));

        System.out.println("\nPeople grouped by city and then by age:");
        System.out.println(peopleByCityAndAge);
    }
}

