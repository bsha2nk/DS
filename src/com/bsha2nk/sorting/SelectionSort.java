package com.bsha2nk.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = {6, 4, 2, 8, 1, 3};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		
		int size = arr.length;
		for(int i=0; i<size-1; i++) {
			
			int minPos = i;
			for(int j=i+1; j<size; j++) {
				if(arr[minPos] > arr[j]) {
					minPos = j;
				}
			}
			
			if(minPos != i) {
				int temp = arr[i];
				arr[i] = arr[minPos];
				arr[minPos] = temp;
			}
		}
	}
}
