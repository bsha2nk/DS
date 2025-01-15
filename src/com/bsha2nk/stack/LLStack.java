package com.bsha2nk.stack;

public class LLStack {
	
	SingleNode head;

	void push(int value) {
		SingleNode node = new SingleNode();
		node.value = value;
		node.next = head;
		head = node;
	}
	
	void pop() {
		if(head == null) {
			return;
		}
		
		SingleNode temp = head;
		head = head.next;
		
		System.out.println(temp.value);
	}
	
}
