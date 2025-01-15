package com.bsha2nk.sorting;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
//		int[] arr = {9, 5, 1, 4, 6, 8, 3, 7};
		int[] arr = {1,1,1,1,1,1,1,1};
		System.out.println("Unsorted Array: " + Arrays.toString(arr));
		
		heapSort(arr);
		System.out.println("\nSorted Array: " + Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;
		for (int i=n/2 - 1; i>=0; i--) {
			heapify(arr, i, n);
		}
		
		System.out.println("\nMax-Heapified Array: " + Arrays.toString(arr));
		
		for (int i=n-1; i>=0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			heapify(arr, 0, i);
		}
		
	}

	private static void heapify(int[] arr, int top, int size) {
		
		int largest = top;

		int l = top * 2 + 1;
		if (l < size && arr[l] > arr[largest])
			largest = l;

		int r = top * 2 + 2;
		if (r < size && arr[r] > arr[largest])
			largest = r;
		
		if (largest != top) {
			int temp = arr[largest];
			arr[largest] = arr[top];
			arr[top] = temp;
			
			heapify(arr, largest, size);
		}
	}
}
