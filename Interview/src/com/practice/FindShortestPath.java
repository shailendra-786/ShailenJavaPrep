package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// find shortest path from 1 to 2
public class FindShortestPath {
	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 0, 0, 0, 2, 1, 0, 0 };
		int target =2;
		getShortestPath(arr,target);
		getShortestPath2(arr,target);

	}

	public static int getTargetIndex(int target, int[] nums) {
		return IntStream.range(0, nums.length).filter(i -> nums[i] == target).findFirst().orElse(-1);
	}

	public static void getShortestPath(int[] arr, int target) {
		int targetIndex = getTargetIndex(target, arr);
		int shortestPath = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
//				int currentPath = targetIndex > i ? targetIndex - i : i - targetIndex;
				int currentPath =  Math.abs(targetIndex - i);
				if (currentPath < shortestPath) {
					shortestPath=currentPath;
				}
			}
		}
		System.out.println("shortest path "+shortestPath);
	}
	
	// another way
	public static void getShortestPath2(int[] arr, int target) {
		int targetIndex = getTargetIndex(target, arr);
		List<Integer> allPosiblePath = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				 allPosiblePath.add(Math.abs(targetIndex - i));
			}
		}
		
		int shortestPath = allPosiblePath.stream().mapToInt(Integer::intValue).min().getAsInt();
		System.out.println("shortest path "+shortestPath);
	}
}
