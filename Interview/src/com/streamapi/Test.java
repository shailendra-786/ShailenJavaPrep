package com.streamapi;

import java.util.Arrays;
// keep in mind always For Map we used entrySet() and then stream()
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Alice", 25);
		hashMap.put("Bob", 30);
		hashMap.put("Charlie", 20);
		hashMap.put("David", 40);
		hashMap.put("Eve", 35);
		
		System.out.println("printing data using forEach");
		hashMap.forEach((key,value)->System.out.println(key+" "+value));
		
		// now we using filter to filter some value
		System.out.println("Using filter but here we used Predicate");
		 Predicate<Map.Entry<String, Integer>> p = entry -> entry.getValue() > 25;
		Map<String,Integer>  filterMap=hashMap.entrySet().stream().filter(p).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("here is filter data "+filterMap.toString());
		
		List<Integer> li = Arrays.asList(1,2,3,4,5,6,7,78,8);
		Predicate<Integer> p1 = n->n%2==0;
		List<Integer> l1 = li.stream().filter(p1).collect(Collectors.toList());
		System.out.println(l1.toString());
	}

}
