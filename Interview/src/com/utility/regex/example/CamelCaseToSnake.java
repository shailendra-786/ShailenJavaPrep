package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCaseToSnake {
	public static void main(String... args) {
		String str = "ShailendraKumarSingh";

		getCamelToSnake(str);
		getCamelToSnakeRegex(str);
		getCamelToSnakeRegexHitEnd(str);

	}

	public static void getCamelToSnakeRegex(String str) {
		String pattern = "[A-Z][a-z]+";
//      String pattern = "[a-z]+(?=[A-Z])|[A-Z][a-z]+";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		StringBuilder sb = new StringBuilder();
		while (m.find()) {
			sb.append(m.group());
//			if(m.end()!=str.length()) {
			sb.append("_");
//			}
		}

		String trimLastUnderScore = sb.toString().replaceFirst("_\\b", "");
		System.out.println(trimLastUnderScore);
	}

	public static void getCamelToSnakeRegexHitEnd(String str) {
		String pattern = "[A-Z][a-z]+";
//      String pattern = "[a-z]+(?=[A-Z])|[A-Z][a-z]+";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		StringBuilder sb = new StringBuilder();
		while (m.find()) {
			sb.append(m.group());

			if (m.hitEnd()) {
				break;
			}

			sb.append("_");
		}

		System.out.println(sb);

	}

	public static void getCamelToSnake(String str) {
		StringBuilder sb = new StringBuilder();
		int length = str.length();
		for (int i = 0; i < length - 1; i++) {
			if (Character.isLowerCase(str.charAt(i)) && Character.isUpperCase(str.charAt(i + 1))) {
				sb.append(str.charAt(i));
				sb.append("_");
				sb.append(str.charAt(i + 1));
				i++;
				continue;
			}
			sb.append(str.charAt(i));
		}
		sb.append(str.charAt(length - 1));
		System.out.println(sb);
	}

}
