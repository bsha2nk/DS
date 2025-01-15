package com.bsha2nk.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {6, 4, 2, 8, 1, 3};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {

		for(int i=0; i<arr.length; i++) {
			var j = i;

			while(j > 0 && arr[j] < arr[j-1]) {
				var temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;

				j--;
			}
		}
	}

}