package com.streamapi.streamApi2;

import java.util.Arrays;
import java.util.List;

public class StringAdvance2 {

	public static void main(String[] args) {
		//Find Common Prefix
		List<String> inputList = Arrays.asList("flower", "flow", "flight");

        String commonPrefix = inputList.stream()
            .reduce((str1, str2) -> {
                int minLength = Math.min(str1.length(), str2.length());
                int i = 0;
                while (i < minLength && str1.charAt(i) == str2.charAt(i)) {
                    i++;
                }
                return str1.substring(0, i);  // Return the common prefix
            })
            .orElse("");  // Return empty string if no common prefix
        System.out.println(commonPrefix); 

		
	}

}
