package com.ThreadByKandD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EgArrayList {
	public static void main(String[] args) {
		getConccurentList();
		// without concurrent
		List<String> li = new ArrayList<>();

		li.add("bhushan");
		li.add("shailendra");

		Iterator<String> itr = li.iterator();
		while (itr.hasNext()) {
			String str = (String) itr.next();
			System.out.println(str);
			try {
				System.out.println("erro");
				li.add("mayank");
			} catch (Exception e) {
				System.out.println("error " + e);
			}
		}
		
		
		
		
	}
	
	public static void getConccurentList() {
		CopyOnWriteArrayList<String> li = new CopyOnWriteArrayList<>();

		li.add("bhushan");
		li.add("shailendra");

		Iterator<String> itr = li.iterator();
		while (itr.hasNext()) {
			String str = (String) itr.next();
			System.out.println(str);
			try {
				li.add("mayank");
			} catch (Exception e) {
				System.out.println("error " + e);
			}
		}
	}
}
