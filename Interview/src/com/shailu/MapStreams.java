package com.shailu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreams {
	public static void main1(String ...a) {
		
		Map<Integer, Employee> map = new HashMap<>();
		map.put(1, new Employee(1, "shailu", "Comedian"));
		map.put(2, new Employee(2, "raj", "Java"));
		map.put(3, new Employee(3, "satyam", "Python"));
		map.put(4, new Employee(4, "naveen", "Python"));
		
		for(Map.Entry<Integer, Employee> data: map.entrySet()) {
			System.out.println("data is here "+data.getValue().getEmpName());
		}
	}
	
	 public static void main2(String[] args) {
	        List<String> strings = new ArrayList<>();
	        strings.add("APPLE");
	        strings.add("Banana");
	        strings.add("grape");
	        strings.add("Orange");

	        List<String> mixedCaseStrings = getMixedCaseStrings(strings);
	        System.out.println("Mixed case strings: " + mixedCaseStrings);
	    }

	    public static List<String> getMixedCaseStrings(List<String> strings) {
	        return strings.stream()
	                .filter(s -> s.matches(".*[a-z].*") && s.matches(".*[A-Z].*"))
	                .sorted()
	                .collect(Collectors.toList());
	    }
	    
	    public static void main(String[] args) {
	        List<String> strings = new ArrayList<>();
	        strings.add("hello");
	        strings.add("WORLD");
	        strings.add("java");
	        strings.add("STREAMS");
	        strings.add("api");
	        strings.add("EXAMPLES");

	        List<String> uppercaseStrings = getUppercase(strings);
	        System.out.println("Uppercase strings: " + uppercaseStrings);
	    }

	    public static List<String> getUppercase(List<String> strings) {
	        return strings.stream()
	                .filter(s -> s.matches(".*[A-Z].*"))
	                .sorted(Comparator.comparingInt(s -> -s.replaceAll("[^A-Z]", "").length()))
	                .collect(Collectors.toList());
	    }
	    
	    public static void main3(String[] args) {
	        // Step 1: Define the number of coin tosses
	        int numTosses = 2;

	        // Step 2: Calculate the probability of each combination of coin tosses
	        double probability = 1.0 / Math.pow(2, numTosses);

	        // Steps 3-5: Generate each possible combination of coin tosses and print its probability
	        for (int i = 0; i < Math.pow(2, numTosses); i++) {
	            String tosses = "";
	            int num = i;
	            for (int j = 0; j < numTosses; j++) {
	                if (num % 2 == 0) {
	                    tosses = "T" + tosses;
	                } else {
	                    tosses = "H" + tosses;
	                }
	                num /= 2;
	            }
	            System.out.println(tosses + " : " + probability);
	        }
	    }

}
