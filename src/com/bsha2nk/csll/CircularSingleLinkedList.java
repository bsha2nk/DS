package com.bsha2nk.csll;

import com.bsha2nk.sll.SingleNode;

public class CircularSingleLinkedList {

	SingleNode head;
	SingleNode tail;
	int size;

	public void createCSLL(int val) {
		head = tail = new SingleNode();
		head.setValue(val);
		head.setNext(head);

		size++;
	}

	public void insert(int value, int location) {
		if(!exists())
			return;

		SingleNode newNode = new SingleNode();
		newNode.setValue(value);

		if(location == 0) {
			newNode.setNext(head);
			head = newNode;
			tail.setNext(head);
		} else if(location >= size) {
			newNode.setNext(head);
			tail.setNext(newNode);
			tail = newNode;
		} else {
			SingleNode tempNode = head;
			for(int i=0; i<location-1; i++) {
				tempNode = tempNode.getNext();
			}
			
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
		
		size++;
	}
	
	public void delete(int location) {
		if(!exists())
			return;
		
		SingleNode node = head;
		if(location == 0) {
			head = head.getNext();
			tail.setNext(head);
			
			size--;
			
			if(size == 0) {
				tail = null;
			}
			
			System.out.println(tail);
			System.out.println(head);
			System.out.println(head.getNext());
			System.out.println(head.getValue());
		} else if (location >= size-1) {
			for (int i=0; i<size-1; i++) {
				node = node.getNext();
			}
			
			node.setNext(head);
			tail = node;
			
			size--;
			
			if(size == 0) {
				head = tail = null;
			}
		} else {
			for (int i=0; i<location-1; i++) {
				node = node.getNext();
			}
			
			node.setNext(node.getNext().getNext());
			size--;
		}
	}
	
	public boolean search(int value) {
		SingleNode node = head;
		
		for(int i=0; i<size; i++) {
			if(value == node.getValue()) {
				System.out.format("Value found at %s", (i+1));
				return true;
			}
			
			node = node.getNext();
		}
		
		System.out.println("Not found");
		return false;
	}

	public boolean exists() {
		return head != null;
	}
	
	@Override
	public String toString() {
		SingleNode node = head;

		for(int i=0; i<size; i++) {
			System.out.print(node.getValue());
			if (i != size - 1) {
				System.out.print(" -> ");
			}
			node = node.getNext();
		}
		
		System.out.println();

		return "";
	}

}