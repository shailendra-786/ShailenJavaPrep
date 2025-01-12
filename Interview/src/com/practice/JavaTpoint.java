package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaTpoint {
	public static void main(String[] args) {
		String str = "Greatresponsibility";
		String strArray[] = str.split("");
		Map<String, Long> mapReapitingChar = Arrays.stream(strArray)
				.collect(Collectors.groupingBy(w -> w, Collectors.counting()));

		Long max = Long.MIN_VALUE;
		String maxReapTe = "";
		for (Map.Entry<String, Long> m : mapReapitingChar.entrySet()) {
			if (m.getValue() > max) {
				max = m.getValue();
				maxReapTe = m.getKey();

			}
		}
		System.out.println(maxReapTe + " " + max);

		String strMax = mapReapitingChar.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
				.get();
		String strMin = mapReapitingChar.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
				.get();

		System.out.println(mapReapitingChar.toString());
		System.out.println(strMax);
		System.out.println(strMin);

		char firstNonRepeating = str.chars().mapToObj(c -> (char) c).filter(c -> str.indexOf(c) == str.lastIndexOf(c))
				.findFirst().orElse('\0');
		System.out.println(firstNonRepeating);
	}

	public static void findMinAndMaxPalindrom() {
		String strPal = "Wow you own kayak".toLowerCase();
		String[] strPalArr = strPal.split("\\s");
		List<String> strPalList = Arrays.stream(strPalArr).filter(JavaTpoint::checkPalindrom).toList();
		String strMax = Arrays.stream(strPalArr).filter(JavaTpoint::checkPalindrom)
				.max((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse(null);
		String strMin = Arrays.stream(strPalArr).filter(JavaTpoint::checkPalindrom)
				.min((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse(null);

		System.out.println("List of palindrom " + strPalList.toString());
		System.out.println("str max " + strMax + " str min " + strMin);
	}

	public static boolean checkPalindrom(String str) {
		int len = str.length() / 2;
		int j = str.length() - 1;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) != str.charAt(j - i)) {
				return false;
			}

		}
		return true;
	}

	public static void swapStrWithoutUsingThirdVariable() {
		// swaping string with third variable
		String str1 = "Shailu", str2 = "Singh";

		str1 = str1.concat(str2);

		str2 = str1.substring(0, (str1.length() - str2.length()));

		str1 = str1.substring(str2.length());

		System.out.println("Str2 " + str2 + " str1 " + str1);
	}
}
