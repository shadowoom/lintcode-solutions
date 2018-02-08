package com.algorithm.arraystring;


//Question 1.1

public class IsUnique {
	/*
     * @param str: A string
     * @return: a boolean
     */
   /* method 1
	public boolean isUnique(String str) {
        // write your code here
        boolean result = true;
        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    result = false;
                }
            }
        }
        return result;
    }
    
    */
	
	/* method 2
    public boolean isUnique(String str) {
        // write your code here
        boolean result = true;
        sort(str);
        for(int i = 0; i < str.length(); i++){
            String newStr = str.substring(i+1);
            int index = binarySearch(newStr, str.charAt(i), 0, newStr.length()-1);
            if(index != -1){
                result = false;
            }
            if(result == false){
                return result;
            }
        }
        return result;
    }
    
    //sort the string
    public static void sort(String str){
        char arr[] = str.toCharArray();
		char tempArr[] = new char[arr.length];
		int low = 0;
		int high = arr.length - 1;
		mergeSort(arr, tempArr, low, high);
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
    
    //conduct binary search on the character
    public static int binarySearch(String str, char c, int low, int high){
        int middle = (low + high)/2;
        if(low > high)
            return -1;
        else{
            if(str.charAt(middle) < c)
                return binarySearch(str, c, middle + 1, high);
            else if(str.charAt(middle) > c)
                return binarySearch(str, c, low, middle-1);
            else
                return middle;
        }
    }
    */
	
	/* method 3
	 public boolean isUnique(String str) {
        // write your code here
        boolean [] arr = new boolean[10000];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(arr[val]){
                return false;
            }
            else{
                arr[val] = true;
            }
        }
        return true;
    }
	 */
}
