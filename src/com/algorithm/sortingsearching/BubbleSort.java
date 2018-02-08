package com.algorithm.sortingsearching;

public class BubbleSort {

	public static String bubbleSort(String str) {
		//convert string to array
		char arr[] = str.toCharArray();
		
		//bubble sort
		for(int i = arr.length -1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					char temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		//convert array to string
		str = "";
		for(int i = 0; i < arr.length; i++) {
			str += arr[i];
		}
		return str;
	}
	
	public static void main(String[] args) {
		//System.out.println("abcdefghijk");
		System.out.println(bubbleSort("kjihgfedcba"));
	}

}
