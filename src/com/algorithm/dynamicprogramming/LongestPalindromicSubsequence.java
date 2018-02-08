package com.algorithm.dynamicprogramming;

public class LongestPalindromicSubsequence {

	public static int lps(char[] arr){
		int n = arr.length;
		int [][] temp = new int[n][n];
		for(int i = 0; i < n; i++){
			temp[i][i] = 1;
		}
		for(int l = 2; l <= n; l++){
			for(int i = 0; i <= n - l; i++){
				int j = i + l - 1;
				if(arr[i] == arr[j] && l == 2){
					temp[i][j] = 2;
				}
				else if(arr[i] == arr[j] && l != 2){
					temp[i][j] = temp[i+1][j-1] + 2;
				}
				else{
					temp[i][j] = Math.max(temp[i+1][j], temp[i][j-1]);
				}
			}
		}
		return temp[0][n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "agbdba";
		System.out.println(lps(s.toCharArray()));

	}

}
