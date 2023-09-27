package algo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceSubset {

	public static void main(String[] args) {
		int arr[] = { 112, 320, 230, 431, 233, 231, 432, 232, 412, 598, 599 };
		Arrays.sort(arr);
		List<List<Integer>> li = new ArrayList<>();
		System.out.println(getSequenceSub(arr, li));
	}

	public static List<List<Integer>> getSequenceSub(int arr[], List<List<Integer>> li) {
		for (int i = 0; i < arr.length - 1;) {
			List<Integer> l1 = new ArrayList<>();
			l1.add(arr[i]);

			while (i + 1 < arr.length && arr[i] + 1 == arr[i + 1]) {
				l1.add(arr[i + 1]);
				i++;
			}
			;
			if (l1.size() > 1) {
				li.add(l1);
				continue;
			}
			i++;
		}
		return li;
	}

	// optimize way
	public static List<List<Integer>> getSequenceSub(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			List<Integer> subset = new ArrayList<>();
			subset.add(arr[i]);
			while (i < n - 1 && arr[i] + 1 == arr[i + 1]) {
				subset.add(arr[i + 1]);
				i++;
			}
			if (subset.size() > 1) {
				result.add(subset);
			}
		}
		return result;
	}

}
