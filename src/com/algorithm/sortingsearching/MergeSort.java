package com.algorithm.sortingsearching;

public class MergeSort {

	public static String sort(String str) {
		char arr[] = str.toCharArray();
		char tempArr[] = new char[arr.length];
		int low = 0;
		int high = arr.length - 1;
		mergeSort(arr, tempArr, low, high);
		String newStr = "";
		for(int i = 0; i < arr.length; i++) {
			newStr += arr[i];
		}
		return newStr;
	}
	
	public static void mergeSort(char arr[], char temp[], int low, int high) {
		if(low < high) {
			int middle = (high + low) / 2;
			//sort the left part
			mergeSort(arr, temp, low, middle);
			
			
			//sort the right part
			mergeSort(arr, temp, middle + 1, high);
			
			//merge both parts
			merge(arr, temp, low, middle, high);
		}
	}
	
	public static void merge(char arr[], char temp[], int low, int middle, int high) {
		for(int i = low; i <= high; i++) {
			temp[i] = arr[i];
		}
		int left = low;
		int right = middle + 1;
		int current = low;
		
		//swap left and right
		while(left <= middle && right <= high) {
			if(temp[left] <= temp[right]) {
				arr[current] = temp[left];
				left++;
			}
			else {
				arr[current] = temp[right];
				right++;
			}
			current++;
		}
		
		//copy remaining left into arr
		int remain = middle - left;
		for(int i = 0; i <= remain; i++) {
			arr[current + i] = temp[left + i];
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sort("abcdefghijklmnopqrstuvwxyz"));
	}

}
