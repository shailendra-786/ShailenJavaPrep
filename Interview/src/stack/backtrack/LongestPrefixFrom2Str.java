package stack.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPrefixFrom2Str {
	public static void main(String[] args) {
		String str1 = "coderpractice", str2 = "practicegeeks";
		getPrefixIndex(str1, str2);
	}

	public static List<Integer> getPrefixIndex(String str1, String str2) {
		int[] arr = new int[2];
		int count;
		List<Integer> li = new ArrayList<>();
		System.out.println(str2.indexOf('z'));
		for (int i = 0; i < str1.length(); i++) {
			if (str2.indexOf(str1.charAt(i)) == -1)
				continue;
			count =0;
			int j = str1.charAt(i);
			arr[0] = i;
			for (int k = j; k < str2.length(); k++) {
				System.out.println(str1.charAt(i));
				if (str1.charAt(i) == str2.charAt(k)) {
					System.out.println(str1.charAt(i));
				}
				count++;
			}

			arr[1] = i;
		}
		System.err.println(Arrays.toString(arr));
		System.out.println(li.toString());
		return li;
	}

}
