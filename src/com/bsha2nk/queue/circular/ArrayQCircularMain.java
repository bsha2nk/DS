package com.bsha2nk.queue.circular;

public class ArrayQCircularMain {

	public static void main(String[] args) {

		ArrayQCircular queue = new ArrayQCircular(5);

		System.out.println("\nEnqueuing 5 values in the queue...");
		for (int i = 1; i <= 5; i++) {
			queue.enqueue(i * 10);
		}
		queue.enqueue(60);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(60);
		queue.dequeue();

	}

}
