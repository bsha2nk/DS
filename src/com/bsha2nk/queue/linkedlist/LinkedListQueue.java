package com.bsha2nk.queue.linkedlist;

public class LinkedListQueue {

	private Node head;
	private Node tail;
	void createQueue() {

	}

	void enQueue(int value) {
		Node node = new Node();
		node.value = value;

		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	void deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empaty");
		} else {
			System.out.println(head.value);
			head = head.next;
		}
	}

	void peek() {
		if (isEmpty()) {
			System.out.println("Queue is empaty");
		} else {
			System.out.println(head.value);
		}
	}

	private boolean isEmpty() {
		return head == null;
	}
	
	class Node {
		Integer value;
		Node next;
	}
}
