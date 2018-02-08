package com.algorithm.priorityqueue;

public class UglyNumber {
	
	//method 1 brute force
//	public static int nthUglyNumber(int n) {
//		int number = 1;
//		int count = 1;
//		while(count < n) {
//			number++;
//			if(isUgly(number)) {
//				count++;
//			}
//		}
//		return number;
//	}
//	
//	public static boolean isUgly(int number) {
//		//check for factor 2
//		number = divide(number, 2);
//		//check for factor 3
//		number = divide(number, 3);
//		//check for factor 5
//		number = divide(number, 5);
//		
//		return number == 1? true:false;
//	}
//	
//	public static int divide(int a , int b) {
//		while(a % b == 0) {
//			a = a / b;
//		}
//		return a;
//	}
	
	//method 2 O(n) and space complexity O(n)
	//dynamic programming
	public static int nthUglyNumber(int n) {
		int indexOf2 = 0;
		int indexOf3 = 0;
		int indexOf5 = 0;
		int multipleOf2 = 2;
		int multipleOf3 = 3;
		int multipleOf5 = 5;
		int next_ugly_no = 1;
		int[] ugly_array = new int[n];
		ugly_array[0] = 1;
		for(int i = 1; i < n; i++) {
			next_ugly_no = Math.min(multipleOf2, Math.min(multipleOf3, multipleOf5));
			ugly_array[i] = next_ugly_no;
			if(next_ugly_no == multipleOf2) {
				indexOf2++;
				multipleOf2 = ugly_array[indexOf2] * 2;
			}
			if(next_ugly_no == multipleOf3) {
				indexOf3++;
				multipleOf3 = ugly_array[indexOf3] * 3;
			}
			if(next_ugly_no == multipleOf5) {
				indexOf5++;
				multipleOf5 = ugly_array[indexOf5] * 5;
			}
		}
		return next_ugly_no;
	}
	
	public static void main(String args[]) {
		System.out.println(nthUglyNumber(9));
	}
	
}
