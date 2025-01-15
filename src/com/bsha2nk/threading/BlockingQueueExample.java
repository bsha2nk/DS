package com.bsha2nk.threading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				producer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t2.start();
		t1.start();
	}
	
	public static void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			queue.put(random.nextInt(100));
		}
	}
	
	public static void consumer() throws InterruptedException {
		while(true) {
			Thread.sleep(1000);
			
			int i = queue.take();
			System.out.println("Integer taken: " + i + ", Queue size: " + queue.size());
		}
	}
}
