package com.bsha2nk.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void sort(int[] arr) {
		
		if(arr.length < 2)
			return;
		
		int mid = arr.length/2;
		int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
		int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
		
		sort(leftArr);
		sort(rightArr);
		
		merge(arr, leftArr, rightArr);
	}

	private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
		
		int leftSize = leftArr.length;
		int rightSize = rightArr.length;
		int i = 0, j = 0, k = 0;
		
		while(i < leftSize && j < rightSize) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}
		}
		
		while(i < leftSize) {
			arr[k++] = leftArr[i++];
		}
		
		while(j < rightSize) {
			arr[k++] = rightArr[j++];
		}
	}
}
