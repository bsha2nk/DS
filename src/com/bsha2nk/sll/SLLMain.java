package com.bsha2nk.sll;

public class SLLMain {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.createSLL(1);
		list.add(2, 1);
		list.add(3, 2);
		list.add(4, 3);
		list.add(5, 4);
		list.add(6, 5);
		list.add(7, 6);
		System.out.println(list);
		
//		list.findMiddleInSinglePass();
		
//		list.reverse();
		
//		list.nthNodeFromLast(7);
		list.getLastNode(6);
//		System.out.println(list);
	
	}
	
	
}
