package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PanValidationRegex {
	public static void main(String[] args) {
		String pan = "aaapz1234c";
		String pattern = "(?i)[a-z]{5}[0-9]{4}[a-z]{1}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(pan);
		if (m.find()) {
			System.out.println("valid");
		}
	}
}
