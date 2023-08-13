package com.shailu;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface functionImpl {
	List<Integer> getData(int i, int j);
}

public class ZigZagString {

	public static void main1(String[] args) {
		List<Integer> li = new ArrayList<>();
		functionImpl arrowFun = (a, b) -> {
			li.add(a + b);
			return li;
		};
		System.out.println(arrowFun.getData(4, 5));
	}
	
	public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int numRows = 3; // number of rows in the zigzag pattern

        String result = convert(input, numRows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            System.out.println(currentRow+ " "+numRows);

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
        	System.out.println(row);
//            result.append(row);
        }

        return result.toString();
    }

}
