package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {

	public static void main(String[] args) {
		Predicate<Integer> p = n -> n % 2 == 0;

		List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6);

		List<Integer> li1 = li.stream().filter(p).collect(Collectors.toList());
		System.out.println(li1);

		int maxNumber = li.stream().mapToInt(Integer::intValue).max().getAsInt();
		System.out.println(maxNumber);

		Predicate<Integer> isPrime = number -> {
			if (number <= 1) {
				return false;
			}
			for (int i = 2; i < Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		};

		li.stream().filter(isPrime).forEach(System.out::println);
		System.out.println("============================");
		int numTosses = 3;
		double probability = 1.0 / Math.pow(2, numTosses);

		Stream.iterate(0, i -> i + 1).limit((long) Math.pow(2, numTosses)).map(Integer::toBinaryString)
				.map(s -> String.format("%" + numTosses + "s", s).replace(' ', '0'))
				.map(s -> s.chars().mapToObj(c -> c == '0' ? "T" : "H").reduce("", (a, b) -> a + b))
				.forEach(System.out::println);
		// .forEach(s -> System.out.println(s + " : " + probability));
		System.out.println("============================");

		IntStream.rangeClosed(1, 100).mapToObj(
				n1 -> n1 % 3 == 0 ? (n1 % 5 == 0 ? "FizzBuzz" : "Fizz") : (n1 % 5 == 0 ? "Buzz" : Integer.toString(n1)))
				.forEach(System.out::println);
		System.out.println("============================");
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 3, 8 };
		int num = 3;
		int[] indice = IntStream.rangeClosed(0, arr.length - 1).filter(n -> arr[n] == num).toArray();
		System.out.println(indice[0] + " " + indice[indice.length - 1]);

		// alternate way
		int[] indices = IntStream.iterate(0, i -> i + 1).limit(arr.length).filter(i -> arr[i] == num).toArray();
		if (indices.length > 0) {
			System.out.println("Start index: " + indices[0] + ", End index: " + indices[indices.length - 1]);
		}
		// alternate way
//		int[] arr = {1, 2, 3, 4, 5, 3, 6, 7, 8};
//		int num = 3;
//		IntStream.range(0, arr.length).filter(i -> arr[i] == num).findFirst().ifPresent(startIndex -> {
//			int endIndex = IntStream.range(startIndex, arr.length).filter(i -> i > startIndex && arr[i] != num)
//					.findFirst().orElse(arr.length);
//			System.out.println("Start index: " + startIndex + ", End index: " + (endIndex - 1));
//		});
	
		
		
	}

	public static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
