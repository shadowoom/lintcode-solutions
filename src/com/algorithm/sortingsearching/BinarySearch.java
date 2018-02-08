package com.algorithm.sortingsearching;

public class BinarySearch {
	
	//iterative
	public static int binarySearch(int [] arr, int k) {
		int low = 0; 
		int high = arr.length - 1;
		while(low <= high) {
			int middle = (low + high)/2; 
			if(k < arr[middle]) {
				high = middle - 1;
			}
			else if(k > arr[middle]) {
				low = middle + 1;
			}
			else {
				return middle;
			}
		}
		return -1;
	}
	
	//recursive
	public static int binarySearch(int[] arr, int k, int low, int high) {
		if(low > high) return -1;
		int middle = (low + high)/2;
		if(arr[middle] > k) {
			return binarySearch(arr, k, low, middle - 1);
		}
		else if(arr[middle] < k) {
			return binarySearch(arr, k, middle + 1, high);
		}
		else {
			return middle;
		}
	}

}
