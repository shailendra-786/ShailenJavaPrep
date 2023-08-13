package com.collection;

import java.util.Comparator;

public class PersonAgeComparaTor implements Comparator<PersonComparator> {

	@Override
	public int compare(PersonComparator o1, PersonComparator o2) {
		if (o1.getAge() == o2.getAge()) {
			return 0;
		} else if (o1.getAge() > o2.getAge()) {
			return 1;
		} else {
			return -1;
		}
	}

}
