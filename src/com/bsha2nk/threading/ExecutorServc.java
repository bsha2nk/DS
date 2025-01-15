package com.bsha2nk.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServc {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<5; i++) {
			executor.submit(new Task(i));
		}
		
		executor.shutdown();
		
		System.out.println("Tasks Submitted\n");
		
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("\nCompleted all tasks");
	}
}

class Task implements Runnable {
	
	int id;
	
	public Task(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting id " + id + " with thread " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed id " + id + " with thread " + Thread.currentThread().getName());
	}
	
}