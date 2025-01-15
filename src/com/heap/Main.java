package com.heap;

public class Main {
	
	public static void main(String[] args) {
		MaxIntHeap heap = new MaxIntHeap();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.print();
		
//		heap.poll();
//		heap.poll();
//		heap.print();
	}
}
