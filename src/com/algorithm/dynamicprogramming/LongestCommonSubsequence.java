package com.algorithm.dynamicprogramming;

public class LongestCommonSubsequence {
	
	public static String longestCommonSubsequence(String A, String B){
		int [][] temp = new int[A.length()+1][B.length()+1];
		int max = 0;
		int indexOfMaxA = 0;
		int indexOfMaxB = 0;
		for(int i = 1; i <= A.length(); i++){
			for(int j = 1; j <= B.length(); j++){
				if(A.charAt(i-1) == B.charAt(j-1)){
					temp[i][j] = temp[i-1][j-1] + 1;
				}
				else{
					if(temp[i-1][j] >= temp[i][j-1])
						temp[i][j] = temp[i-1][j];
					else
						temp[i][j] = temp[i][j-1];
				}
				if(temp[i][j] > max){
					indexOfMaxA = i;
					indexOfMaxB = j;
					max = temp[i][j];
				}
			}
		}
		
		//get the maximum subsequence
		StringBuilder sb = new StringBuilder();
		int i = indexOfMaxA - 1;
		int j = indexOfMaxB - 1;
		while(i >= 0 && j >= 0){
			if(A.charAt(i) == B.charAt(j)){
				sb.insert(0, A.charAt(i));
				i--;
				j--;
			}
			else{
				if(temp[i][j-1] > temp[i-1][j])
					j--;
				else
					i--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdaf";
		String s2 = "abcbcf";
		System.out.println(longestCommonSubsequence(s1,s2));

	}

}
