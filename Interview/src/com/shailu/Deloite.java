package com.shailu;

public class Deloite {
	public static void main(String[] args) {
		String str = "abcd";
		String presentString = "cdab";
		if (str.length() != presentString.length() && str.contains(presentString)) {
			System.out.println("matched found");
		} else {
			System.out.println(isRotationString1(str, presentString));
		}

	}

	public static boolean isRotationString(String input, String str) {
		if (input.length() != str.length()) {
			return false;
		}
		String concate = input + input;
		return concate.contains(str);
	}

	public static boolean isRotationString1(String input, String str) {
		if (input.length() != str.length()) {
			return false;
		}
		int length = input.length();
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == str.charAt(0)) {
				int j = i;
				int k = 0;
				while (k < length && input.charAt(j) == str.charAt(k)) {
					j = (j + 1) / length;
					k++;
				}
				if (k == length) {
					return true;
				}
			}
		}
		return false;
	}

}
