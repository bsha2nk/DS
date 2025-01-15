package com.bsha2nk.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	
	public static void main(String[] args) {
		int[] arr = {6, 4, 2, 8, 1, 3};
		sort(arr, 8);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort (int[] arr, int max) {

		int noOfBuckets = arr.length + 1;
		ArrayList<Integer>[] buckets = new ArrayList[noOfBuckets];

		for(int i=0; i<noOfBuckets; i++) {
			buckets[i] = new ArrayList<>();
		}

		for(int i : arr) {
			double val = Math.floor((i * arr.length)/max);
			int bucketNum = (int) val;
			buckets[bucketNum].add(i);
		}

		for(List<Integer> l : buckets) {
			Collections.sort(l);
		}

		List<Integer> sortedList = new ArrayList<>();
		for(List<Integer> l : buckets) {
			sortedList.addAll(l);
		}

		System.out.println(sortedList);
	}

	public static void sortComplicated (int[] arr, int max) {

		int noOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		ArrayList<Integer>[] buckets = new ArrayList[noOfBuckets];

		for(int i=0; i<noOfBuckets; i++) {
			buckets[i] = new ArrayList<>();
		}

		for(int i : arr) {
			double val = Math.ceil((i * (noOfBuckets-1))/max);
			int bucketNum = (int) val;
			buckets[bucketNum].add(i);
		}

		for(List<Integer> l : buckets) {
			Collections.sort(l);
		}

		List<Integer> sortedList = new ArrayList<>();
		for(List<Integer> l : buckets) {
			sortedList.addAll(l);
		}

		System.out.println(sortedList);
	}

}
