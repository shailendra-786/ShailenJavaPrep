package com.streamapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWord {
	public static void main(String[] args) {
		String str = "well hello hello how are you i said how are you hello hello";
		Map<String, Integer> map = new HashMap<>();
		String[] strArray = str.split(" ");

//		Arrays.stream(strArray).map(st->map.put(st, map.getOrDefault(st, 0)+1)); // this will not work because map didnt get terminal operation here so we used foreach terminal operation
//		System.out.println(map.toString());
		Arrays.stream(strArray).forEach(st -> map.put(st, map.getOrDefault(st, 0) + 1)); // better solution
		map.forEach((key, value) -> System.out.println(key + " " + value));

		Map<String, Integer> map1 = Arrays.stream(strArray).collect(HashMap::new,
				(m, st) -> m.put(st, m.getOrDefault(st, 0) + 1), HashMap::putAll);

		System.out.println(map1.toString());

		// print only repeated word
		System.out.println("only repeated word");

		Map<String, Integer> filterMap = map.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		filterMap.forEach((key,value)->System.out.println(key+" "+value));

		int i = map.values().stream().max(Integer::compareTo).orElse(0);
		System.out.println(i);
		
	}

}
