package com.shailu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		String str = "bbbccd";
		System.out.println(longestSubstringWithoutRepeatingCharacters(str));
		System.out.println(LongestSub(str));
		String[] str1 ={"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(str1));
		System.out.println(getdatawithutLoop(0,3));
		
		
	}
	
	public static int getdatawithutLoop(int n,int max) {
		if(n==max) {
			return max;
		}
		System.out.println(n);
		return getdatawithutLoop(n+1,max);
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
	// abcabcdbb
		public static String longestSubstringWithoutRepeatingCharacters(String s) {
			int i = 0;
			String longest = "";
			Set<Character> seen = new HashSet<>();

			for (int j = 0; j < s.length(); j++) {
				if (!seen.contains(s.charAt(j))) {
					seen.add(s.charAt(j));
					String current = s.substring(i, j + 1);
					if (current.length() > longest.length()) {
						longest = current;
					}
				} else {
//					System.out.println(s.charAt(j) + " " + s.charAt(i));
//					System.out.println(s.charAt(i) != s.charAt(j));
					while (s.charAt(i) != s.charAt(j)) {
						seen.remove(s.charAt(i));
						i++;
					}
					i++;
				}
			}

			return longest;
		}
		
		public static String LongestSub(String str) {
			String longest = "";

			for (int i = 0; i < str.length(); i++) {
				for (int j = str.length() - 1; j > i; j--) {
					if (str.charAt(i) == str.charAt(j)) {
						String substr = str.substring(i, j + 1);
						if (com.shailu.LeetHard2.isPalindrome(substr) && substr.length() > longest.length()) {
							longest = substr;
						}
					}
				}
			}

			return longest;
		}

}
