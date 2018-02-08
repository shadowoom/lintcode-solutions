package com.algorithm.dynamicprogramming;

public class LongestCommonSubstring {
	
	public static String longestCommonSubstring(String A, String B){
		
		int[][] temp = new int[A.length()+1][B.length()+1];
		int indexOfMax = 0;
		int max = 0;
		for(int i = 1; i <= A.length(); i++){
			for(int j = 1; j <= B.length(); j++){
				if(A.charAt(i-1) == B.charAt(j-1)){
					temp[i][j] = temp[i-1][j-1] + 1;
				}
				if(temp[i][j] > max){
					max = temp[i][j];
					indexOfMax = i;
				}
			}
		}
		return A.substring(indexOfMax - max, indexOfMax);
	}
	
	public static void main(String args[]){
		String s1 = "abcdefghijklmnopy";
		String s2 = "abcvabcdefghijklmnopyz";
		System.out.println(longestCommonSubstring(s1,s2));
	}
}
