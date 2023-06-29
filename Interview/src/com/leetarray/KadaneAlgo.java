package com.leetarray;

public class KadaneAlgo {
	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4, 7 };
		System.out.println("f  "+maxContigiousSubaarya(arr));
	}

	public static int maxContigiousSubaarya(int[] arr) {
		int maxSofar = arr[0];
		int maxEnding = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEnding = Math.max(arr[i], maxEnding + arr[i]);
			System.err.println(maxEnding);
			maxSofar = Math.max(maxSofar, maxEnding);
			System.err.println(maxSofar);
		}

		return maxSofar;
	}
}

