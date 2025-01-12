package algo.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> tCount = new HashMap<>();
		for (char c : t.toCharArray()) {
			tCount.put(c, tCount.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> windowCount = new HashMap<>();
		int required = tCount.size();
		int formed = 0;

		int left = 0;
		int right = 0;
		int[] ans = { -1, 0, 0 }; // Window length, left, right

		while (right < s.length()) {
			char c = s.charAt(right);
			windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

			if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
				formed++;
			}

			while (left <= right && formed == required) {
				c = s.charAt(left);

				if (ans[0] == -1 || right - left + 1 < ans[0]) {
					ans[0] = right - left + 1;
					ans[1] = left;
					ans[2] = right;
				}

				windowCount.put(c, windowCount.get(c) - 1);
				if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
					formed--;
				}

				left++;
			}

			right++;
		}

		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println("Minimum window substring: " + minWindow(s, t)); // Output: "BANC"
	}
}
