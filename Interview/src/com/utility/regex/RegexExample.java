package com.utility.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
	public static void main(String[] args) {
		String input = "h3ll0 wrld th1Is   is a t3st";

		String pattern = RegexExpression.VOWELS_AND_SPACE; // Matches sequences of digits, whitespace, or vowels
		System.err.println(input.replaceAll(pattern, ""));
		System.err.println(input.replaceAll(RegexExpression.SPACE_AND_DIGIT, ""));
		System.err.println(input.replaceAll(RegexExpression.NEGATE_SPACE_AND_DIGIT, ""));
		System.out.println(input.replaceAll(RegexExpression.REMOVE_CHAR_ONLY, ""));
		Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(input);

		while (matcher.find()) {
			System.out.println("Match: " + matcher.group());
		}
	}
}
