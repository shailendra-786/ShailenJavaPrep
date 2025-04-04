package array.TwoArray;

import java.util.Arrays;

public class UnionOfTwoArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 5, 7 };
		int[] arr2 = { 2, 4, 6 };
		int len1 = arr1.length;
		int len2 = arr2.length;
		int i = 0, j = 0, k = 0;
		int res[] = new int[len1 + len2];
		while (i < len1 && j < len2) {
			if (arr1[i] < arr2[j]) {
				res[k++] = arr1[i++];
			} else if (arr1[i] > arr2[j]) {
				res[k++] = arr2[j++];
			} else {
				j++;
				i++;
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOf(res, k)));
	}

}
