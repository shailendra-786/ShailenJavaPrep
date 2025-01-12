package com.shailu;

//import java.util.ArrayList;
//import java.util.List;
//
//public class CandleProblem {
//
//	public static void main(String[] args) {
//
//		int totalCandle = 100;
//		int len = totalCandle;
//		int burnCandle = 2;
//		List<Integer> li = new ArrayList<>();
//		int remainig = totalCandle%burnCandle;
//		li.add(totalCandle);
//
//		for (int i = burnCandle; i < len; i = i + burnCandle) {
//			if (totalCandle % burnCandle == 0) {
//				totalCandle /= burnCandle;
//				li.add(totalCandle);
//			}else if(remainig!=0) {
//				totalCandle/=burnCandle;
//				li.add(totalCandle);
//				if(remainig!=0) {
//					int j = li.get(li.size()-1);
//					if((remainig+j)%burnCandle==0) {
//						remainig=(remainig+j)/burnCandle;
//						li.add(remainig);
//					}
//				}
//				
//			}
//
//		}
//		int sum = li.stream().mapToInt(Integer::intValue).sum();
//		System.out.println(sum);
//	}
//
//}
import java.util.ArrayList;
import java.util.List;

public class CandleProblem {

    public static void main(String[] args) {
        int totalCandle = 10;
        int burnCandle = 3;

        List<Integer> li = new ArrayList<>();
        li.add(totalCandle);

        while (totalCandle >= burnCandle) {
            int newCandles = totalCandle / burnCandle;
            int remainder = totalCandle % burnCandle;
            li.add(newCandles);
            totalCandle = newCandles + remainder;
        }

        int sum = li.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
