package com.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class EnhanceAndItrCollection {

	public static void main(String[] args) {
		List<Person> li = new ArrayList<>();
		li.add(new Person(24, "Shailendra", "Yes"));
		li.add(new Person(25, "Bhushan", "Yes"));

		// enhance loop
		for (Person p : li) {
			System.out.println(p);
		}
		// using iterator
		Iterator<Person> per = li.iterator();
		while (per.hasNext()) {
			Person p = per.next();
			System.out.println(p);
		}

		Map<String, Person> map = new HashMap<>();
		map.put("comp", new Person(24, "Shailendra", "Yes"));
		map.put("comp1", new Person(25, "Bhushan", "Yes"));

		// enhance loop for map
		for (Map.Entry<String, Person> m : map.entrySet()) {
			System.out.println(m);
		}

		Iterator<Entry<String, Person>> m = map.entrySet().iterator();
		while (m.hasNext()) {
			Entry<String, Person> m2 = m.next();
			System.out.println(m2.getKey() + " " + m2.getValue());
		}

	}

}
