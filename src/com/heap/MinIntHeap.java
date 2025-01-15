package com.heap;

import java.util.Arrays;

public class MinIntHeap {

	private int capacity = 10;
	private int size = 0;
	
	private int[] items = new int[capacity];

	public int peek() {
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}

	public void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}
	}
	
	public void add(int value) {
		ensureExtraCapacity();
		items[size] = value;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp() {
		int index = size-1;
		
		while(hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	
	private int getLeftChildIndex(int parentIndex) { return (2 * parentIndex) + 1; }
	private int getRightChildIndex(int parentIndex) { return (2 * parentIndex) + 2; }
	private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }
	
	private boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size; }
	private boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
	private boolean hasParent(int childIndex) { return getParentIndex(childIndex) >= 0; }
	
	private int leftChild(int parentIndex) { return items[getLeftChildIndex(parentIndex)]; }
	private int rightChild(int parentIndex) { return items[getRightChildIndex(parentIndex)]; }
	private int parent(int childIndex) { return items[getParentIndex(childIndex)]; }

	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureExtraCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
}
