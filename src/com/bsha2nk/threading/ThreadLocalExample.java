package com.bsha2nk.threading;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public static ThreadLocal<SimpleDateFormat> formatHolder = new ThreadLocal<>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("dd-MM-yyyy");
		}

	};
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for (int i=0; i<10; i++) {
			es.submit(new NewTask(i));
		}
		
		es.shutdown();
	}
	
	static class NewTask implements Runnable {
		
		int i;
		
		public NewTask(int i) {
			this.i = i;
		}
		
		@Override
		public void run() {
//		SimpleDateFormat sdf = ThreadLocalExample.formatHolder.get();
			
			try {
				System.out.println(i + " " + sdf.parse("13-05-2023"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}

