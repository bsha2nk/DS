package com.heap;

import java.util.Arrays;

public class MaxIntHeap {
	
	int capacity;
	int size;
	int[] items;
	
	public MaxIntHeap() {
		capacity = 10;
		size = 0;
		items = new int[capacity];
	}
	
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		
		return items[0];
	}
	
	public int poll() {
		if (size == 0) throw new IllegalStateException();
		
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		
		return item;
	}
	
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int biggerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && leftChild(index) < rightChild(index)) {
				biggerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] > items[biggerChildIndex]) {
				break;
			} else {
				swap(index, biggerChildIndex);
				index = biggerChildIndex;
			}
		}
	}
	
	public void insert(int val) {
		ensureCapacity();
		
		items[size] = val;
		size++;
		heapifyUp();
	}
	
	public void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && parent(index) < items[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	private int getLeftChildIndex(int parentIndex) { return parentIndex * 2 + 1; } 
	private int getRightChildIndex(int parentIndex) { return parentIndex * 2 + 2; }
	private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }
	
	private boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size; }
	private boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
	private boolean hasParent(int childIndex) { return getParentIndex(childIndex) < size; }
	
	private int leftChild(int parentIndex) { return items[getLeftChildIndex(parentIndex)]; }
	private int rightChild(int parentIndex) { return items[getRightChildIndex(parentIndex)]; }
	private int parent(int childIndex) { return items[getParentIndex(childIndex)]; }
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexTwo];
		items[indexTwo] = items[indexOne];
		items[indexOne] = temp;
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	public void print() {
		for(int i=0; i<size; i++) {
			System.out.print(items[i] + " ");
		}
		
		System.out.println();
	}
}
