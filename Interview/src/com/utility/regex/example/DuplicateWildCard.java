package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWildCard {
	public static void main(String[] args) {

		// finding repeated word from string
		String input = "apple apple apple banana acple";
		String regex = "(\\w+)\\s\\1";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			System.out.println("Repeated: " + matcher.group(1));
		}
		
		// wildcard '.' used to capture all any character
		String regex2 = "a.p..";
		Pattern p = Pattern.compile(regex2);
		Matcher m = p.matcher(input);
		
		while(m.find()) {
			System.out.println(m.group());
		}
	}
}
