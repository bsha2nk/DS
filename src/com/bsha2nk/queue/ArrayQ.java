package com.bsha2nk.queue;

public class ArrayQ {
	private int endOfQueue;
	private int begOfQueue;
	private int[] arr;

	public ArrayQ(int size) {
		arr = new int[size];
		endOfQueue = -1;
		begOfQueue = -1;
	}

	void enQueue(int i) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		} else if (isEmpty()) {
			begOfQueue = 0;
		}

		arr[++endOfQueue] = i;
	}

	void deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		System.out.println(arr[begOfQueue++]);
		if (begOfQueue > endOfQueue) {
			begOfQueue = endOfQueue = -1;
		}
	}

	void peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		System.out.println(arr[begOfQueue]);
	}

	boolean isEmpty() {
		return begOfQueue == -1;
	}
	
	boolean isFull() {
		return endOfQueue == arr.length - 1;
	}

	void deleteQueue() {
		arr = null;
	}

}