package com.algorithm.sortingsearching;

public class SelectionSort {

	public static String selectionSort(String str) {
		//convert string to array
		char arr[] = str.toCharArray();
		
		//selection sort
		for(int i = 0; i < arr.length; i++) {
			char min = arr[i];
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			//swap
			char temp = arr[i];
			arr[i] = min;
			arr[minIndex] = temp;
		}
		
		//convert array to string
		str = "";
		for(int i = 0; i < arr.length; i++) {
			str += arr[i];
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(selectionSort("kjihgfedcba"));
	}

}
