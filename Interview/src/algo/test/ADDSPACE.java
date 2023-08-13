package algo.test;

public class ADDSPACE {

	public static void main1(String[] args) {
		String str = "shailendra   is comdian  ";
		System.out.println("length word" + str.split("\\s+").length);
		int len = str.split("\\s+").length;
		String[] str1 = str.split("\\s+");
		int count = 0;
		for (Character c : str.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				count++;
			}
		}
		System.out.println(count);
		int even = count / 2;
		System.out.println(even);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(str1[i]);
			if (i < even) {
				sb.append(" ".repeat(even));
			}
		}
		System.out.println(sb);

	}

	// 459. Repeated Substring Pattern
	public static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0 && s.substring(0, i).repeat(n / i).equals(s)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abcdefghijklmn");
		getReverseTwoPOint(sb, 3);
		getVowelReverse("");
		getRemoveOccurenceOFSubString("axxxxyyyyb","xy");
	}

//	Reverse String II
	// abcdefg
	public static StringBuilder getReverseTwoPOint(StringBuilder str, int k) {
		boolean istrue = true; // alternate condition will be check
		int len = str.length() % k; // adjusting length vip
		System.out.println(len);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length() - len; i = i + k) {
			if (istrue) {
				StringBuilder sb1 = new StringBuilder(str.substring(i, i + k));
				sb.append(sb1.reverse());
				istrue = !istrue;
			} else {
				sb.append(str.substring(i, i + k));
				istrue = !istrue;
			}

		}
		if (len > 0) {
			sb.append(str.substring(str.length() - len));
		}
		System.out.println(sb);
		return sb;
	}

	// 345. Reverse Vowels of a String
	public static String getVowelReverse(String str) {
//		String s = "hello";
		String s = "leetcode";

		System.out.println(s.matches("[AEOUIaeoui]"));
		String isVowelRegx = "[AEOUIaeoui]";
		char c[] = s.toCharArray();
		int len = c.length;
		for (int i = 0; i < len; i++) {
			if (!String.valueOf(c[i]).matches(isVowelRegx))
				continue;
			for (int j = i + 1; j < len; j++) {
				if (String.valueOf(c[j]).matches(isVowelRegx)) {
					char temp = c[j];
					c[j] = c[i];
					c[i] = temp;
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder("axxxyyy");
		sb.delete(2, 3);
		System.out.println(sb.delete(2, 3));
		System.out.println(c);
		return null;
	}

//	1910	Remove All Occurrences of a Substring
	public static String getRemoveOccurenceOFSubString(String str,String part) {
		boolean isTrue = true; // controlling loop vip
		while(isTrue) {
			if(str.contains(part)) {
			str=str.replace(part, "");
			System.out.println(str);
			}else {
				isTrue=!isTrue;
			}
		}
		System.out.println("d "+str);
		return null;
	}

}
