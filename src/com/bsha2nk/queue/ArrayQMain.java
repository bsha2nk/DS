package com.bsha2nk.queue;

public class ArrayQMain {

	public static void main(String[] args) {
		ArrayQ q = new ArrayQ(10);
		q.enQueue(0);
		q.enQueue(10);

		q.deQueue();
		q.deQueue();
		q.peek();
		q.peek();
	}
}
