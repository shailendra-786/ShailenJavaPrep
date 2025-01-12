package geeks.array;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that 

//appears more than N/2 times in the array.

public class MajorityElement {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 3, 3, 3, 3, 2, 4, 4, 4, 4, 4 };

		Map<Integer, Long> majorityElement = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(num -> num, Collectors.counting()));
		// I've used the boxed() method to
		// convert the IntStream to a
		// Stream<Integer>. This is
		// necessary because
		// Collectors.groupingBy works with
		// streams of objects, not primitive
		// types.
		// or you can use mapToObj(Integer::valueOf) instead of boxed()

		System.out.println("Count of majority elements: " + majorityElement);

		int maxRepeatedNumber = majorityElement.entrySet().stream().max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey).orElse(-1);
		System.out.println(maxRepeatedNumber);

	}
}
