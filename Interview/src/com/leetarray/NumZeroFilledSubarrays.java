package com.leetarray;

import java.util.Arrays;

public class NumZeroFilledSubarrays {

	public static void main(String[] args) {
		int[] arr  = {0,0,0,2,0,0};
		System.out.println(countZeroSubarrays(arr));
		
		long sumofSingleZero = Arrays.stream(arr).filter(n->n==0).count();
		System.out.println(sumofSingleZero);
		

	}
	
	public static int countZeroSubarrays(int[] nums) {
		int cnt = 0, zeroSubarraysEndingAtCurrentIndex = 0;
        for (int n : nums) {
            if (n == 0) {
                cnt += ++zeroSubarraysEndingAtCurrentIndex;
            }else {
                zeroSubarraysEndingAtCurrentIndex = 0;
            }
        }
        return cnt;
	}

}
