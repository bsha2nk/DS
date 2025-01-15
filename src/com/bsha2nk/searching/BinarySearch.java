package com.bsha2nk.searching;

public class BinarySearch {
	
	public static boolean search(int[] arr, int key, int low, int high) {
		
		if(low > high)
			return false;
		
		int mid = (low+high)/2;
		
		if(key == arr[mid])
			return true;
		
		if(key < arr[mid])
			return search(arr, key, low, mid-1);
		
		return search(arr, key, mid+1, high);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println(search(arr, 0, 0, arr.length));
	}
}
