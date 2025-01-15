package com.bsha2nk.dll;

public class DoubleLinkedListMain {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.createDLL(5);
		
		list.insert(0, 10);
		
		list.insert(2, 20);
		
		list.insert(3, 30);
		
		list.insert(4, 40);

		list.toString();
		
		list.delete(2);
			
		list.toString();
		
		list.delete(3);
		
		list.toString();
	}

}
