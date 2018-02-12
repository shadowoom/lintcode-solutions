package com.algorithm.arraystring;

//assume no duplicates
public class FindMinimumInRotatedSortedArrayII {
	
	public int findMin(int[] nums) {
        // write your code here
        int l = 0;
        int h = nums.length - 1;
        while(l <= h){
            //when array size = 1;
            if(l == h){
                return nums[l];
            }
            int m = (l+h)/2;
            if(m == l && m != h) {
			    return nums[l] > nums[h]? nums[h]:nums[l];
		    }
            //array size > 2
            //no rotation
            if(nums[m] > nums[l] && nums[m] < nums[h])
                 return nums[l];
            //remove duplicates
            else if(nums[m] == nums[l])
                l++;
            else if(nums[m] == nums[h])
                h--;
            //there is rotation
            else{
                if(nums[m] < nums[m-1])
                    return nums[m];
                else{
                    //left sorted
                    if(nums[m] > nums[l])
                        l = m + 1;
                    //right sorted
                    else
                        h = m - 1;
                }
            }
        }
        return -1;
    }
	
}
