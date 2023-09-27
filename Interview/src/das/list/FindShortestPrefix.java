package das.list;

import java.util.Arrays;

public class FindShortestPrefix {

	public static void main(String[] args) {
		String[] strArray = { "flower", "flowf", "flyff" };

		System.out.println("here we will see " + longestCommonPrefix(strArray));

		int shortestLen = Arrays.stream(strArray).mapToInt(s -> s.length()).min().orElse(0);
		System.out.println("shortest length " + shortestLen);
		System.out.println("shortest prefix " + getShortesPrefix(strArray, shortestLen));

		String shortestPrefix = strArray[0];
		for (int j = 1; j < strArray.length; j++) {
			shortestPrefix = getShortestPrefixByWord(shortestPrefix, strArray[j]);
		}
		System.out.println(shortestPrefix);

	}

	public static String getShortesPrefix(String[] strArray, int shortestLen) {
		String result = "";
		String shortestPrefix = strArray[0];
		int len = strArray.length;
		for (int i = 0; i < shortestLen; i++) {
			char occurence = shortestPrefix.charAt(i);
			for (int j = 0; j < len; j++) {
				if (strArray[j].charAt(i) != occurence) {
					return result;
				}
			}
			result += String.valueOf(occurence);
		}
		return result;
	}

	public static String getShortestPrefixByWord(String str1, String str2) {
		String result = "";
		int min = Math.min(str1.length(), str2.length());
		for (int i = 0; i < min; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return result;
			}
			result += String.valueOf(str1.charAt(i));
		}
		return result;
	}
	//best solution
	public static String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		String s1 = strs[0];
		String s2 = strs[strs.length - 1];
		int idx = 0;
		while (idx < s1.length() && idx < s2.length()) {
			if (s1.charAt(idx) == s2.charAt(idx)) {
				idx++;
			} else {
				break;
			}
		}
		return s1.substring(0, idx);
	}
}
