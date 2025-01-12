package com.shailu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JewelsAndStones {
	public static void main(String[] args) {
		String jewels = "aA", stones = "aAAbbbbaaa";
		int count = 0;
		for (int i = 0; i < jewels.length(); i++) {
			for (int j = 0; j < stones.length(); j++) {
				if (jewels.charAt(i) == stones.charAt(j)) {
					count++;
				}
			}
		}
		System.out.println(" stone and jewels " + count);
		String pattern = "[" + jewels + "]";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(stones);
		count = 0;
		while (m.find()) {
			count++;
		}
		System.out.println(" stone and jewels " + count);

	}
}
