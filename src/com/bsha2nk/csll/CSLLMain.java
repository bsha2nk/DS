package com.bsha2nk.csll;

public class CSLLMain {

	public static void main(String[] args) {
		CircularSingleLinkedList list = new CircularSingleLinkedList();
		list.createCSLL(1);
		list.insert(2, 3);
		list.toString();
		list.delete(0);
		list.delete(0);
		list.toString();
		
	}
}
