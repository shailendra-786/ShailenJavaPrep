package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AjayBhaiQuestion {
	public static void main(String[] args) {
		
		// using regex approach
		String st = new String("123a2f4d4dd");
		String stArray[] = st.split("[a-z]"); // using regex
		System.out.println(Arrays.toString(stArray));
		int sum = 0;
		for (int i = 0; i < stArray.length; i++) {
			sum += Integer.parseInt(stArray[i]);
		}
		System.out.println(sum);
		
		// using loop approach
		char[] ch = st.toCharArray();
		List<Integer> li = new ArrayList<>();
		for (int i=0;i<ch.length;i++) {
			StringBuilder sb = new StringBuilder();
			while(Character.isDigit(ch[i])) {
				sb.append(ch[i]);
				i++;
			}
			if(!sb.isEmpty()) {
				li.add(Integer.parseInt(sb.toString()));
			}
		}
		
		int sum1 = li.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum1);
	}
}
