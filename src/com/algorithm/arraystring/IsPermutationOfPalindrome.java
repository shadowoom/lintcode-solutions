package com.algorithm.arraystring;

//Question 1.4

public class IsPermutationOfPalindrome {

	public static void main(String[] args) {
		
		System.out.println(isPermutationOfPalindrome("abcABCabcABCzxcZXC ZXC zxc"));
	}

	//method 1
//	public static boolean isPermutationOfPalindrome(String str) {
//		char[] arr = str.toCharArray();
//		int[] temp = new int[128];
//		for(int i = 0; i < arr.length; i++) {
//			int val = (int) arr[i];
//			if(temp[val] == 1) {
//				temp[val]--;
//			}
//			else {
//				temp[val]++;
//			}
//		}
//		//check count of 1's
//		int count = 0;
//		for(int i = 0; i < temp.length; i++) {
//			if(temp[i] > 0) {
//				count ++;
//			}
//			if(count > 1) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	//method 2
	public static boolean isPermutationOfPalindrome(String str) {
		char[] arr = str.toCharArray();
		int bitVector = 0;
		for(int i = 0; i < arr.length; i++) {
			int index = (int) arr[i];
			int temp = 1 << index;
			if((bitVector & temp) == 0) {
				bitVector |= temp;
			}
			else {
				bitVector &= ~temp;
			}
		}
		if(bitVector == 0 || (bitVector & (bitVector - 1)) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
