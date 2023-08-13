package com.leetarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) {

		// with stream api
		int[] arr = { 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 4, 5, 0 };
		removeAll(arr);
		int[] arr1 = Arrays.stream(arr).distinct().toArray();
//		Arrays.stream(removeDuplicate(arr)).forEach(System.out::println);
//		Arrays.stream(removeDuplicates(arr)).forEach(System.out::println);

	}

	public static void removeAll(int... arr) {
		 int n = arr.length;
		    int[] newArr = new int[n];
		    int index = 0;
		    boolean isDuplicate = false;
		    
		    for (int i = 0; i < n; i++) {
		        isDuplicate = false;
		        for (int j = 0; j < index; j++) {
		            if (arr[i] == newArr[j]) {
		                isDuplicate = true;
		                break;
		            }
		        }
		        if (!isDuplicate) {
		            newArr[index++] = arr[i];
		        }
		    }
		    
		    int[] result = new int[index];
		    System.arraycopy(newArr, 0, result, 0, index);
		    Arrays.stream(result).forEach(System.out::println);
	}

	public static void removeDuplicatess(int... arr) {

		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[j]) {
				j++;
				arr[j] = arr[i];
			}
		}
		int[] result = new int[j + 1];
		for (int i = 0; i <= j; i++) {
			result[i] = arr[i];
		}
		Arrays.stream(Arrays.copyOf(arr, j + 1)).forEach(System.out::println);
		Arrays.stream(result).forEach(System.out::println);
	}

	public static void getFirstandLastIndex(int target, int... arr) {
		int len = arr.length;
		int indice[] = new int[len];
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (target == arr[i]) {
				indice[count] = i;
				count++;
			}
		}
		System.out.println(indice[0] + " " + indice[count - 1]);
	}

	public static int[] removeDuplicates(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		int j = 0;
		Arrays.sort(arr);

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				temp[j++] = arr[i];
			}
		}
		temp[j++] = arr[n - 1];

		int[] result = new int[j];
		for (int i = 0; i < j; i++) {
			result[i] = temp[i];
		}
		return result;
	}

	public static int[] removeDuplicate(int... arr) {
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] == arr[j]) {
					for (int k = j; k < len - 1; k++) {
						arr[k] = arr[k + 1];
					}
					len--;
					j--;
				}
			}

		}
		int[] arr1 = new int[len];
		for (int i = 0; i < len; i++) {
			arr1[i] = arr[i];
		}
		System.out.println("cat " + len);
		return arr1;
	}

}
