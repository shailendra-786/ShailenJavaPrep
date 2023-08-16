package geeks.array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateFromArray {

	public static void main(String[] args) {
		int a[] = { 2, 3, 1, 2, 3 };
		Set<Integer> seen = new HashSet<>();
		Set<Integer> duplicate = new HashSet<>();

		for (int i = 0; i < a.length; i++) {
			if (seen.contains(a[i])) {
				duplicate.add(a[i]);
			} else {
				seen.add(a[i]);
			}
		}

		System.err.println(duplicate + " " + seen);

	}

}
