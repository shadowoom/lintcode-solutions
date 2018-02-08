package com.algorithm.arraystring;

public class FirstPositionOfTarget {
	
	public static int binarySearch(int[] nums, int target) {
        //write your code here
        int low = 0;
        int high = nums.length - 1;
        int middle;
        int pos = -1;
        while(low <= high){
            middle = (low + high) / 2;
            if(target < nums[middle]){
                high = middle - 1;
            }
            else if(target > nums[middle]){
                low = middle + 1;
            }
            else{
                pos = middle;
                break;
            }
        }
        while(pos > 0){
            if(nums[pos] == nums[pos-1]){
                pos = pos - 1;
            }
            else{
                break;
            }
        }
        return pos;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,4,4,5,7,7,8,9,9,10};
		System.out.println(binarySearch(arr, 4));
	}

}
