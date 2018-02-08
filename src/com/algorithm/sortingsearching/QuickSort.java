package com.algorithm.sortingsearching;

public class QuickSort {

	public static void quickSort(int[]nums, int left, int right){
        int index = partition(nums, left, right);
        if(left < index - 1){
            quickSort(nums, left, index - 1);
        }
        if(right > index){
            quickSort(nums, index, right);
        }
    }
    
    public static int partition(int[]nums, int left, int right){
        int pivot = nums[(left+right)/2];
        int temp = 0;
        while(left <= right){
            while(nums[left] < pivot) left++;
            while(nums[right] > pivot) right--;
            if(left <= right){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }	

}
