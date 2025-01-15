package com.bsha2nk.queue.circular;

public class ArrayQCircular {

	private int beg, end;
	private int[] arr;

	public ArrayQCircular(int size) {
		arr = new int[size];
		beg = end = -1;
	}

	public void enqueue(int val) {
		if (isFull()) {
			System.out.println("Queue is full!");
			return;
		} else if (end + 1 == arr.length) {
			end = 0;
		} else if (isEmpty()) {
			beg = end = 0;
		} else {
			end++;
		}

		arr[end] = val;
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			System.out.println(arr[beg]);
		}

		if (beg == end) {
			beg = end = -1;
		} else if (beg + 1 == arr.length) {
			beg = 0;
		} else {
			beg++;
		}
	}

	public void peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			System.out.println(arr[beg]);
		}
	}

	private boolean isEmpty() {
		return end == -1;
	}

	private boolean isFull() {
		if (beg == 0 && end == arr.length - 1) {
			return true;
		} else if (end + 1 == beg) {
			return true;
		} else {
			return false;
		}
	}

	public void delete() {
		arr = null;
	}

}
