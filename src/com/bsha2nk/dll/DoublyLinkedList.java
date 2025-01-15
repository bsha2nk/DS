package com.bsha2nk.dll;

public class DoublyLinkedList {

	private DoubleNode head;
	private DoubleNode tail;
	private int size;

	public void createDLL(int value) {
		DoubleNode node = new DoubleNode();
		node.value = value;
		head = tail = node;

		size++;
	}

	public void insert(int location, int value) {
		if(!exists()) {
			return;
		}

		DoubleNode node = new DoubleNode();
		node.value = value;

		if(location == 0) {
			node.next = head;
			head.prev = node;
			head = node;
		} else if(location >= size) {
			node.prev = tail;
			tail.next = node;
			tail = node;
		} else {
			DoubleNode temp = head;
			for(int i=0; i<location-1; i++) {
				temp = temp.next;
			}

			node.next = temp.next;
			temp.next = node;
			node.prev = temp;
			node.next.prev = node;
		}
		size++;
	}

	public void delete(int loc) {
		if(!exists())
			return;

		if(size == 1) {
			head = tail = null;
		} else if(loc == 0) {
			head = head.next;
			head.prev = null;
		} else if(loc >= size-1) {
			tail = tail.prev;
			tail.next = null;
		}  else {
			DoubleNode temp = head;
			for(int i=0; i<loc-1; i++) {
				temp = temp.next;
			}

			temp.next = temp.next.next;
			temp.next.prev = temp;
		}
		size--;
	}

	private boolean exists() {
		return head != null;
	}
	
	@Override
	public String toString() {
		DoubleNode node = head;

		while (node != null) {
			System.out.print(node.value);
			node = node.next;
			if (node != null) {
				System.out.print(" -> ");
			}
		}

		System.out.println();
		return "";
	}

}
