package com.algorithm.arraystring;

//Question 1.3

public class URLify {
	 public static void replaceSpace(char[] arr, int trueLength) {
		 int spaceCount = 0;
		 int index = 0;
		 for(int i = 0; i < trueLength; i++) {
			 if(arr[i] == ' ') {
				 spaceCount++;
			 }
		 }
		 index = trueLength + 2 * spaceCount;
		 
		 for(int i = trueLength - 1; i >= 0; i--) {
			 if(arr[i] != ' ') {
				 arr[index - 1] = arr[i];
				 index--;
			 }
			 else {
				 arr[index - 1] = '0';
				 arr[index - 2] = '2';
				 arr[index - 3] = '%';
				 index = index - 3;
			 }
			 
		 }
	 }
}
