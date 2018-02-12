package com.algorithm.arraystring;

//assume no duplicates
public class FindMinimumInRotatedSortedArray {
	
	public int findMin(int[] nums) {
		// write your code here
	    int low = 0;
	    int high = nums.length - 1;
	    return findMin(nums, low, high);
	 }
	 
	 public static int findMin(int[] nums, int low, int high) {
		 if(low >= high)
			 return nums[low];
		 int mid = (low + high) / 2;
		 
		 if(mid == low && mid != high) {
			 return nums[low] > nums[high]? nums[high]:nums[low];
		 }
		 
		 //if no rotation
	     if(nums[mid] > nums[low] && nums[mid] < nums[high])
			 return nums[low];
		 //there is rotation
		 else{
		     if(nums[mid] < nums[mid-1])
			    return nums[mid];
			 else{
			     //right sorted
			     if(nums[mid] < nums[low])
			        return findMin(nums, low, mid -1);
		        //left sorted
		         else
			        return findMin(nums, mid+1, high);
			 }
		 }
	 }
	
}
