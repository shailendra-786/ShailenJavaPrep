package com.streamapi.streamApi2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicsOfStream {

	public static void main(String[] args) {
		String str = "String is here which we can split using regex in stream api and we see";
		int[] arr = { 1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10 };
		String[] arrName = { "LordGrimm", "Raj", "Naveen", "Bhushan", "Apoorva" };

//		Stream<String> stream = Stream.of("Apple", "Banana", "Cherry");
		Stream<String> streamStr = Stream.of(arrName);
		streamStr.map(String::toUpperCase).forEach(System.out::println);
		;

//		IntStream intStream1 = IntStream.of(1, 2, 3, 45, 6, 7);
		IntStream intStream = IntStream.of(arr);
		IntPredicate findOdd = n -> n % 2 != 0;
		intStream.filter(findOdd).forEach(System.out::println);

		Stream<String> wordStream = Pattern.compile("\\s").splitAsStream(str);
		Map<String, Integer> map = new HashMap<>();
		wordStream.forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
		map.forEach((k, v) -> {
			System.out.println(k + " " + v);
		});
	}

}
