package com.shailu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		int sum = list.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println("bogger is here " + sum);

		double avg = list.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
		System.out.println("bogger 2 " + avg);

		int max = list.stream().mapToInt(Integer::intValue).max().orElseThrow(null);
		System.out.println("bogger 2 " + max);

		List<Integer> listPrime = list.stream().filter(LambdaExp1::isPrime).collect(Collectors.toList());
		System.out.println("list of prime " + listPrime);

		List<Integer> li = list.stream().distinct().collect(Collectors.toList());
		System.out.println("distinct " + li);

		Optional<Integer> secondhighestNumber = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1)
				.findFirst();
		System.out.println("second highest " + secondhighestNumber);

		Predicate<Integer> p3 = n -> n % 2 != 0 && n > 5;
		int sumOddGT5 = li.stream().filter(p3).mapToInt(Integer::intValue).sum();
		System.out.println(sumOddGT5);
		
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
