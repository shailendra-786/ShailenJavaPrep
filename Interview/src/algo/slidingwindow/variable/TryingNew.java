package algo.slidingwindow.variable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TryingNew {

	public static void main(String[] args) {
		String str = "cuaieuouac";
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		System.out.println(getVowelsCount(str, vowels)); // Output: count of vowel substrings with all vowels
		System.out.println(countVowelSubstrings(str)); // Output: count of vowel substrings with all vowels
	}

	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	public static int countVowelSubstrings(String s) {
		int ans = 0;
		int n = s.length();

		for (int i = 0; i < n; ++i) {
			Map<Character, Integer> cnt = new HashMap<>();
			for (int j = i; j < n && isVowel(s.charAt(j)); ++j) {
				cnt.put(s.charAt(j), cnt.getOrDefault(s.charAt(j), 0) + 1);
				if (cnt.size() == 5)
					++ans;
			}
		}
		return ans;
	}

	public static int getVowelsCount(String str, Set<Character> vowels) {
		int vowelsCount = 0;
		int left = 0;
		Set<Character> list = new HashSet<>();
		for (int right = 0; right < str.length();) {
			if (vowels.contains(str.charAt(right))) {
				list.add(str.charAt(right));
			} else {
				list.clear();
				++left;
				right = left;
				continue;
			}

			if (list.size() == 5) {
				int a = checkVowels(list, vowels) ? vowelsCount++ : 0;
//				System.out.println(str.substring(left, right + 1));
			}
			right++;
		}
		return vowelsCount;
	}

	public static boolean checkVowels(Set<Character> listOfVowels, Set<Character> vowels) {
		int count = 0;
		for (Character listOfVowel : listOfVowels) {
			if (vowels.contains(listOfVowel)) {
				count++;
			}
		}
		return count == listOfVowels.size();
	}

}
