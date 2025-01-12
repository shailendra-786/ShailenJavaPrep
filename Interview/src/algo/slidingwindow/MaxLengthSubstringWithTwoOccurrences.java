package algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubstringWithTwoOccurrences {
	
	public static int maximumLengthSubstring(String s) {
		int n = s.length();
		int ans = 0;
		int begin = 0;
		int end = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (end < n) {
			// Add the current character to the map
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

			// While any character count is 3, shrink the window from the beginning
			while (map.get(s.charAt(end)) == 3) {
				map.put(s.charAt(begin), map.get(s.charAt(begin)) - 1);
				if (map.get(s.charAt(begin)) == 0) {
					map.remove(s.charAt(begin));
				}
				begin++;
			}

			// Update the maximum length of the substring
			ans = Math.max(ans, end - begin + 1);
			end++;
		}

		return ans;
	}


	public static void main(String[] args) {
		String s = "aabbcc";
		System.out.println("Maximum Length Substring With Two Occurrences: " + maximumLengthSubstring(s)); // Output:
																											// 6
	}
}
