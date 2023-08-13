package com.collection;

import java.util.Comparator;

public class PersonNameComparaTor implements Comparator<PersonComparator> {

	@Override
	public int compare(PersonComparator o1, PersonComparator o2) {

		return o1.getName().compareTo(o2.getName());
	}

}
