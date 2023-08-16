package das.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindShortestPrefix {

	public static void main(String[] args) {
		String[] strArray = { "flower", "flowf", "flyff" };
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

}
