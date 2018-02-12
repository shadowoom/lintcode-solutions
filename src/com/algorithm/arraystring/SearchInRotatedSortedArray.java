package com.algorithm.arraystring;

public class SearchInRotatedSortedArray {
	
	static int searchInRotatedSortedArray(int[]A, int target) {
		int low = 0;
		int high = A.length - 1;
		return searchInRotatedSortedArray(A, low, high, target);
	}
	
	static int searchInRotatedSortedArray(int[]A, int l, int h, int k) {
		if(l > h)
			return -1;
		int m = (h + l) / 2;
		if(A[m] == k)
			return m;
		//left sorted
		else if(A[m] > A[l]) {
			if(k < A[m] && k >= A[l])
				return searchInRotatedSortedArray(A, l, m-1, k);
			else
				return searchInRotatedSortedArray(A, m+1, h, k);
		}
		//right sorted
		else {
			if(k > A[m] && k <= A[h])
				return searchInRotatedSortedArray(A, m+1, h, k);
			else
				return searchInRotatedSortedArray(A, l, m-1, k);
		}
	}
	
}
