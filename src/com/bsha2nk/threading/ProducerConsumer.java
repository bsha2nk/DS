package com.bsha2nk.threading;

import java.util.LinkedList;

public class ProducerConsumer {
	
	private LinkedList<Integer> list = new LinkedList<>();
	private static final int LIMIT = 10;
	private Object lock = new Object();
	
	public void producer() throws InterruptedException {

		int value = 0;
				
		while(true) {
			synchronized (lock) {
				while(list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notifyAll();
			}
			
			Thread.sleep(100);
		}
	}
	
	public void consumer() throws InterruptedException {
		
		while(true) {
			synchronized (lock) {
				while(list.isEmpty()) {
					lock.wait();
				}
				
				
				System.out.print("List size is: " + list.size());
				var i = list.removeFirst();
				System.out.println("; Element extracted: " + i);
				lock.notify();
			}
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer producerConsumer = new ProducerConsumer();
		
		Thread t1 = new Thread(() -> {
			try {
				producerConsumer.producer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				producerConsumer.consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t2.start();
		t1.start();
	}
}
