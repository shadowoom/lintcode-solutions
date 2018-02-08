package com.algorithm.sortingsearching;

public class KthLargestElement {

	 //method 1 use sorting algorithm 
	public static int kthLargestElement(int k, int[] nums) {
	   // write your code here
	   QuickSort.quickSort(nums, 0, nums.length - 1);
	   return nums[nums.length - k];
	}
	
	public static void main(String[] args) {
		int[] arr = {9,3,2,4,8,5};
		System.out.println(kthLargestElement(3, arr));
	}

}
