package com.bsha2nk.sorting;

import java.util.Random;

public class QuickSort {
	
	private static Random random = new Random();
	
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}

	private static void sort(int[] arr, int lowIndex, int highIndex) {
		
		if(lowIndex >= highIndex) {
			return;
		}
		
		int pivotIndex = random.nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = arr[pivotIndex];
		swap(arr, pivotIndex, highIndex);
		
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		leftPointer = partition(arr, pivot, leftPointer, rightPointer);
		
		swap(arr, leftPointer, highIndex);
		
		sort(arr, lowIndex, leftPointer-1);
		sort(arr, leftPointer+1, highIndex);
	}

	private static int partition(int[] arr, int pivot, int leftPointer, int rightPointer) {
		
		while(leftPointer < rightPointer ) {
			while(arr[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while(arr[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(arr, leftPointer, rightPointer);
		}
		
		return leftPointer;
	}

	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
