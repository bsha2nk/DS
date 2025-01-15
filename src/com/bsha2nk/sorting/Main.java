package com.bsha2nk.sorting;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		int[] arr = {4, 1, 3, 8, 7, 2, 6, 5, 10, 9};

//		arr = new int[500_000_00];
//		Random random = new Random();
//		for(int i = 0; i < 500_000_00; i++) {
//			arr[i] = random.nextInt(10_000_00);
//		}
		
//		long t1 = System.currentTimeMillis();
		
//		BubbleSinkingSort.sort(arr);
		
//		SelectionSort.sort(arr);
		
		InsertionSort.sort(arr);
		
//		BucketSort.sort(arr, 10);
		
//		MergeSort.sort(arr);
		
//		QuickSort.sort(arr);
		
//		long t2 = System.currentTimeMillis();
//		System.out.println((t2-t1)/1000);
		
		print(arr);
	}
	
	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
