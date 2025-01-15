package com.bsha2nk.stack;

public class Stack {
	
	int[] stack;
	int topOfStack;
	
	void createStack(int size) {
		stack = new int[size];
		topOfStack = -1;
	}
	
	void push(int value) {
		if(topOfStack == stack.length - 1) {
			System.out.println("Stack is full.");
			return;
		}
		
		stack[++topOfStack] = value;
	}

	void pop() {
		if(topOfStack == -1) {
			System.out.println("Stack is full.");
			return;
		}
		
		System.out.println(stack[topOfStack]);
		
		topOfStack--;
		
	}
	
	void peek() {
		if(topOfStack == -1) {
			System.out.println("Stack is full.");
			return;
		}
		
		System.out.println(stack[topOfStack]);
		
	}
}
