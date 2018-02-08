package com.algorithm.arraystring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TripletSum {
	//naive method n to the power of 3
//	public static List<List<Integer>> threeSum(int[] number){
//		int n = number.length;
//		List<List<Integer>> resultSet = new ArrayList<>();
//		for(int i = 0; i <= n - 3; i++){
//			for(int j = i + 1; j <= n - 2; j++){
//				for(int k = j + 1; k <= n - 1; k++){
//					if(number[i] + number[j] + number[k] == 0){
//						ArrayList<Integer> temp = new ArrayList<Integer>();
//						temp.add(number[i]);
//						temp.add(number[j]);
//						temp.add(number[k]);
//						Collections.sort(temp);
//						if(!resultSet.contains(temp)){
//							resultSet.add(temp);
//						}
//					}
//				}
//			}
//		}
//		return resultSet;
//	}
	
	public static List<List<Integer>> threeSum(int[] number){
		List<List<Integer>> resultSet = new ArrayList<>();
		for(int i = 0; i < number.length; i++){
			int remaining = 0 - number[i];
			ArrayList<int []> result = obtainTwoSum(number, i, remaining);
			for(int j = 0; j < result.size(); j++){
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.add(number[i]);
				tempList.add(number[result.get(j)[0]]);
				tempList.add(number[result.get(j)[1]]);
				Collections.sort(tempList);
				if(!resultSet.contains(tempList)){
					resultSet.add(tempList);
				}
			}
		}
		return resultSet;
	}
	
	public static ArrayList<int[]> obtainTwoSum(int[] arr, int i, int target){
		ArrayList<int[]> resultList  = new ArrayList<int[]>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int k = i + 1; k < arr.length; k++){
			if(!map.containsKey(arr[k])){
				int remain = target - arr[k];
				map.put(remain, k);
			}
			else{
				int[] newArr = new int[2];
				newArr[0] = map.get(arr[k]);
				newArr[1] = k;
				resultList.add(newArr);
			}
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum(new int[]{2,-1, -1, 7, -4, -3, 11, -6, -5, 15}));
	}

}
