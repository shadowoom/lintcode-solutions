package com.algorithm.arraystring;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum(int[] numbers, int target) {
		if(numbers==null || numbers.length<2)
	        return new int[]{0,0};
	 
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i=0; i<numbers.length; i++){
	            if(map.containsKey(numbers[i])){
	                return new int[]{map.get(numbers[i]), i};
	            }else{
	                map.put(target-numbers[i], i);
	            }
	        }
	        return new int[]{0,0};
	}
	public static void main(String[] args) {
		int[]arr = {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(arr, 9)));

	}

}
