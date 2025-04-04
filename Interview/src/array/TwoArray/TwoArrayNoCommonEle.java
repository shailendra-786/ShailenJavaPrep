package array.TwoArray;

public class TwoArrayNoCommonEle {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 5, 6, 7, 8 };

		int len1 = arr1.length;
		int len2 = arr2.length;
		int i = 0;
		int j = 0;
		while (i < len1 && j < len2) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				System.out.println("false");
				return;
			}
		}
	}

}
