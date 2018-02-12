package com.algorithm.arraystring;

import java.util.List;

public class RecoverRotatedSortedArray {
	
	public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int numberOfRotations = findMin(nums);
        if(numberOfRotations > 0){
            leftRotate(nums, numberOfRotations, nums.size());
        }
    }
    
    public static int findMin(List<Integer> nums) {
        // write your code here
        int l = 0;
        int h = nums.size() - 1;
        while(l <= h){
            //when array size = 1;
            if(l == h){
                return l;
            }
            int m = (l+h)/2;
            if(m == l && m != h) {
			    return nums.get(l) > nums.get(h)? h:l;
		    }
            //array size > 2
            //no rotation
            if(nums.get(m) > nums.get(l) && nums.get(m) < nums.get(h))
                 return l;
            //remove duplicates
            else if(nums.get(m) == nums.get(l))
                l++;
            else if(nums.get(m) == nums.get(h))
                h--;
            //there is rotation
            else{
                if(nums.get(m) < nums.get(m-1))
                    return m;
                else{
                    //left sorted
                    if(nums.get(m) > nums.get(l))
                        l = m + 1;
                    //right sorted
                    else
                        h = m - 1;
                }
            }
        }
        return -1;
    }
    
    public static void leftRotate(List<Integer> nums, int d, int n){
        reverse(nums, 0, d - 1);
		reverse(nums, d, n - 1);
		reverse(nums, 0, n-1);
    }
    
    static void reverse(List<Integer> nums, int start, int end) {
		while(start < end) {
			int temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
			start++;
			end--;
		}
	}
	
}
