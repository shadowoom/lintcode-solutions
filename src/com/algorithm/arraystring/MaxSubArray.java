package com.algorithm.arraystring;

public class MaxSubArray {
	
//	//time complexity of n square
//	public static int maxSubArray(int[] nums) {
//        // write your code here
//        int n = nums.length;
//        int[][] sumArr = new int[n+1][n+1];
//        int max = nums[0];
//        for(int i = 1; i <= n; i++){
//            sumArr[i][i] = nums[i-1];
//            if(sumArr[i][i] > max)
//                max = sumArr[i][i];
//        }
//        for(int i = 1; i < n; i++){
//            for(int j = i+1; j <= n; j++){
//                    sumArr[i][j] = sumArr[i][j-1] + nums[j-1];
//                    if(sumArr[i][j] > max)
//                        max = sumArr[i][j];
//            }
//        }
//        return max;
//    }
	
	public static int maxSubArray(int[] nums) {
        // write your code here
        int[] current = new int[nums.length];
        current[0] = nums[0];
        int max = nums[0];
        int start = 0;
        int end = 0;
        int [] maxIndex = new int[2];
        for(int i = 1; i < nums.length; i++){
        	if(current[i-1] + nums[i] > nums[i]){
        		end = i;
        	}
        	else{
        		start = i;
        		end = i;
        	}
        	current[i] = Math.max(current[i-1] + nums[i], nums[i]);
        	if(current[i] > max){
        		maxIndex[0] = start;
        		maxIndex[1] = end;
        	}
        	max = Math.max(current[i] , max);
        }
        return max;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[]{6, -1 , -7, 9, 8 , 10};
		System.out.println(maxSubArray(arr));

	}

}
