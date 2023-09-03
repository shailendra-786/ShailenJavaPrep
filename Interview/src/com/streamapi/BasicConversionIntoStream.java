package com.streamapi;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicConversionIntoStream {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 5 };
		IntStream intStream = IntStream.of(arr);
		int max = intStream.max().getAsInt();
		System.out.println(max);
		
		Integer arrInteger[] = {6,7,8,8,9,9};
		Stream<Integer> s1 = Arrays.stream(arrInteger);
		
		System.out.println(s1.count());
		System.out.println(s1.distinct()); // error will throw stream has already been operated upon
		
		
		Stream<Integer> streamInteger2 = Stream.of(arrInteger);
		System.out.println(streamInteger2);
	}
}
