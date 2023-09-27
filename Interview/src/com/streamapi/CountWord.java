package com.streamapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWord {
	public static void main(String[] args) {
		String str = "well hello hello how are you i said how are you hello hello";
		Map<String, Integer> map = new HashMap<>();
		String[] strArray = str.split(" ");

//		Arrays.stream(strArray).map(st->map.put(st, map.getOrDefault(st, 0)+1)); // this will not work because map didnt get terminal operation here so we used foreach terminal operation
//		System.out.println(map.toString());
		Arrays.stream(strArray).forEach(st -> map.put(st, map.getOrDefault(st, 0) + 1)); // better solution
		map.forEach((key, value) -> System.out.println(key + " " + value));

//----------------------------------------------------------------------------------------------------------------------------------------------------------------

		Map<String, Integer> map1 = Arrays.stream(strArray).collect(HashMap::new,
				(k, v) -> k.put(v, k.getOrDefault(v, 0) + 1), HashMap::putAll);

		System.out.println(map1.toString());

//----------------------------------------------------------------------------------------------------------------------------------------------------------------

		// print only repeated word
		System.out.println("only repeated word");

		Map<String, Integer> filterMap = map.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		filterMap.forEach((key, value) -> System.out.println(key + " " + value));

		int i = map.values().stream().max(Integer::compareTo).orElse(0);
		System.out.println(i);

//----------------------------------------------------------------------------------------------------------------------------------------------------------------

		List<String> words = List.of("apple", "banana", "cherry");

		// Collect the elements into a LinkedHashMap
		Map<String, Integer> wordLengthsMap = words.stream().collect(Collectors.toMap(word -> word, // Key mapper
				word -> word.length(), // Value mapper
				(existing, replacement) -> existing, // Merge function (in case of duplicate keys)
				LinkedHashMap::new // Supplier for the resulting map (LinkedHashMap)
		));

		System.out.println(wordLengthsMap);

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

		Stream<String> words1 = Stream.of("apple", "banana", "cherry", "blueberry", "apricot");

		Map<Integer, List<String>> lengthToWordsMap = words1
				.collect(Collectors.groupingBy(String::length, LinkedHashMap::new, // Use a LinkedHashMap as the map
																					// supplier
						Collectors.toList()));

		System.out.println(lengthToWordsMap);

//------------------------------------------------------------------------------------------------------------------------------------------------------------------
		Stream<Integer> integerStream = Stream.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);

		// Use collect to accumulate elements into a LinkedHashMap with merging
		Map<Integer, Integer> resultMap = integerStream.collect(LinkedHashMap::new, // Supplier for the map type
																					// (LinkedHashMap)
				(m, value) -> m.put(value, m.getOrDefault(value, 0) + 1), // Accumulator for counting occurrences
				LinkedHashMap::putAll // Combiner for merging maps (in case of parallel streams)
		);

		// Print the resulting LinkedHashMap
		System.out.println(resultMap);
	}

}
