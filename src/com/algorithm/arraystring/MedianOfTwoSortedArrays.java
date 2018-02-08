package com.algorithm.arraystring;

public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
		if(A.length == 0 && B.length == 0) {
			return 0;
		}
		if(A.length == 0 && B.length == 1) {
			return B[0];
		}
		if(B.length == 0 && A.length == 1) {
			return A[0];
		}
		int[] total = generateTotal(A, B);
        
        int[] helper = new int[A.length + B.length];
        
        merge(total, helper, 0, A.length - 1, total.length - 1);
        
        return getMedian(total);

    }
    
    public static int[] generateTotal(int[] A, int[] B){
        int[] total = new int[A.length + B.length];
        int i = 0;
        int index = 0;
        int j = 0;
        while(i < A.length){
            total[index] = A[i];
            i++;
            index++;
        }
        while(j < B.length){
            total[index] = B[j];
            j++;
            index++;
        }
        return total;
    }
    
    public static double getMedian(int[] A){
        if(A.length % 2 == 0){
            double median = ((double)A[A.length/2] + (double)A[A.length/2 - 1]) / 2;
            return median;
        }
        else{
            return (double) A[A.length/2];
        }
    }
    
    public static void merge(int[] a, int[] temp, int low, int middle, int high){
        for(int i = low; i <= high; i++){
            temp[i] = a[i];
        }
        int helperLeft = low;
        int current = low;
        int helperRight = middle+1;
        while(helperLeft <= middle && helperRight <= high){
            if(temp[helperLeft] <= temp[helperRight]){
                a[current] = temp[helperLeft];
                helperLeft++;
            }
            else{
                a[current] = temp[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = middle - helperLeft;
        for(int i = 0; i <= remaining; i++){
            a[current + i] = temp[helperLeft + i];
        }
    }
    
    public static void main(String args[]) {
    	int[] a = {2};
    	int[] b = {1};
    	System.out.println(findMedianSortedArrays(a, b));
    }
}
