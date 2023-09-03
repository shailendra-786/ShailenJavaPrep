package com.ThreadByKandD;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableEg implements Callable<List<Integer>>{

	@Override
	public List<Integer> call() throws Exception {
		List<Integer> li = new ArrayList<>();
		for(int i=0;i<5;i++) {
			li.add((int) Math.pow(i,2));
			
		}
		return li;
	}}

class PartOfJob implements Runnable {
	String name;

	public PartOfJob(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Get name of people name " + this.name);
	}

}

public class ThreadPoolEg {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		PartOfJob[] job = { new PartOfJob("sushil"), new PartOfJob("shailendra"), new PartOfJob("rajendra"),
				new PartOfJob("ravindra") };

		ExecutorService service = Executors.newFixedThreadPool(3);

		for (PartOfJob j : job) {
			System.out.println(j);
			service.submit(j);
		}
		Future<List<Integer>> future = service.submit(new CallableEg());
		System.out.println(future.get());

		service.shutdown();
		
	}
}
