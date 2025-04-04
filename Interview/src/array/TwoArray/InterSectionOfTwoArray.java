package array.TwoArray;

import java.util.Arrays;

public class InterSectionOfTwoArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 3, 4 };
		int[] arr2 = { 2, 3, 5, 6 };
		int len1 = arr1.length;
		int len2 = arr2.length;
		int i = 0, j = 0, k = 0;
		int[] result = new int[Math.min(len1, len2)];
		while (i < len1 && j < len2) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				if (k == 0 || result[k - 1] != arr1[i]) {
					result[k++] = arr1[i];
				}
				i++;
				j++;
			}

		}
		System.out.println(Arrays.toString(Arrays.copyOf(result, k)));
	}

}
