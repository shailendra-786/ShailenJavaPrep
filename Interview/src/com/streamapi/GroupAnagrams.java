package com.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] str1 = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.println("normal way groupAnagrams" + groupAnagrams(str1));
		System.out.println("normal way groupAnagrams stream api " + groupAnagramsStreamAPi(str1));

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> groupAnagramsStreamAPi(String[] strs) {
		Map<Object, List<String>> anagramGroups = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}));
		List<List<String>> result = new ArrayList<>(anagramGroups.values());
		return result;
	}
}
