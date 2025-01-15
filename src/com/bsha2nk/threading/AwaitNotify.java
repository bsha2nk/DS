package com.bsha2nk.threading;

import java.util.Scanner;

public class AwaitNotify {

	public void produce() throws InterruptedException {
		synchronized(this) {
			System.out.println("producing..");
			wait();
			System.out.println("resumed");
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		
		synchronized (this) {
			Scanner s = new Scanner(System.in);
			System.out.println("press enter");
			s.nextLine();
			System.out.println("pressed");
			this.notifyAll();
		}
	}
	
	public static void main(String[] args) {
		AwaitNotify a = new AwaitNotify();
		
		new Thread(() -> {
				try {
					a.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}).start();
		
		new Thread(() -> {
			try {
				a.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
