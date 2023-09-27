package com.utility.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizeWords {
	public static void main(String[] args) {
		String text = "this is java";

		String pattern = "(\\b)(\\w)";
//		String pattern = "\\w\\b";
		Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(text);

		StringBuffer result = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(result, matcher.group().toUpperCase());
		}
		matcher.appendTail(result);
		System.out.println(result);
	}
}
