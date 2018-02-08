package com.algorithm.arraystring;

import java.util.*;

//Question 1.2

public class CheckPermutation {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int numberOfTest = Integer.parseInt(sc.nextLine().trim());
		int[] result = new int[numberOfTest];
		for(int j = 0; j < numberOfTest; j++){
		    int size = Integer.parseInt(sc.nextLine().trim());
		    int[]arr1 = new int[size];
		    int[]arr2 = new int[size];
		    String str1 = sc.nextLine().trim();
		    String[] strArr1 = str1.split("\\s+");
		    for(int k = 0; k < size; k++){
		        arr1[k] = Integer.parseInt(strArr1[k]);
		    }
		    String str2 = sc.nextLine().trim();
		    String[] strArr2 = str2.split("\\s+");
		    for(int k = 0; k < size; k++){
		        arr2[k] = Integer.parseInt(strArr2[k]);
		    }
		    result[j] = Permutation(arr1, arr2);
		}
		for(int j = 0; j < numberOfTest; j++){
		    System.out.println(result[j]);
		}
		sc.close();
		
	}
	
	 public static int Permutation(int[] A, int[] B) {
        // write your code here
        if(A.length != B.length){
            return 0;
        }
        else{
            int [] arrNewA = new int[A.length];
            int [] arrNewB = new int[B.length];
            mergeSort(A, arrNewA, 0, A.length-1);
            mergeSort(B, arrNewB, 0, B.length-1);
            return checkEqual(A, B);
        }
    }
    
    public static void mergeSort(int[] arr, int[] newArr, int low, int high){
        if(low < high){
            int middle = (low + high) / 2;
            mergeSort(arr, newArr, low, middle);
            mergeSort(arr, newArr, middle+1, high);
            merge(arr, newArr, low, middle, high);
        }
    }
    
    public static void merge(int[] arr, int[] newArr, int low, int middle, int high){
        for(int i = low; i <= high; i++){
            newArr[i] = arr[i];
        }
        int current = low;
        int left = low;
        int right = middle + 1;
        while(left <= middle && right <= high){
            if(newArr[left] <= newArr[right]){
                arr[current] = newArr[left];
                left++;
            }
            else{
                arr[current] = newArr[right];
                right++;
            }
            current++;
        }
        int remain = middle - left;
        for(int i = 0; i <= remain; i++){
            arr[current + i] = newArr[left + i];
        }
    }
    
    public static int checkEqual(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return 0;
            }
        }
        return 1;
    }
}
