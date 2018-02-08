package com.algorithm.dynamicprogramming;

import java.util.ArrayList;

public class SubsetSum {
	
	public static ArrayList<Integer> findSubset(int m, int[]arr){
		ArrayList<Integer> resultSet = new ArrayList<Integer>();
		int n = arr.length;
		boolean[][] temp = new boolean[n+1][m+1];
		for(int i = 0; i <= n; i++){
			temp[i][0] = true;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(arr[i-1] > j)
					temp[i][j] = temp[i-1][j];
				else
					temp[i][j] = temp[i-1][j] || temp[i-1][j-arr[i-1]];
			}
		}
		int k = n;
		int l = m;
		if(temp[k][l]){
			while(k > 0 && l > 0){
				if(!temp[k-1][l]){
					resultSet.add(arr[k-1]);
					l = l - arr[k-1];
				    k = k - 1;
				}
				else{
					k = k - 1;
				}
			}
		}
		return resultSet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubset(30, new int[]{2,3,7,8,10}));

	}

}
